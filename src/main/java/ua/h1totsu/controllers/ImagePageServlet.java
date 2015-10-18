package ua.h1totsu.controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ua.h1totsu.DAO.DAOImpl.FactoryDAO;
import ua.h1totsu.entity.Image;
import ua.h1totsu.other.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ImagePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int offset = (page - 1) * Data.PAGE_SIZE;
        List<Image> images = FactoryDAO.getInstance().getImageDAO().
                                getAnyImages(offset, Data.PAGE_SIZE);
        JSONObject jsonObject = null;
        JSONArray array = new JSONArray();
        for(Image image : images) {
            jsonObject = JsonUtils.toJSONObject(image);
            array.add(jsonObject);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.getWriter().write(array.toJSONString());
    }

}

package ua.h1totsu.controllers;

import ua.h1totsu.DAO.DAOImpl.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PaginationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int imagesCount = FactoryDAO.getInstance().getImageDAO().getImagesCount();
        int pageCount = (int) Math.ceil((double) imagesCount / Data.PAGE_SIZE);
        response.getWriter().write(String.valueOf(pageCount));
    }
}

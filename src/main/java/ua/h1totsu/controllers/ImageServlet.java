package ua.h1totsu.controllers;

import ua.h1totsu.DAO.DAOImpl.FactoryDAO;
import ua.h1totsu.entity.Image;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.Set;

public class ImageServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int imageId = Integer.valueOf(request.getParameter("img_id"));
        Image image = FactoryDAO.getInstance().getImageDAO().getImageById(imageId);
        //byte[] img = image.getImg();

        OutputStream outputStream = response.getOutputStream();
        //outputStream.write(img);
        outputStream.close();
    }
}

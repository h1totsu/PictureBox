package ua.h1totsu.controllers;

import ua.h1totsu.DAO.DAOImpl.FactoryDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Integer id;
        if((id = FactoryDAO.getInstance().getUserDAO().validate(login, password)) != null) {
            request.getSession().setAttribute("user", id);
            response.getWriter().print("true");
        }
    }
}

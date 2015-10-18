package ua.h1totsu.controllers.filters;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import ua.h1totsu.DAO.DAOImpl.FactoryDAO;
import ua.h1totsu.controllers.Data;
import ua.h1totsu.entity.Image;
import ua.h1totsu.persistence.HibernateUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainContentFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        int imagesCount = FactoryDAO.getInstance().getImageDAO().getImagesCount();
        int pageCount = (int) Math.ceil((double) imagesCount / Data.PAGE_SIZE);
        request.setAttribute("pages", pageCount);
        System.out.println(imagesCount + " " + pageCount);
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}

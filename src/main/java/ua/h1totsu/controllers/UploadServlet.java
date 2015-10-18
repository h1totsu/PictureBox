package ua.h1totsu.controllers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ua.h1totsu.DAO.DAOImpl.FactoryDAO;
import ua.h1totsu.entity.Image;
import ua.h1totsu.entity.Tag;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class UploadServlet extends HttpServlet {
    Map<String, String> paramMap = new HashMap<>();
    byte[] img = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("user");
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            try {
                List<FileItem> items = fileUpload.parseRequest(request);
                Iterator<FileItem> iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = iterator.next();
                    if(item.isFormField()) {
                        paramMap.put(item.getFieldName(), item.getString());
                    } else {
                        img = item.get();
                    }
                }
                Image image = new Image(paramMap.get("description"), new Date());
                image.setTags(Tag.setTagsFromString(paramMap.get("tags")));
                image.setImg(Base64.getEncoder().encodeToString(img));
                image.setUserId((Integer) request.getSession().getAttribute("user"));
                FactoryDAO.getInstance().getImageDAO().insertImage(image);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}

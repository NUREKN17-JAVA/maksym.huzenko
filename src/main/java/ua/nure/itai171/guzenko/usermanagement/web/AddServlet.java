package main.java.ua.nure.itai171.guzenko.usermanagement.web;

import main.java.ua.nure.itai171.guzenko.usermanagement.User;
import main.java.ua.nure.itai171.guzenko.usermanagement.db.DaoFactory;
import main.java.ua.nure.itai171.guzenko.usermanagement.db.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends EditServlet {

    @Override
    protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            req.getRequestDispatcher(BrowseServlet.EDIT_JSP).forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }

    @Override
    protected void processUser(User userToProcess) throws DatabaseException {
        DaoFactory.getInstance().getUserDao().create(userToProcess);
    }
}
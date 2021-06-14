package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}

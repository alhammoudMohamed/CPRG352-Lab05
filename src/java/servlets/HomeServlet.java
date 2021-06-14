package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String logout = request.getParameter("logout");
        HttpSession session = request.getSession();

        if (logout != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("logoutMessage", "Logged out successfuly");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else {

            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                String username = user.getUsername();
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;
import services.AccountService;

/**
 *
 * @author 844568
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("logoutMessage", "Logged out successfuly");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean usernamePasswordNotEmpty = isUsernamePasswordNotEmpty(username, password);

        if (usernamePasswordNotEmpty) {
            AccountService service = new AccountService();
            User user = service.login(username, password);

            if (user == null) {
                request.setAttribute("errorMessage", "Username or password is not right");
                   getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home");
            }
        }
    }

    private boolean isUsernamePasswordNotEmpty(String username, String password) {
        boolean valid = false;
        if (username.equals("") || username == null || password.equals("") || password == null) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

}

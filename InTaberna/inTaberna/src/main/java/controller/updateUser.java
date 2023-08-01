package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.UserDAO;
import model.Utente;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "updateUser", value = "/updateUser")
public class updateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO service = new UserDAO();
        ArrayList<Utente> res = service.doRetriveByEmail(request.getParameter("id"));
        request.setAttribute("utente",res.get(0));
        RequestDispatcher dispatcher = request.getRequestDispatcher("resources/view/modifyUser.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

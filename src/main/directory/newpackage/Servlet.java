package newpackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alessandro on 15/12/2015.
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialversionUID = 1L;

    public Servlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        //request.setAttribute("benvenuto","Hello World");
        //getServletContext().setAttribute("benvenuto","Hello World");
        HttpSession session = request.getSession();
        session.setAttribute("benvenuto","Hello World");

        dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request,response);

        //response.setContentType("text/html");
        //PrintWriter out = response.getWriter();
        //out.println("<h1>Hello world</h1>");
        //out.flush();
    }
}

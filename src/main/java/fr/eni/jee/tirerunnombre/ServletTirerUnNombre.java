package fr.eni.jee.tirerunnombre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/ServletTirerUnNombre")
public class ServletTirerUnNombre extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Random rdn = new Random();

    public ServletTirerUnNombre(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int nbAlea  = rdn.nextInt(10)+1;
        String saisie = request.getParameter("nombre");

        if (saisie.equals(String.valueOf(nbAlea))) {
            request.getRequestDispatcher("Victoire.html").forward(request,response);
        } else {
            request.getRequestDispatcher("Defaite.html").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}

package fr.eni.jee.tirerunnombre;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(
        urlPatterns = "/ServletTirerUnNombre",
        initParams = {
                @WebInitParam(description = "Borne Min",  name = "borneMin", value = "0"),
                @WebInitParam(description = "Borne Max", name = "borneMax", value = "30")
        }
)

public class ServletTirerUnNombre extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Random rdn = new Random();
    private String  borneMax;
    private String  borneMin;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.borneMin = this.getInitParameter("borneMin");
        this.borneMax = this.getInitParameter("borneMax");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int nbAlea  = rdn.nextInt((Integer.parseInt(this.borneMax) - Integer.parseInt(this.borneMin)) + Integer.parseInt(this.borneMin));
        String saisie = request.getParameter("nombre");
        System.out.println(nbAlea);
        System.out.println(saisie);

        if (saisie.equals(String.valueOf(nbAlea))) {
            response.sendRedirect("/TirerUnNombre/Victoire.html");
        } else {
            response.sendRedirect("/TirerUnNombre/Defaite.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}

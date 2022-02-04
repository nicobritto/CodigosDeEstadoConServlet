package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/ServletConectando")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //simular los valores correctos en el caso verdadero estos datos serian de una bdd
        String usuarioOk = "juan";
        String passwordOk="123";
        
        //recibimos los parametros que mando el usuario atravez de request.getParameter
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        
        //abrimos el objeto PrintWriter para mandar info al usuario
        PrintWriter out=response.getWriter();
        
        if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
            out.print("<h1>");
            out.print("Datos Correctos");
            out.print("<br>Usuario: "+usuario);
            out.print("<br>Password: "+password);
            out.print("</h1>");
        }else{
            response.sendError(response.SC_UNAUTHORIZED,"Las credenciales son incorrectas");
        }
        out.close();
    }

}

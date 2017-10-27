package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio11", urlPatterns = {"/GerenciaExercicio11"})
public class GerenciaExercicio11 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        String acao = request.getParameter("acao");
        try {
            switch (acao) {
                case "Calcular":
                    Integer numero = Integer.valueOf(request.getParameter("numero"));
                    List numeros = new ArrayList();
                    for (int i = 1; i <= numero; i++) {
                        numeros.add(i);
                    }
                    request.setAttribute("numeros", numeros);
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio11.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio11.jsp';</script></body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

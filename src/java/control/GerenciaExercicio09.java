package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio09", urlPatterns = {"/GerenciaExercicio09"})
public class GerenciaExercicio09 extends HttpServlet {

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
                    String data = request.getParameter("data");
                    Integer anos = Integer.valueOf(String.valueOf(data.charAt(0)) + String.valueOf(data.charAt(1)) + String.valueOf(data.charAt(2)) + String.valueOf(data.charAt(3)));
                    Integer meses = Integer.valueOf(String.valueOf(data.charAt(5)) + String.valueOf(data.charAt(6)));
                    Integer dias = Integer.valueOf(String.valueOf(data.charAt(8)) + String.valueOf(data.charAt(9)));
                    Integer diasvividos = (2017 - anos) * 365 + meses * 30 + dias;
                    request.setAttribute("dias", String.valueOf(diasvividos));
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio09.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio09.jsp';</script></body></html>");
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

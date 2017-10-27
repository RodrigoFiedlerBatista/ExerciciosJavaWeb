package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio08", urlPatterns = {"/GerenciaExercicio08"})
public class GerenciaExercicio08 extends HttpServlet {

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
                    Float valor = Float.valueOf(request.getParameter("valor"));
                    String parcelas = null;
                    if (valor <= 100) {
                        parcelas = "0";
                    } else if (valor <= 200) {
                        parcelas = "1";
                    } else if (valor <= 400) {
                        parcelas = "2";
                    } else if (valor <= 600) {
                        parcelas = "3";
                    } else if (valor > 600) {
                        parcelas = "4";
                    }
                    request.setAttribute("parcelas", String.valueOf(parcelas));
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio08.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio08.jsp';</script></body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

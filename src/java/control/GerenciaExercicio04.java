package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio04", urlPatterns = {"/GerenciaExercicio04"})
public class GerenciaExercicio04 extends HttpServlet {

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
            switch (acao){
                case "Executar":
                    Integer numero1 = Integer.valueOf(request.getParameter("numero1"));
                    Integer numero2 = Integer.valueOf(request.getParameter("numero2"));
                    String divisiveis = null;
                    if (numero1 >= numero2) {
                        if (numero1 % numero2 == 0) {
                            divisiveis = "São divisiveis!";
                        } else {
                            divisiveis = "Não são divisiveis!";
                        }
                    } else if (numero1 < numero2) {
                        if (numero2 % numero1 == 0) {
                            divisiveis = "São divisiveis!";
                        } else {
                            divisiveis = "Não são divisiveis!";
                        }
                    }
                    request.setAttribute("mensagem", divisiveis);
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio04.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio04.jsp';</script></body></html>");
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

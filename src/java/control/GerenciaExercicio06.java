package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio06", urlPatterns = {"/GerenciaExercicio06"})
public class GerenciaExercicio06 extends HttpServlet {

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
                case "Calcular":
                    String comida = request.getParameter("comida");
                    String bebida = request.getParameter("bebida");
                    Integer qtd_comida = Integer.valueOf(request.getParameter("qtd_comida"));
                    Integer qtd_bebida = Integer.valueOf(request.getParameter("qtd_bebida"));
                    Double total = null;
                    switch (comida) {
                        case "Pao de queijo":
                            total =+ 2.3 * qtd_comida;
                        break;
                        case "Misto Quente":
                            total =+ 1.5 * qtd_comida;
                        break;
                        case "Bauru":
                            total =+ 2.5 * qtd_comida;
                        break;
                        default:
                            System.out.println("Erro no switch. 2");
                    }
                    switch (bebida) {
                        case "Refrigerante":
                            total =+ 1.8 * qtd_bebida;
                        break;
                        case "Cerveja":
                            total =+ 2.5 * qtd_bebida;
                        break;
                        case "Suco":
                            total =+ 3.0 * qtd_bebida;
                        break;
                        default:
                            System.out.println("Erro no switch. 3");
                    }
                    request.setAttribute("total", String.valueOf(total));
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio06.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio06.jsp';</script></body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

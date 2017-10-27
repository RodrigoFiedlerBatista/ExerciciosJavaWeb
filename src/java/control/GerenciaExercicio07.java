package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio07", urlPatterns = {"/GerenciaExercicio07"})
public class GerenciaExercicio07 extends HttpServlet {

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
                    Float numero1 = Float.valueOf(request.getParameter("numero1"));
                    Float numero2 = Float.valueOf(request.getParameter("numero2"));
                    String op = request.getParameter("operacao");
                    Float resultado = null;
                    switch (op) {
                        case "+":
                            resultado = numero1 + numero2;
                        break;
                        case "-":
                            resultado = numero1 - numero2;
                        break;
                        case "*":
                            resultado = numero1 * numero2;
                        break;
                        case "/":
                            resultado = numero1 / numero2;
                        break;
                        default:
                            System.out.println("Erro no switch. 2");
                    }
                    request.setAttribute("resultado", String.valueOf(resultado));
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio07.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio07.jsp';</script></body></html>");
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

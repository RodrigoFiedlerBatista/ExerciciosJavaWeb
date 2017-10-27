package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio02", urlPatterns = {"/GerenciaExercicio02"})
public class GerenciaExercicio02 extends HttpServlet {

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
        try {
            String acao = request.getParameter("acao");
            if (request.getParameter("numero1").equals("")) {
                out.println("<html><body><script>alert('Digite o número 1!');location.href='exercicio02.jsp';</script></body></html>");
            } else if (request.getParameter("numero2").equals("")) {
                out.println("<html><body><script>alert('Digite o número 2!');location.href='exercicio02.jsp';</script></body></html>");
            } else if (request.getParameter("numero3").equals("")) {
                out.println("<html><body><script>alert('Digite o número 3!');location.href='exercicio02.jsp';</script></body></html>");
            } else {
                System.out.println(acao);
                switch(acao){
                    case "Menor Numero":
                        Integer numero1 = Integer.valueOf(request.getParameter("numero1"));
                        Integer numero2 = Integer.valueOf(request.getParameter("numero2"));
                        Integer numero3 = Integer.valueOf(request.getParameter("numero3"));
                        Integer menor = null;
                        if (numero1 <= numero2 && numero1 <= numero3) {
                            menor = numero1;
                        } else if (numero2 <= numero1 && numero2 <= numero3) {
                            menor = numero2;
                        } else if (numero3 <= numero1 && numero3 <= numero2) {
                            menor = numero3;
                        }
                        if (menor == null) {
                            request.setAttribute("menor", "Sem valor");
                        } else {
                            request.setAttribute("menor", String.valueOf(menor));
                        }
                        RequestDispatcher rd = request.getRequestDispatcher("exercicio02.jsp");
                        rd.forward(request, response);
                    break;
                    default:
                        System.out.println("Erro no switch!");
                }
            }
            
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio02.jsp';</script></body></html>");
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

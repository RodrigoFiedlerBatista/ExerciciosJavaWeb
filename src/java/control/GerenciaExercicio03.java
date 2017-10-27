package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio03", urlPatterns = {"/GerenciaExercicio03"})
public class GerenciaExercicio03 extends HttpServlet {

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
            switch(acao){
                case("Executar"):
                    Integer numero1 = Integer.valueOf(request.getParameter("numero1"));
                    Integer numero2 = Integer.valueOf(request.getParameter("numero2"));
                    Integer numero3 = Integer.valueOf(request.getParameter("numero3"));
                    Integer maior = null;
                    Integer meio = null;
                    Integer menor = null;
                    if (numero1 >= numero2 && numero1 >= numero3) {
                        maior = numero1;
                        if (numero2 >= numero3) {
                            meio = numero2;
                            menor = numero3;
                        } else {
                            meio = numero3;
                            menor = numero2;
                        }
                    } else if (numero2 >= numero1 && numero2 >= numero3) {
                        maior = numero2;
                        if (numero1 >= numero3) {
                            meio = numero1;
                            menor = numero3;
                        } else {
                            meio = numero3;
                            menor = numero1;
                        }
                    } else if (numero3 >= numero1 && numero3 >= numero2) {
                        maior = numero3;
                        if (numero1 >= numero2) {
                            meio = numero1;
                            menor = numero2;
                        } else {
                            meio = numero2;
                            menor = numero1;
                        }
                    }
                    request.setAttribute("terceiro", String.valueOf(maior));
                    request.setAttribute("segundo", String.valueOf(meio));
                    request.setAttribute("primeiro", String.valueOf(menor));
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio03.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");;
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio03.jsp';</script></body></html>");
        }
            
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

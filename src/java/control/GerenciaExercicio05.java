package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio05", urlPatterns = {"/GerenciaExercicio05"})
public class GerenciaExercicio05 extends HttpServlet {

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
                case "Executar":
                    String nome = request.getParameter("nome");
                    Float nota1 = Float.valueOf(request.getParameter("nota1"));
                    Float nota2 = Float.valueOf(request.getParameter("nota2"));
                    Float nota3 = Float.valueOf(request.getParameter("nota3"));
                    Float nota4 = Float.valueOf(request.getParameter("nota4"));
                    Float media = (nota1 + nota2 + nota3 + nota4)/4;
                    String mensagem;
                    if (media > 7) {
                        mensagem = nome + " Aprovado.";
                    } else if (media < 4) {
                        mensagem = nome + " Reprovado.";
                    } else {
                        mensagem = nome + " Em Exame.";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("nome", nome);
                    request.setAttribute("media", String.valueOf(media));
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio05.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio05.jsp';</script></body></html>");
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

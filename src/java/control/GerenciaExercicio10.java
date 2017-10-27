package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio10", urlPatterns = {"/GerenciaExercicio10"})
public class GerenciaExercicio10 extends HttpServlet {

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
                    Float nota1 = Float.valueOf(request.getParameter("nota1"));
                    Float nota2 = Float.valueOf(request.getParameter("nota2"));
                    Float nota3 = Float.valueOf(request.getParameter("nota3"));
                    Float soma = nota1 + nota2 + nota3;
                    Float falta = 24 - soma;
                    String mensagem;
                    if (soma >= 24) {
                        mensagem = "Aluno Aprovado!";
                    } else if (soma < 14) {
                        mensagem = "Aluno em Recuperação! Faltam " + falta + " para passar.";
                    } else {
                        mensagem = "Faltam " + falta + " pontos para passar!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio10.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio10.jsp';</script></body></html>");
        }
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

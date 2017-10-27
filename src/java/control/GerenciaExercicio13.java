package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio13", urlPatterns = {"/GerenciaExercicio13"})
public class GerenciaExercicio13 extends HttpServlet {

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
                    Double numeros[] = new Double [5];
                    numeros[0] = Double.valueOf(request.getParameter("numero1"));
                    numeros[1] = Double.valueOf(request.getParameter("numero2"));
                    numeros[2] = Double.valueOf(request.getParameter("numero3"));
                    numeros[3] = Double.valueOf(request.getParameter("numero4"));
                    numeros[4] = Double.valueOf(request.getParameter("numero5"));
                    Double soma = 0.0;
                    for (int i = 0; i < 5; i++) {
                        soma += numeros[i];
                    }
                    Double media = soma / 5;
                    request.setAttribute("media", String.valueOf(media));
                    RequestDispatcher rd = request.getRequestDispatcher("exercicio13.jsp");
                    rd.forward(request, response);
                break;
                default:
                    System.out.println("Erro no switch.");
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            System.out.println(e);
            out.println("<html><body><script>alert('Erro durante o processo, verifique os valores!');location.href='exercicio13.jsp';</script></body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

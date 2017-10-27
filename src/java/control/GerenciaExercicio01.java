package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciaExercicio01", urlPatterns = {"/GerenciaExercicio01"})
public class GerenciaExercicio01 extends HttpServlet {

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
        switch(acao){
            case "Calcular":
                try {
                    if (request.getParameter("altura").equals("")) {
                        out.println("<html><body><script>alert('Digite uma altura valida!');location.href='exercicio01.jsp';</script></body></html>");
                    } else if (request.getParameter("sexo") == null) {
                        out.println("<html><body><script>alert('Selecione o sexo!');location.href='exercicio01.jsp';</script></body></html>");
                    } else {
                        Double altura = Double.valueOf(request.getParameter("altura"));
                        String sexo = request.getParameter("sexo");
                        double peso;
                        if (sexo.equals("Masculino")) {
                            peso = (altura * 72.7) - 58;
                        } else {
                            peso = (altura * 62.1) - 44.7;
                        }
                        DecimalFormat df = new DecimalFormat("#0.00");
                        String pesoFinal = df.format(peso);
                        request.setAttribute("peso", pesoFinal);
                        //out.println("<html><body><% String peso = (String) request.getAttribute('peso'); %><script>alert('Peso ideal:' + <%= peso %> + '!');location.href='exercicio01.jsp';</script></body></html>");
                        RequestDispatcher rd = request.getRequestDispatcher("exercicio01.jsp");
                        rd.forward(request, response);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    out.println("<html><body><script>alert('Erro durante a operação, verifique os valores!');location.href='exercicio01.jsp';</script></body></html>");
                }
                
            break;
            default:
                System.out.println("Erro Switch.");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

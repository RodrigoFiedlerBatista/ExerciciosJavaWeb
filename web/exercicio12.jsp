<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 12</title>
        <%--<script language="JavaScript" src="scripts/somenteNumero.js"></script> --%>
        <script>
            function numero1A10(input){
                if (input.value < 1 || input.value > 10) {
                    alert("Somente números de 1 a 10!");
                    input.value = "";
                }
            }
            
            function SomenteNumeroPositivo(e) {
                var tecla = (window.event) ? event.keyCode : e.which;
                if ((tecla > 47 && tecla < 58)) {
                    return true;
                } else {
                    if (tecla === 8 || tecla === 0)
                        return true;
                    else
                        return false;
                }
            }
        </script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio12" method="post">
                Tabuada de 1 a 10:<br>
                <input type="text" name="numero" placeholder="Numero" required onkeypress="return SomenteNumeroPositivo(event);" onblur="numero1A10(this);" />
                <input type="submit" name="acao" value="Calcular" />
            </form>
            Resposta:<br>
            <% 
            String numero = (String) request.getAttribute("numero");
            List<Integer> respostas = (List) request.getAttribute("respostas");
            if (numero != null || respostas != null) {
                for (int i = 0; i < respostas.size(); i++) {
            %>
            <%= numero %> x <%= i + 1 %> = <%= respostas.get(i) %><br>
            <%
                }
            }
            %>
        </div>
    </body>
</html>

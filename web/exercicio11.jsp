<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 11</title>
        <%--<script language="JavaScript" src="scripts/somenteNumero.js"></script> --%>
        <script>
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
            <form action="GerenciaExercicio11" method="post">
                Mostrar números de 1 até o valor inserido:<br>
                <input type="text" name="numero" placeholder="Numero" onkeypress="return SomenteNumeroPositivo(event);" required /><br>
                <input type="submit" value="Calcular" name="acao" />
                <a href="home.jsp"><input type="button" value="Voltar"></a>
            </form>
            Números:<br>
            <% 
            List numeros = (List) request.getAttribute("numeros");
            if (numeros != null) {
                for (int i = 0; i < numeros.size(); i++) {
            
            %>
            <%= numeros.get(i) %><br>
            <%
                }
            }
            %>
        </div>
    </body>
</html>

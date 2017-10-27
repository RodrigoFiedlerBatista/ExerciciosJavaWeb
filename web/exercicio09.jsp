<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 09</title>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio09" method="post">
                Quantos dias você viveu?<br>
                Data de nascimento: 
                <input type="date" name="data" /><br>
                <input type="submit" name="acao" value="Calcular" />
            </form>
            <br>
            <%
            String dias = (String) request.getAttribute("dias");
            if (dias == null) {
                dias = "Não calculado.";
            }
            %>
            Dias: <%= dias %>
        </div>
    </body>
</html>

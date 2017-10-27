<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 08</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio08" method="post">
                <input type="text" name="valor" placeholder="Valor Devido" onkeypress="return SomenteNumeroPonto(event);" required /><br>
                <input type="submit" name="acao" value="Calcular" />
            </form>
        </div>
        <br>
        <%
        String parcelas = (String) request.getAttribute("parcelas");
        if (parcelas == null) {
            parcelas = "Não calculado.";
        }
        %>
        Parcelas: <%= parcelas %>
    </body>
</html>

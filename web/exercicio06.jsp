<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 06</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <form action="GerenciaExercicio06" method="post">
            Comida:
            <select name="comida">
                <option value="Pao de queijo"> Pão de Queijo </option>
                <option value="Misto Quente"> Misto Quente </option>
                <option value="Bauru"> Bauru </option>
            </select>
            <input type="text" name="qtd_comida" placeholder="Quantidade" onkeypress="return SomenteNumero(event)" required />
            <br>
            Bebida:
            <select name="bebida">
                <option value="Refrigerante"> Refrigerante </option>
                <option value="Cerveja"> Cerveja </option>
                <option value="Suco"> Suco </option>
            </select>
            <input type="text" name="qtd_bebida" placeholder="Quantidade" onkeypress="return SomenteNumero(event)" required />
            <br>
            <input type="submit" value="Calcular" name="acao" />
        </form>
        <%
        String total = (String) request.getAttribute("total");
        if (total == null) {
            total = "Não calculado.";
        }
        %>
        <br>
        Total: <%= total %>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 02</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio02" method="post">
                Qual é o menor número inteiro?<br>
                <input type="text" placeholder="Número 1" name="numero1" onkeypress="return SomenteNumero(event);"><br>
                <input type="text" placeholder="Número 2" name="numero2" onkeypress="return SomenteNumero(event);"><br>
                <input type="text" placeholder="Número 3" name="numero3" onkeypress="return SomenteNumero(event);"><br>
                <input type="submit" value="Menor Numero" name="acao">
            </form>
            <% String menor = (String) request.getAttribute("menor");
            if (menor == null) {
                menor = "Não calculado.";
            }
            %>
            Menor número: <%= menor %>
        </div>
    </body>
</html>

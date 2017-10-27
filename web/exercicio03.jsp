<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 03</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio03" method="post">
                Colocar números em ordem crescente<br>
                <input type="text" name="numero1" placeholder="Numero 01" onkeypress="return SomenteNumero(event)"/><br>
                <input type="text" name="numero2" placeholder="Numero 02" onkeypress="return SomenteNumero(event)"/><br>
                <input type="text" name="numero3" placeholder="Numero 03" onkeypress="return SomenteNumero(event)"/><br>
                <input type="submit" name="acao" value="Executar"/>
                <a href="home.jsp"><input type="button" value="Voltar"></a>
            </form>
            <%
            String primeiro = (String) request.getAttribute("primeiro");
            String segundo = (String) request.getAttribute("segundo");
            String terceiro = (String) request.getAttribute("terceiro");
            String igual = "Não calculado.";
            if (request.getAttribute("primeiro") == null) {
                primeiro = "Não calculado.";
            }
            if (request.getAttribute("segundo") == null) {
                segundo = "Não calculado.";
            }
            if (request.getAttribute("terceiro") == null) {
                terceiro = "Não calculado.";    
            }
            if (primeiro.equals(segundo)) {
                igual = primeiro;
            } else if (segundo.equals(terceiro)) {
                igual = segundo;
            } else {
                igual = "Não há números iguais.";
            }
            %>
            Primeiro: <%= primeiro %><br>
            Segundo: <%= segundo %><br>
            Terceiro: <%= terceiro %><br>
            Números iguais: <%= igual %><br>
        </div>
    </body>
</html>

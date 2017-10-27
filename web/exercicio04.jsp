<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 04</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio04" method="post">
                O maior número é divisivel pelo menor?<br>
                <input type="text" name="numero1" placeholder="Numero 01" onkeypress="return SomenteNumero(event)"/><br>
                <input type="text" name="numero2" placeholder="Numero 02" onkeypress="return SomenteNumero(event)"/><br>
                <input type="submit" name="acao" value="Executar"/>
                <a href="home.jsp"><input type="button" value="Voltar"></a>
            </form>
            <% 
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem == null) {
                mensagem = "Não calculado";
            }
            %>
            Resposta: <%= mensagem %><br>
        </div>    
    </body>
</html>

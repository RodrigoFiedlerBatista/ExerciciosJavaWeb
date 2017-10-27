<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 05</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio05" method="post">
                O aluno está aprovado ou reprovado?<br>
                <input type="text" name="nome" placeholder="Nome" required /><br>
                <input type="text" name="nota1" placeholder="Nota 01" onkeypress="return SomenteNumeroPonto(event)" required /><br>
                <input type="text" name="nota2" placeholder="Nota 02" onkeypress="return SomenteNumeroPonto(event)" required /><br>
                <input type="text" name="nota3" placeholder="Nota 03" onkeypress="return SomenteNumeroPonto(event)" required /><br>
                <input type="text" name="nota4" placeholder="Nota 04" onkeypress="return SomenteNumeroPonto(event)" required/><br>
                <input type="submit" name="acao" value="Executar"/>
                <a href="home.jsp"><input type="button" value="Voltar"></a>
            </form>
            <%
            String nome = (String) request.getAttribute("nome");
            String media = (String) request.getAttribute("media");
            String mensagem = (String) request.getAttribute("mensagem");
            if (nome == null) {
                nome = "Não calculado.";
            }
            if (media == null) {
                media = "Não calculado.";
            }
            if (mensagem == null) {
                mensagem = "";
            }
            %>
            Nome: <%= nome %> <br>
            Média: <%= media %> <br>
            <%= mensagem %> <br>
        </div>
    </body>
</html>

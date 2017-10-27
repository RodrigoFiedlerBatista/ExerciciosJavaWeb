<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 10</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
        <script>
            function valorMaximo(e){
                if (e.value > 10 || e.value < 0) {
                    e.value = "";
                }
            }
        </script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio10" method="post">
                Quantos pontos faltam para atingir a média? <br>
                <input type="text" name="nota1" placeholder="Nota 01" onkeypress="return SomenteNumero(event)" onblur="valorMaximo(this);" required /><br>
                <input type="text" name="nota2" placeholder="Nota 02" onkeypress="return SomenteNumero(event)" onblur="valorMaximo(this);" required /><br>
                <input type="text" name="nota3" placeholder="Nota 03" onkeypress="return SomenteNumero(event)" onblur="valorMaximo(this);" required /><br>
                <input type="submit" name="acao" value="Calcular" />
                <a href="home.jsp"><input type="button" value="Voltar"></a>
            </form>
            <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem == null) {
                mensagem = "Não calculado.";
            }
            %>
            Resultado: <%= mensagem %>
        </div>
    </body>
</html>

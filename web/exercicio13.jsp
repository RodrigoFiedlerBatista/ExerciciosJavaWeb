<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 13</title>
        <script>
            function SomenteNumero(e) {
                var tecla = (window.event) ? event.keyCode : e.which;
                if ((tecla > 47 && tecla < 58 || tecla === 45)) {
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
            <form action="GerenciaExercicio13" method="post">
                Média de 5 números:<br>
                <input type="text" placeholder="Numero 1" name="numero1" onkeypress="return SomenteNumero(event);" required /><br>
                <input type="text" placeholder="Numero 2" name="numero2" onkeypress="return SomenteNumero(event);" required /><br>
                <input type="text" placeholder="Numero 3" name="numero3" onkeypress="return SomenteNumero(event);" required /><br>
                <input type="text" placeholder="Numero 4" name="numero4" onkeypress="return SomenteNumero(event);" required /><br>
                <input type="text" placeholder="Numero 5" name="numero5" onkeypress="return SomenteNumero(event);" required /><br>
                <input type="submit" value="Calcular" name="acao" />
                <a href="home.jsp"><input type="button" value="Voltar"></a>
            </form>
            Média: 
            <%
            String media = (String) request.getAttribute("media");
            if (media == null) {
                media = "Não calculado.";
            }
            %>
            <%= media %>
        </div>
    </body>
</html>

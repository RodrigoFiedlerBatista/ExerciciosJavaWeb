<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 01</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio01" method="post">
                Altura deve ser digitada com ponto e somente números. Exemplo: 1.70
                <br>
                <input type="text" name="altura" placeholder="Altura" onkeypress="return SomenteNumeroPonto(event);">
                <br>
                Sexo:
                <br>
                <input type="radio" value="Masculino" name="sexo"> Masculino
                <br>
                <input type="radio" value="Feminino" name="sexo"> Feminino
                <br>
                <input type="submit" value="Calcular" name="acao">
            </form>
            <br>
            <% 
            String peso = (String) request.getAttribute("peso");
            if (peso == null) {
                peso = "Não calculado";
            }
            
            %>
            Peso ideal: <%= peso %>
        </div>
    </body>
</html>

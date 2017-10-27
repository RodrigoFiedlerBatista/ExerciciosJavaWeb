<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercicio 07</title>
        <script language="JavaScript" src="scripts/somenteNumero.js"></script>
    </head>
    <body>
        <div>
            <form action="GerenciaExercicio07" method="post">
                <input type="text" name="numero1" placeholder="Numero 01" onkeypress="return SomenteNumero(event);" /><br>
                <input type="text" name="numero2" placeholder="Numero 02" onkeypress="return SomenteNumero(event);" /><br>
                Operação:
                <select name="operacao">
                    <option value="+"> + </option>
                    <option value="-"> - </option>
                    <option value="*"> * </option>
                    <option value="/"> / </option>
                </select>
                <br>
                <input type="submit" name="acao" value="Calcular" />
            </form>
            <%
            String resultado = (String) request.getAttribute("resultado");
            if (resultado == null) {
                resultado = "Não calculado.";
            }
            %>
            <br>
            Resultado: <%= resultado %> <br>
        </div>
    </body>
</html>

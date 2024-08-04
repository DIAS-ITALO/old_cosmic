<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cosmic</title>
    </head>
    <body>
        <h1>Cadastro de Categoria</h1>
        <hr>
        <p>${mensagem}</p>
        <hr>
        <form name="cadastrar" action="CadastrarCategoria" method="post">
            <tr>
                <td>
                    <label for="nome">Nome:</label>
                </td>
                <td>
                    <input type="text" name="nomeCategoria">
                </td>
            </tr>
            <tr>
                <td colspan="2" > <input type="submit" name="cadastrar" value="Cadastrar"></td>
            </tr>
        </form>
        <hr>
        <a href="homeadm.jsp">Voltar</a>
    </body>
</html>

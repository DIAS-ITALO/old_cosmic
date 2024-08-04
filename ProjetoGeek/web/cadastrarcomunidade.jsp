<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar cliente
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cosmic</title>
    </head>
    <body>
        <h1>Cadastro de Comunidade</h1>
        <hr>
        <p>${mensagem}</p>
        <hr>
        <form name="cadastrar" action="CadastrarComunidade" method="post">
            <tr>
                <td>
                    <label for="nome">Nome:</label>
                </td>
                <td>
                    <input type="text" name="nomeComunidade">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="descricao">Descrição:</label>
                </td>
                <td>
                    <input type="text" name="descricaoComunidade">
                </td>
            </tr>
            <tr>
                <td><label for="categoria">Categoria:</label></td>
                <td>
                    <select name="idCategoria">
                        <c:forEach var="categoria" items="${categorias}"> <!-- tudo isso vai se repetir até todas as profissões cadastradas/armazenadas em profissoes forem imprimidas -->
                            <option value="${categoria.idCategoria}">
                                ${categoria.nomeCategoria}
                            </option>
                        </c:forEach>
                        <!-- se o forEach não estiver azul escuro, coloca o cursor no meio da palavra e aperte control+space -->
                    </select>
                </td> 
            </tr>
            <tr>
                <td>
                    <label for="idusuario">Moderador Mestre:</label>
                </td>
                <td>
                    <input name="idUsuario" value="${usuario.idUsuario}" readonly="true">
                </td>
            </tr>
            
            
            <tr>
                <td colspan="2" > <input type="submit" name="cadastrar" value="Cadastrar"></td>
            </tr>
        </form>
        <hr>
        <a href="home.jsp">Voltar</a>
    </body>
</html>
<%
    }
%>
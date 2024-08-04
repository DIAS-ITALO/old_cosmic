<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar usuário
%>

<%@page import="br.com.projetousuario.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetousuario.model.Comunidade"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Comunidade</title>

        <link rel="stylesheet" href="assets/css/carregarcomunidade.css">
    </head>
    <body>
        <section class="nav-bar">
            <div class="nav-box">

                <div class="bloco-logo">
                    <a href="desenvolvimento.jsp"><img class="btn btn-sobre" src="assets/img/logo-simbolo.png"/></a>
                </div>

                <div class="nav-main">
                    <a href="LogarUsuario?emailUsuario=${usuario.emailUsuario}&senhaUsuario=${usuario.senhaUsuario}">
                        <img class="btn btn-home" src="assets/img/btn-home.png"/>
                    </a>
                    <a href="ListarComunidades"><img class="btn btn-comunidades" src="assets/img/btn-comunidades.png"/></a>
                    <a href="ListarUsuarios"><img class="btn btn-lista-usuarios" src="assets/img/btn-lista-usuarios.png"/></a>
                    <a href="desenvolvimento.jsp"><img class="btn btn-noturno" src="assets/img/btn-noturno.png"/></a>
                </div>

                <div class="nav-config">
                    <a href="#"><img class="btn btn-config" src="assets/img/config.png"/></a>
                    <a href="index.jsp"><img class="btn btn-sair" src="assets/img/btn-sair.png"/></a>
                </div>
            </div>
        </section>

        <section class="main-content">

            <div class="barra-topo">
                <h1>Minhas Comunidades</h1>
                <div>
                    <h2>Pesquisar</h2>
                    <img class="btn-lupa" src="assets/img/btn-lupa.png"/>
                </div>
                <a href="#"><img class="btn-perfil" src="assets/img/userprofile.png"/></a>

            </div>

            <div class="lista-comunidades">


                <form name="cadastrarcomunidade" action="AlterarComunidade" method="post" class="campo-comunidade">

                    <div class="ocultar">
                        <input type="number" name="idComunidade" id="idcomunidade" readonly="true" value="${comunidade.idComunidade}"/>
                        <input type="number" name="idUsuario" id="idusuario" readonly="true" value="${usuario.idUsuario}"/>
                    </div>

                    <input type="text" name="nomeComunidade" id="nome" value="${comunidade.nomeComunidade}"/> 

                    <input type="text" name="descricaoComunidade" id="descricao" value="${comunidade.descricaoComunidade}"/> 

                    <select name="idCategoria">
                        <c:forEach var="categoria" items="${categorias}"> <!-- tudo isso vai se repetir até todas as profissões cadastradas/armazenadas em profissoes forem imprimidas -->
                            <option value="${categoria.idCategoria}">
                                ${categoria.nomeCategoria}
                            </option>
                        </c:forEach>
                    </select>


                    <button class="btn-salvar"  type="submit" name="alterar" value="Alterar">SALVAR</button>

                </form>

            </div>

            <button class="btn-voltar">
                <a class="voltar" href="VerMinhasComunidades?idUsuario=${usuario.idUsuario}">VOLTAR</a>
            </button>        


        </section>

    </body>
</html>
<%
    }
%>



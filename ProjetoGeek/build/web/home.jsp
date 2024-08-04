<%@page import="br.com.projetousuario.model.Participante"%>
<%@page import="br.com.projetousuario.model.Comunidade"%>
<%@page import="br.com.projetousuario.model.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetousuario.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar usuário
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="assets/css/home.css">
        
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
                    <a href="desenvolvimento.jsp"><img class="btn btn-chat" src="assets/img/btn-chat.png"/></a>
                    <a href="desenvolvimento.jsp"><img class="btn btn-noturno" src="assets/img/btn-noturno.png"/></a>
                </div>

                <div class="nav-config">
                    <a href="carregarusuario.jsp"><img class="btn btn-config" src="assets/img/config.png"/></a>
                    <a href="index.jsp"><img class="btn btn-sair" src="assets/img/btn-sair.png"/></a>
                </div>
            </div>
        </section>

        <section class="main-content">
            <div class="barra-topo">
                <h1>Home</h1>
                <div>
                    <h2>Pesquisar</h2>
                    <img class="btn-lupa" src="assets/img/btn-lupa.png"/>
                </div>
                <button class="modal-form-comunidade"><img class="btn-criar-comunidade" src="assets/img/btn-criar-comunidade.png"/></button>
                <p>Bem-vindo, ${usuario.apelidoUsuario}!</p>
                <a href="carregarusuario.jsp"><img class="btn-perfil" src="assets/img/userprofile.png"/></a>

            </div>

            <div class="caixa-categorias">


                <h3>Categorias</h3>
                <div class="lista-categorias">
                    <%
                        List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                        for (Categoria categoria : categorias) {  //isso aqui ta falando que vai pegar as categorias listados e vai aparecer 
                    %>

                    <div class="categoria" >
                        <img class="img-categoria" src="assets/img/categoria-padrao.png"/>
                        <div class="conteudo-categoria">
                            <p><%=categoria.getNomeCategoria()%></p>
                        </div>
                    </div>


                    <%
                        }
                    %>
                </div>

            </div>



            <div class="caixa-comunidades">

                <h3>Comunidades Populares - <a href="VerMinhasComunidades?idUsuario=${usuario.idUsuario}">Ver minhas Comunidades</a></h3>

                <div class="lista-comunidades">
                    <%-- Código Java --%>
                    <%
                        List<Comunidade> comunidades = (List<Comunidade>) request.getAttribute("comunidades");
                        for (Comunidade comunidade : comunidades) {  //isso aqui ta falando que vai pegar os clientes listados e vai aparecer 
%>
                    <div class="comunidade">
                        <img class="img-comunidade" src="assets/img/comunidade-padrao.png"/>
                        <div class="conteudo-comunidade">
                            <h4>
                                <a href="VerPaginaComunidade?idComunidade=<%=comunidade.getIdComunidade()%>&tipo=pagina"><%=comunidade.getNomeComunidade()%></a>
                            </h4>
                            <p><%=comunidade.getDescricaoComunidade()%></p>  
                            <button><a href="VerPaginaComunidade?idComunidade=<%=comunidade.getIdComunidade()%>&tipo=pagina">Ver</a></button>

                        </div>
                    </div>

                    <%
                        }
                    %>
                </div>

            </div>

        </section>

        <dialog>   
            <form name="cadastrar" action="CadastrarComunidade" method="post">


                <a class="fechar-form"><img class="btn-fechar" src="assets/img/btn-fechar.png"/></a>

                <div class="lista-campos">
                    <div class="campo-form">
                        <label for="nome">Nome:</label>
                        <input type="text" name="nomeComunidade" placeholder="Digite o nome da comunidade">
                    </div> 
                    <div class="campo-form">
                        <label for="categoria">Categoria:</label></td>
                        <select name="idCategoria" >
                            <option value="" disabled selected>Selecione a categoria</option>
                            <c:forEach var="categoria" items="${categorias}"> <!-- tudo isso vai se repetir até todas as profissões cadastradas/armazenadas em profissoes forem imprimidas -->
                                
                                <option value="${categoria.idCategoria}">
                                    ${categoria.nomeCategoria}
                                </option>
                            </c:forEach>
                            <!-- se o forEach não estiver azul escuro, coloca o cursor no meio da palavra e aperte control+space -->
                        </select>
                    </div>  
                    <div class="campo-form">
                        <label for="descricao">Descrição:</label>
                        <textarea class="input-descricao" type="text" name="descricaoComunidade" placeholder="Digite uma descrição para a comunidade"></textarea>
                    </div>


                    <div class="oculta-moderador">
                        <label for="idusuario">Moderador Mestre:</label>
                        <input name="idUsuario" value="${usuario.idUsuario}" readonly="true">
                    </div>
                </div>


                <button type="submit" name="cadastrar" value="Cadastrar">SALVAR</button>
            </form>
        </dialog>

        <script src="assets/js/home.js"></script>

    </body>
</html>

<%
    }
%>

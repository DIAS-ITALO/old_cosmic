<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar usuário
%>

<%@page import="br.com.projetousuario.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetousuario.model.Comunidade"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Comunidade</title>

        <link rel="stylesheet" href="assets/css/verminhascomunidades.css">
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

                <%
                    List<Comunidade> comunidades = (List<Comunidade>) request.getAttribute("comunidades");
                    for (Comunidade comunidade : comunidades) {  //isso aqui ta falando que vai pegar os clientes listados e vai aparecer 
                %>
                <div class="campo-comunidade">

                    <p><%=comunidade.getModeradorComunidade().getNomeUsuario()%></p>
                    <p class="alinhar"><%=comunidade.getNomeComunidade()%></p>
                    <p><%=comunidade.getCategoriaComunidade().getNomeCategoria()%></p>

                    <div class="campo-alterar">
                    <a href="CarregarComunidade?idComunidade=<%=comunidade.getIdComunidade()%>">
                        <img class="btn btn-lapis" src="assets/img/lapis.png"/>
                    </a>
                    <a href="ExcluirComunidade?idComunidade=<%=comunidade.getIdComunidade()%>&idUsuario=<%=comunidade.getModeradorComunidade().getIdUsuario()%>">
                        <img class="btn btn-excluir" src="assets/img/btn-excluir.png"/>
                    </a>
                    </div>



                </div>
                <%
                    }
                %>



            </div>

        </section>

    </body>
</html>
<%
    }
%>



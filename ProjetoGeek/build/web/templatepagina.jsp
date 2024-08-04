<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar usuário
%>

<%@page import="br.com.projetousuario.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetousuario.model.Participante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comunidade - ${comunidade.nomeComunidade}</title>
        <link rel="stylesheet" href="assets/css/templatepagina.css">
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

            <div class="bloco-comunidade">

                <img class="fundo-comunidade-grande" src="assets/img/fundo-comunidade-grande.png"/>

                <div class="titulo-btn">
                    <h1>${comunidade.nomeComunidade}</h1>

                    <%
                        List<Participante> checarparticipantes = (List<Participante>) request.getAttribute("participantes");
                        String participa = "";

                        Usuario usuarioteste = (Usuario) sessao.getAttribute("usuario");

                        for (Participante participante : checarparticipantes) {

                            if (participante.getUsuarioPartipante().getIdUsuario() == usuarioteste.getIdUsuario()) {
                                participa = "s";
                            }
                        }

                        if (participa.equals("s")) {

                    %>
                    <button><a href="VerPaginaComunidade?idComunidade=${comunidade.idComunidade}&tipo=publi">PUBLICAÇÕES</a></button>
                    <%            } else {

                    %>
                    <button><a href="ParticiparComunidade?idComunidade=${comunidade.idComunidade}&idUsuario=${usuario.idUsuario}">PARTICIPAR</a></button>
                    <%                }
                    %>

                </div>

                <div class="conteudo-descritivo">

                    <div>
                        <h3>Categoria:</h3>
                        <p>${comunidade.getCategoriaComunidade().getNomeCategoria()}</p>
                    </div>
                    <div>
                        <h3>Descrição:</h3>
                        <p>${comunidade.descricaoComunidade}</p>
                    </div>
                </div>
            </div>



            <div class="lista-membros">
                <div class="titulo-membros">
                    <h3>Membros</h3>
                    <img class="adicionar-usuario" src="assets/img/adicionar-usuario.png"/>
                    <img class="adicionar" src="assets/img/adicionar.png"/>
                </div>

                <%  List<Participante> participantes = (List<Participante>) request.getAttribute("participantes");
                    for (Participante participante : participantes) {  //isso aqui ta falando que vai pegar os clientes listados e vai aparecer 
                %>
                <div class="linha-membro">
                    <img class="perfil-membro" src="assets/img/perfil-membro.png"/>
                    <p align="center"><%=participante.getUsuarioPartipante().getNomeUsuario()%></p>     
                    <img class="adicionar-usuario" src="assets/img/adicionar-usuario.png"/>

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
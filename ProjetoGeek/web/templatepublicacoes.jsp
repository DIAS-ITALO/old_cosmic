<%@page import="br.com.projetousuario.model.Publicacao"%>
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
        <link rel="stylesheet" href="assets/css/templatepublicacoes.css">
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

                    <img>

                </div>
                <div class="estrutura-form-conteudo">
                    <div class="conteudo-descritivo">



                        <%
                            List<Publicacao> publicacoes = (List<Publicacao>) request.getAttribute("publicacoes");
                            for (Publicacao publicacao : publicacoes) {  //isso aqui ta falando que vai pegar as publicações listadas e vai mostrar 
                        %>
                        <div class="listapublicacoes">
                            <div class="titulopublicacao">
                                <div class="perfil-pub">
                                    <img class="perfil-membro" src="assets/img/perfil-membro.png"/>
                                    <h4><%=publicacao.getUsuarioPublicacao().getNomeUsuario()%></h4>  
                                </div>
                                <img class="lapis" src="assets/img/lapis.png"/>
                            </div>
                            <p><%=publicacao.getConteudoPublicacao()%></p>             
                        </div>
                        <%
                            }
                        %>

                    </div>


                    <form name="cadastrar" action="CadastrarPublicacao" method="post">

                        <div class="ocultar">
                            <label for="idusuario">idUsuario:</label>
                            <input name="idUsuario" value="${usuario.idUsuario}" readonly="true">
                        </div>
                        <div class="ocultar">
                            <label for="idcomunidade">idComunidade:</label>
                            <input type="text" name="idComunidade" readonly="true" value="${comunidade.idComunidade}"> 
                        </div>

                        <img class="btn-upload" src="assets/img/btn-upload.png"/>
                        <input type="text" name="conteudoPublicacao" placeholder="Digite a sua mensagem">
                        <button type="submit" name="cadastrar" value="Cadastrar"><img class="btn-enviar" src="assets/img/btn-enviar.png"/></button>
                    </form>
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


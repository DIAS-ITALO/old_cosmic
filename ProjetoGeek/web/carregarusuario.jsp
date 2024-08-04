<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar usuário
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Usuário</title>
        <link rel="stylesheet" href="assets/css/carregarusuario.css">
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
            <img class="fundo-roxo" src="assets/img/fundo-roxo.png">

             <img class="imagem-perfil" src="assets/img/imagem-perfil.png">

            <div class="conteudo-perfil">
                <h1>${usuario.apelidoUsuario}</h1>

                <div class="group-information">
                    <h2>Nome</h2>
                    <p  name="nomeUsuario" id="nome" >${usuario.nomeUsuario}</p>
                </div> 
                <div class="group-information">
                    <h2>Data de Nascimento</h2>
                    <p  name="dataNascimentoUsuario" id="dataNascimento" >${usuario.dataNascimentoUsuario}</p>
                </div> 
                <div class="group-information">
                    <h2>Email</h2>
                    <p  name="emailUsuario" id="email" >${usuario.emailUsuario}</p>
                </div> 
                <div class="group-information">
                    <h2>Senha</h2>
                    <p name="senhaUsuario" id="senha" value="${usuario.senhaUsuario}">**********</p>
                </div>  

                <div class="alteracoes">
                    <a class="excluir"href="ExcluirUsuario?idUsuario=${usuario.idUsuario}&tipo=usuario">Excluir</a>
                    <button class="btn-alterar">
                        <a class="alterar"href="alterarusuario.jsp">EDITAR</a><img class="lapis" src="assets/img/lapis.png">
                    </button>
                </div>
            </div> 
        </section>
    </body>
</html>

<%
    }
%>
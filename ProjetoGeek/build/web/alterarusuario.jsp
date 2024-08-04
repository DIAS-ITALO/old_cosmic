<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("usuario") != null) { //diferente de nulo vai entrar no cadastrar cliente
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Usuário</title>
        <link rel="stylesheet" href="assets/css/alterarusuario.css">

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

            <form class="conteudo-perfil" name="alterar" action="AlterarUsuario" method="post">
                <input type="text" name="apelidoUsuario" id="apelido" value="${usuario.apelidoUsuario}"/>

                
                <div class="oculta">
                    <h2>Id</h2>
                    <input type="text" name="idUsuario" id="idusuario" value="${usuario.idUsuario}"/>
                </div> 
                <div class="group-information">
                    <h2>Nome</h2>
                    <input type="text" name="nomeUsuario" id="nome" value="${usuario.nomeUsuario}"/>
                </div> 
                <div class="group-information">
                    <h2>Data de Nascimento</h2>
                    <input class="data" type="date" name="dataNascimentoUsuario" id="dataNascimento" value="${usuario.dataNascimentoUsuario}"/>
                </div> 
                <div class="group-information">
                    <h2>Email</h2>
                    <input type="email" name="emailUsuario" id="email" value="${usuario.emailUsuario}"/>
                </div> 
                <div class="group-information">
                    <h2>Senha</h2>
                    <input type="text" name="senhaUsuario" id="senha" value="${usuario.senhaUsuario}"/>
                </div>  


                <div class="div-btn">   
                    <button class="btn-salvar"  type="submit" name="alterar" value="Alterar">SALVAR</button>
                </div> 

            </form> 
        </section>

    </body>
</html>

<%
    }
%>
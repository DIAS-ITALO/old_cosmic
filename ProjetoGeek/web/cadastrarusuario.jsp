<%-- 
    Document   : logarusuario
    Created on : 29 de set. de 2023, 22:39:50
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

        <link rel="stylesheet" href="assets/css/cadastrarusuario.css">
    </head>
    <body>

        <section>

            <img class="inferior-direito" src="assets/img/detalhe-fumaca.png" />
            <img class="estrelas" src="assets/img/estrelas.png" />
            <img class="foguete" src="assets/img/foguete.png" />
            <img class="lua" src="assets/img/lua.png" />

            <div class="main-content">
                <h1>CRIE SUA CONTA</h1>

                <form name="cadastrarusuario" action="CadastrarUsuario" method="post">

                    <div class="campo-form">
                        <div class="group-form">
                            <img class="icon" src="assets/img/icon-user.png" />
                            <input type="text" name="nomeUsuario" id="nome" placeholder="Nome">
                        </div>
                        <div class="group-form">
                            <img class="icon" src="assets/img/icon-user.png" />
                            <input type="text" name="apelidoUsuario" id="apelido" placeholder="Apelido">
                        </div>
                        <div class="group-form">
                            <img class="icon" src="assets/img/icon-data.png" />
                            <input type="date" name="dataNascimentoUsuario" id="data" placeholder="dd/dd/dddd">
                        </div>
                        <div class="group-form">
                            <img class="icon" src="assets/img/icon-email.png" />
                            <input type="text" name="emailUsuario" id="email" placeholder="Email"> 
                        </div>
                        <div class="group-form">
                            <img class="icon" src="assets/img/icon-cadeado.png" />
                            <input type="password" name="senhaUsuario" id="senha" placeholder="Senha">
                        </div>
                    </div>

                   
                    
                    
                    <button class="btn-cadastrar"  type="submit" name="cadatrar" value="Cadastrar">CADASTRAR</button>

                </form>
                
                <div class="div-logar">
                <a class="logar" href="logarusuario.jsp"> Já sou cadastrado! </a> 
                </div>
            </div>
        </section>
    </body>
</html>

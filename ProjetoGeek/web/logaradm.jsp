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

        <link rel="stylesheet" href="assets/css/logaradm.css">
    </head>
    <body>

        <section>

            <img class="inferior-esquerdo" src="assets/img/detalhe-fumaca.png" />
            <img class="estrelas" src="assets/img/estrelas.png" />
            <img class="foguete" src="assets/img/foguete.png" />
            <img class="lua" src="assets/img/lua.png" />

            <div class="main-content">
                <h1>LOGIN DE ADM</h1>

                <form name="logaradm" action="LogarAdm" method="post">

                    <div class="campo-form">
                        <div class="group-form">
                            <img class="icon" src="assets/img/icon-email.png" />
                            <input type="text" name="emailAdm" id="email" placeholder="Email"> 
                        </div>

                        <div class="group-form">
                            <img class="icon" src="assets/img/icon-cadeado.png" />
                            <input type="password" name="senhaAdm" id="senha" placeholder="Senha">
                        </div>
                    </div>

                    <div class="options">
                        <div class="div-lembrar-senha">
                            <input type="checkbox" class="checkbox" name="lembrarminhasenha">
                            <p>Lembrar minha senha</p>
                        </div>

                        <a href="#"> Esqueci minha senha</a>
                    </div>
                    
                    
                    <button class="btn-login"  type="submit" name="entrar" value="Entrar">LOGIN</button>

                </form>
                
                <p class="mensagem">${mensagem}</p> 
                <a class="cadastrar" href="cadastrarusuario.jsp"> Ainda não é cadastrado? Cadastre aqui! </a> 
            </div>
        </section>
    </body>
</html>

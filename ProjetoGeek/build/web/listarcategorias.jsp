<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    HttpSession sessao = httpServletRequest.getSession();

    if (sessao.getAttribute("adm") != null) { //diferente de nulo vai entrar no cadastrar
%>

<%@page import="br.com.projetousuario.model.Categoria"%>
<%@page import="br.com.projetousuario.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de categorias</title>
        <link rel="stylesheet" href="assets/css/listarcategorias.css">

    </head>
    <body>
    <body>
        <section class="nav-bar">
            <div class="nav-box">

                <div class="bloco-logo">
                    <a href="desenvolvimento.jsp"><img class="btn btn-sobre" src="assets/img/logo-simbolo.png"/></a>
                </div>

                <div class="nav-main">
                    <a href="LogarAdm?emailAdm=${adm.emailAdm}&senhaAdm=${adm.senhaAdm}">
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
                <h1>Listagem de Categorias</h1>
                <div>
                    <h2>Pesquisar</h2>
                    <img class="btn-lupa" src="assets/img/btn-lupa.png"/>
                </div>
                <a href="#"><img class="btn-perfil" src="assets/img/userprofile.png"/></a>

            </div>

            <div class="lista-categorias">
                <%-- Código Java --%>
                <%
                    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                    for (Categoria categoria : categorias) {  //isso aqui ta falando que vai pegar os clientes listados e vai aparecer 
%>
                <div class="campo-categoria">
                    <div class="bloco-logo">
                        <a href="desenvolvimentoadm.jsp"><img class="btn btn-sobre" src="assets/img/logo-simbolo.png"/></a>
                    </div>
                    <p><%=categoria.getNomeCategoria()%></p>
                    <a href="#">
                        <img class="btn-excluir" src="assets/img/btn-excluir.png"/>
                    </a>
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

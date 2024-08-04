
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

    if (sessao.getAttribute("adm") != null) { //diferente de nulo vai entrar no cadastrar usuário
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Adm</title>
        <link rel="stylesheet" href="assets/css/homeadm.css">
    </head>
    <body>


        <section class="nav-bar">
            <div class="nav-box">

                <div class="bloco-logo">
                    <a href="desenvolvimentoadm.jsp"><img class="btn btn-sobre" src="assets/img/logo-simbolo.png"/></a>
                </div>

                <div class="nav-main">
                    <a href="LogarAdm?emailAdm=${adm.emailAdm}&senhaAdm=${adm.senhaAdm}">
                        <img class="btn btn-home" src="assets/img/btn-home.png"/>
                    </a>
                    <a href="ListarComunidades"><img class="btn btn-comunidades" src="assets/img/btn-comunidades.png"/></a>
                    <a href="ListarUsuarios"><img class="btn btn-lista-usuarios" src="assets/img/btn-lista-usuarios.png"/></a>
                    <a href="desenvolvimentoadm.jsp"><img class="btn btn-noturno" src="assets/img/btn-noturno.png"/></a>
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
                <div class="campo-pesquisa">
                    <h2>Pesquisar</h2>
                    <img class="btn-lupa" src="assets/img/btn-lupa.png"/>
                </div>
                <button class="modal-form-categoria"><img class="btn-criar-categoria" src="assets/img/btn-criar-categoria.png"/></button>



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

                <h3>Comunidades Populares</h3>

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
            <form name="cadastrar" action="CadastrarCategoria" method="post">

                <a class="fechar-form"><img class="btn-fechar" src="assets/img/btn-fechar.png"/></a>

                <div class="lista-campos">
                    <div class="campo-form">
                        <label for="nome">Nome da categoria:</label>
                        <input type="text" name="nomeCategoria" placeholder="Digite o nome da categoria">
                    </div>
                    
                    
                </div>
                
                <button class="criar-categoria" type="submit" name="cadastrar" value="Cadastrar">CRIAR</button>

            </form>
        </dialog>   

        <script src="assets/js/homeadm.js"></script>
    </body>
</html>

<%
    }
%>

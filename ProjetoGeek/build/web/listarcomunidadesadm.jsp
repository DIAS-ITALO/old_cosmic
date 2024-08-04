<% 
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    
    HttpSession sessao = httpServletRequest.getSession();
    
    if(sessao.getAttribute("adm") != null) { //diferente de nulo vai entrar no cadastrar usuário
%>

<%@page import="br.com.projetousuario.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.projetousuario.model.Comunidade"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Comunidades</title>
        
        
    </head>
    <body>
        <h1 align="center">Controle de Comunidades</h1>
        
        <br>
        <br>
        
        <table align="center" border="1">
            <tr>
                <th colspan="4"> Lista de Comunidade </th>
            </tr>
            <tr>
                <th align="center"> Id Comunidade: </th>
                <th align="center"> Nome da Comunidade: </th>
                <th align="center"> Descrição da Comunidade: </th>
                <th align="center"> Nome da Categoria: </th>
                
            </tr>
            
            <%-- Código Java --%>
            <%
               List<Comunidade> comunidades = (List<Comunidade>) request.getAttribute("comunidades"); 
               for(Comunidade comunidade:comunidades){  //isso aqui ta falando que vai pegar os clientes listados e vai aparecer 
            %>
            <tr>
                <td align="center"><%=comunidade.getIdComunidade()%></td>
                <td align="center"><%=comunidade.getNomeComunidade()%></td>
                <td align="center"><%=comunidade.getDescricaoComunidade()%></td>
                <td align="center"><%=comunidade.getCategoriaComunidade().getNomeCategoria()%></td>
               
            </tr>
            <%
                }
            %>
            <tr>
                <th colspan="4"><a href="homeadm.jsp">Voltar</a></th>
            </tr>
        </table>
    </body>
</html>
<%
    }
%>


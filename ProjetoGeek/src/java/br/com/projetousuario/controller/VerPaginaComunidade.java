package br.com.projetousuario.controller;

import br.com.projetousuario.dao.ComunidadeDAOImpl;
import br.com.projetousuario.dao.ParticipanteDAOImpl;
import br.com.projetousuario.dao.PublicacaoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VerPaginaComunidade", urlPatterns = {"/VerPaginaComunidade"})
public class VerPaginaComunidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            Integer idComunidade = Integer.parseInt(request.getParameter("idComunidade"));

            String tipo = request.getParameter("tipo");
            String retorno;

            if (tipo.equals("publi")) {
                retorno = "templatepublicacoes.jsp";
            } else {
                retorno = "templatepagina.jsp";
            }

            try {
                ComunidadeDAOImpl dao = new ComunidadeDAOImpl();
                request.setAttribute("comunidade", dao.carregar(idComunidade));
                
                ParticipanteDAOImpl daop = new ParticipanteDAOImpl();
                request.setAttribute("participantes", daop.listarParticipantesComunidade(idComunidade));
                
                PublicacaoDAOImpl daopu = new PublicacaoDAOImpl();
                request.setAttribute("publicacoes", daopu.listarPublicacoesComunidade(idComunidade));
                
                request.getRequestDispatcher(retorno).forward(request, response); // mandando as informações para a JSP
            } catch (Exception e) {
                System.out.println("Problemas ao listar comunidades! Erro: " + e.getMessage());
                e.printStackTrace();
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

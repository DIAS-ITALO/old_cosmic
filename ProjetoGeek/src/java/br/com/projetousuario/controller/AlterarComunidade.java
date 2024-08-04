/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetousuario.controller;

import br.com.projetousuario.dao.ComunidadeDAOImpl;
import br.com.projetousuario.dao.GenericDAO;
import br.com.projetousuario.model.Categoria;
import br.com.projetousuario.model.Comunidade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarComunidade", urlPatterns = {"/AlterarComunidade"})
public class AlterarComunidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            Integer idComunidade = Integer.parseInt(request.getParameter("idComunidade"));
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nomeComunidade = request.getParameter("nomeComunidade");
            String descricaoComunidade = request.getParameter("descricaoComunidade");
            Integer idCategoria = Integer.parseInt(request.getParameter("idCategoria"));

            
            

            String mensagem;

            Comunidade comunidade = new Comunidade();
            comunidade.setIdComunidade(idComunidade);
            comunidade.setNomeComunidade(nomeComunidade);
            comunidade.setDescricaoComunidade(descricaoComunidade);
            comunidade.setCategoriaComunidade(new Categoria(idCategoria));


            try {
                GenericDAO dao = new ComunidadeDAOImpl();
                if (dao.alterar(comunidade)) {
                    mensagem = "Comunidade alterado com sucesso!";
                } else {
                    mensagem = "Problemas ao alterar comunidade!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("VerMinhasComunidades?idUsuario").forward(request, response);
            } catch (Exception e) {
                System.out.println("Problemas na servlet ao alterar comunidade. Erro: " + e.getMessage());
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

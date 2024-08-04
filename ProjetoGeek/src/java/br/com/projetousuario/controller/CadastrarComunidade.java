package br.com.projetousuario.controller;

import br.com.projetousuario.dao.ComunidadeDAOImpl;
import br.com.projetousuario.dao.GenericDAO;
import br.com.projetousuario.model.Categoria;
import br.com.projetousuario.model.Comunidade;
import br.com.projetousuario.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarComunidade", urlPatterns = {"/CadastrarComunidade"})
public class CadastrarComunidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            String nomeComunidade = request.getParameter("nomeComunidade");
            String descricaoComunidade = request.getParameter("descricaoComunidade");
            Integer idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));


            String mensagem;
            Comunidade comunidade = new Comunidade();

            comunidade.setNomeComunidade(nomeComunidade);
            comunidade.setDescricaoComunidade(descricaoComunidade);
            comunidade.setCategoriaComunidade(new Categoria(idCategoria));
            comunidade.setModeradorComunidade(new Usuario (idUsuario));


            try {
                GenericDAO dao = new ComunidadeDAOImpl();
                if (dao.cadastrar(comunidade)) {
                    mensagem = "Comunidade cadastrada com sucesso!!!";
                } else {
                    mensagem = "Problemas ao cadastrar a comunidade";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("VerMinhasComunidades?idUsuario").forward(request, response);
            } catch (Exception e) {
                System.out.println("Problemas na servlet ao cadastrar medico. "
                        + "Erro: "
                        + e.getMessage());
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

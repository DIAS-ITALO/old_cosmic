package br.com.projetousuario.controller;

import br.com.projetousuario.dao.CategoriaDAOImpl;
import br.com.projetousuario.dao.GenericDAO;
import br.com.projetousuario.model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarCategoria", urlPatterns = {"/CadastrarCategoria"})
public class CadastrarCategoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            String nomeCategoria = request.getParameter("nomeCategoria");

            String mensagem;

            Categoria categoria = new Categoria();

            categoria.setNomeCategoria(nomeCategoria);
                    
            try {
                GenericDAO dao = new CategoriaDAOImpl();
                if (dao.cadastrar(categoria)) {
                    mensagem = "Categoria cadastrado com sucesso!!!";
                } else {
                    mensagem = "Problemas ao cadastrar o categoria";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarCategorias").forward(request, response);
            } catch (Exception e) {
                System.out.println("Problemas na servlet ao cadastrar categoria. "
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

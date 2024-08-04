package br.com.projetousuario.controller;

import br.com.projetousuario.dao.CategoriaDAOImpl;
import br.com.projetousuario.dao.GenericDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirCategoria", urlPatterns = {"/ExcluirCategoria"})
public class ExcluirCategoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            Integer idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            
            String mensagem;
            
            try{
                GenericDAO dao = new CategoriaDAOImpl();
                if(dao.excluir(idCategoria)){
                    mensagem = "Categoria excluída com sucesso!";
                }else{
                   mensagem = "Problemas ao excluir categoria!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("homeadm.jsp").forward(request, response);
            }catch(Exception e){
                System.out.println("Problemas na servlet ao excluir cliente. Erro " + e.getMessage());
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

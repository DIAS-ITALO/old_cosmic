package br.com.projetousuario.controller;

import br.com.projetousuario.dao.GenericDAO;
import br.com.projetousuario.dao.UsuarioDAOImpl;
import br.com.projetousuario.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AlterarUsuario", urlPatterns = {"/AlterarUsuario"})
public class AlterarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String nomeUsuario = request.getParameter("nomeUsuario");
            String emailUsuario = request.getParameter("emailUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            String dataNascimentoUsuario = request.getParameter("dataNascimentoUsuario");
            String apelidoUsuario = request.getParameter("apelidoUsuario");

            String mensagem;
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(idUsuario);
            usuario.setNomeUsuario(nomeUsuario);
            usuario.setEmailUsuario(emailUsuario);
            usuario.setSenhaUsuario(senhaUsuario);
            usuario.setDataNascimentoUsuario(dataNascimentoUsuario);
            usuario.setApelidoUsuario(apelidoUsuario);

            try {
                GenericDAO dao = new UsuarioDAOImpl();
                if (dao.alterar(usuario)) {
                    mensagem = "Usuário alterado com sucesso!";
                    HttpSession sessao = request.getSession();  //nova classe, a httpsession gerencia sessoes, torna a verdadeira
                    sessao.setAttribute("usuario", usuario);
                } else {
                    mensagem = "Problemas ao alterar usuário!";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("carregarusuario.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println("Problemas na servlet ao alterar cliente. Erro: " + e.getMessage());
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

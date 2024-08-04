package br.com.projetousuario.controller;

import br.com.projetousuario.dao.CategoriaDAOImpl;
import br.com.projetousuario.dao.ComunidadeDAOImpl;
import br.com.projetousuario.dao.GenericDAO;
import br.com.projetousuario.dao.ParticipanteDAOImpl;
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

@WebServlet(name = "LogarUsuario", urlPatterns = {"/LogarUsuario"})
public class LogarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            try {

                String emailUsuario = request.getParameter("emailUsuario");
                String senhaUsuario = request.getParameter("senhaUsuario");
                String mensagem = null;  // messagem de entrada/ boas vindas

                if (!emailUsuario.equals("") && !senhaUsuario.equals("")) {
                    // se o login e senha não forem vazios, sera obrigado a digitar e enviado mensagem, vai voltar pro login
                    
                    UsuarioDAOImpl dao = new UsuarioDAOImpl();
                    Usuario usuario = (Usuario) dao.logarUsuario(emailUsuario, senhaUsuario);
                    
                    GenericDAO daoca = new CategoriaDAOImpl();
                    CategoriaDAOImpl daocat = new CategoriaDAOImpl();
                    ComunidadeDAOImpl daoco = new ComunidadeDAOImpl();
                    
                    if (usuario != null) {
                        HttpSession sessao = request.getSession(true);  //nova classe, a httpsession gerencia sessoes, torna a verdadeira
                        sessao.setAttribute("usuario", usuario);
                        mensagem = "Seja bem-vindo(a)!";
                        sessao.setAttribute("mensagem", mensagem);
                        
                        request.setAttribute("categorias", daoca.listar());
                        request.setAttribute("categorias", daocat.carregarCategorias());
                        request.setAttribute("comunidades", daoco.verComunidadesPopulares());
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    } else {
                        mensagem = "Login ou Email inválidos!";
                        request.setAttribute("mensagem", mensagem);
                        request.getRequestDispatcher("logarusuario.jsp").forward(request, response);
                    }
                } else {
                    mensagem = "É necessário digitar Email e Senha!";
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("logarusuario.jsp").forward(request, response);
                }
            } catch (Exception e) {
                System.out.println("Problemas ao logar! Erro: " + e.getMessage());
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

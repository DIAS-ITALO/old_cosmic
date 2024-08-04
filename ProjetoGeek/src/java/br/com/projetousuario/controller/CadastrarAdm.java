package br.com.projetousuario.controller;

import br.com.projetousuario.dao.AdmDAOImpl;
import br.com.projetousuario.dao.GenericDAO;
import br.com.projetousuario.model.Adm;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarAdm", urlPatterns = {"/CadastrarAdm"})
public class CadastrarAdm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
                String nomeAdm = request.getParameter("nomeAdm");
                String emailAdm = request.getParameter("emailAdm");
                String senhaAdm = request.getParameter("senhaAdm");
                String dataNascimentoAdm = request.getParameter("dataNascimentoAdm");
                
                String mensagem;
                 
                Adm adm = new Adm();
                
                adm.setNomeAdm(nomeAdm);
                adm.setEmailAdm(emailAdm);
                adm.setSenhaAdm(senhaAdm);
                adm.setDataNascimentoAdm(dataNascimentoAdm);
                
                try {
                GenericDAO dao = new AdmDAOImpl();
                if (dao.cadastrar(adm)) {
                    mensagem = "Adm cadastrado com sucesso!!!";
                } else {
                    mensagem = "Problemas ao cadastrar o médico";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("logaradm.jsp").forward(request, response);
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

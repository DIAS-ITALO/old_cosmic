package br.com.projetousuario.controller;

import br.com.projetousuario.dao.ComunidadeDAOImpl;
import br.com.projetousuario.dao.GenericDAO;
import br.com.projetousuario.dao.ParticipanteDAOImpl;
import br.com.projetousuario.dao.PublicacaoDAOImpl;
import br.com.projetousuario.model.Comunidade;
import br.com.projetousuario.model.Participante;
import br.com.projetousuario.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ParticiparComunidade", urlPatterns = {"/ParticiparComunidade"})
public class ParticiparComunidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            HttpSession sessao = httpServletRequest.getSession();

            if (sessao.getAttribute("usuario") != null) {

                Integer idComunidade = Integer.parseInt(request.getParameter("idComunidade"));
                Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

                String mensagem;

                Participante participante = new Participante();
                participante.setUsuarioPartipante(new Usuario(idUsuario));
                participante.setComunidadePartipante(new Comunidade(idComunidade));

                try {
                    GenericDAO dao = new ParticipanteDAOImpl();
                    if (dao.cadastrar(participante)) {
                        mensagem = "Participante cadastrado com sucesso!!!";
                    } else {
                        mensagem = "Problemas ao cadastrar o participante";
                    }

                    ComunidadeDAOImpl daoc = new ComunidadeDAOImpl();
                    request.setAttribute("comunidade", daoc.carregar(idComunidade));

                    ParticipanteDAOImpl daop = new ParticipanteDAOImpl();
                    request.setAttribute("participantes", daop.listarParticipantesComunidade(idComunidade));

                    PublicacaoDAOImpl daopu = new PublicacaoDAOImpl();
                    request.setAttribute("publicacoes", daopu.listarPublicacoesComunidade(idComunidade));

                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("templatepagina.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Problemas na servlet ao cadastrar participante. "
                            + "Erro: "
                            + e.getMessage());
                    e.printStackTrace();

                }

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

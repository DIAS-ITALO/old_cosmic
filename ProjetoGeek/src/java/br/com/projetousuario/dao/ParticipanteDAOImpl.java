package br.com.projetousuario.dao;

import br.com.projetousuario.model.Participante;
import br.com.projetousuario.model.Usuario;
import br.com.projetousuario.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAOImpl implements GenericDAO {

    private Connection conn;

    public ParticipanteDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Participante participante = (Participante) object;
        PreparedStatement stmt = null;

        String sql = "insert into participante(idcomunidade, idusuario) values(?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, participante.getComunidadePartipante().getIdComunidade());
            stmt.setInt(2, participante.getUsuarioPartipante().getIdUsuario());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar partipante. Erro" + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro" + ex.getMessage());
            }
        }

    }

    public List<Object> listarParticipantesComunidade(int idObject) {
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        List<Object> participantes = new ArrayList<>(); //variável do tipo vetor

        String sql = "select us.*, pa.* from participante pa "
                + "inner join usuario us on pa.idusuario = us.idusuario "
                + "where pa.idcomunidade = ? order by pa.idusuario asc;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
            while (rs.next()) { //enquanto existir um próximo registro no ResultSet faça ...
                Participante participante = new Participante();//criar objeto
                participante.setIdParticipante(rs.getInt("idparticipante"));
                participante.setUsuarioPartipante(new Usuario(rs.getInt("idusuario"), rs.getString("nomeusuario")));
                
                participantes.add(participante); //adicionar no vetor
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar categorias. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão. " + e.getMessage());
                e.printStackTrace();
            }
        }
        return participantes; //

    }
    
    public List<Object> listarParticipantesUsuario(int idObject) {
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        List<Object> participantes = new ArrayList<>(); //variável do tipo vetor

        String sql = "select u.*, p.*, c.* from usuario u, participante p, comunidade c "
                + "where u.idusuario = p.idusuario and p.idcomunidade = c.idcomunidade and u.idusuario = ?;";
        
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
            while (rs.next()) { //enquanto existir um próximo registro no ResultSet faça ...
                Participante participante = new Participante();//criar objeto
                participante.setIdParticipante(rs.getInt("idparticipante"));
                participante.setUsuarioPartipante(new Usuario(rs.getInt("idusuario"), rs.getString("nomeusuario")));
                
                participantes.add(participante); //adicionar no vetor
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar categorias. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão. " + e.getMessage());
                e.printStackTrace();
            }
        }
        return participantes; //

    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

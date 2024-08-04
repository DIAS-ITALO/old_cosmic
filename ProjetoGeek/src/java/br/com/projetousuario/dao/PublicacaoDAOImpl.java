package br.com.projetousuario.dao;

import br.com.projetousuario.model.Comunidade;
import br.com.projetousuario.model.Publicacao;
import br.com.projetousuario.model.Usuario;
import br.com.projetousuario.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublicacaoDAOImpl implements GenericDAO  {
    
    
    private Connection conn;

    public PublicacaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }
    
    public List<Object> listarPublicacoesComunidade(int idObject) {
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        List<Object> publicacoes = new ArrayList<>(); //variável do tipo vetor

        String sql = "select us.nomeusuario, co.nomecomunidade, pu.* from publicacao pu "
                    + "inner join usuario us on pu.idusuario = us.idusuario " 
                    + "inner join comunidade co on pu.idcomunidade = co.idcomunidade "
                    + "where pu.idcomunidade = ? order by pu.idpublicacao desc";
//"select us.*, pa.* from participante pa "
                //+ "inner join usuario us on pa.idusuario = us.idusuario "
                //+ "where pa.idcomunidade = ? order by pa.idusuario asc;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
            while (rs.next()) { //enquanto existir um próximo registro no ResultSet faça ...
                Publicacao publicacao = new Publicacao();//criar objeto
                publicacao.setIdPublicacao(rs.getInt("idpublicacao"));
                publicacao.setConteudoPublicacao(rs.getString("conteudopublicacao"));
                publicacao.setComunidadePublicacao(new Comunidade(rs.getInt("idcomunidade"), rs.getString("nomecomunidade")));
                publicacao.setUsuarioPublicacao(new Usuario(rs.getInt("idusuario"), rs.getString("nomeusuario")));

                
                publicacoes.add(publicacao); //adicionar no vetor
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
        return publicacoes; //

    }

    @Override
    public Boolean cadastrar(Object object) {
        Publicacao publicacao = (Publicacao) object;
        PreparedStatement stmt = null;

        String sql = "insert into publicacao(conteudopublicacao, idcomunidade, idusuario) values(?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, publicacao.getConteudoPublicacao());
            stmt.setInt(2, publicacao.getComunidadePublicacao().getIdComunidade());
            stmt.setInt(3, publicacao.getUsuarioPublicacao().getIdUsuario());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar publicação. Erro" + e.getMessage());
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

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
}

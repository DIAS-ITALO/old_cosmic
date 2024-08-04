package br.com.projetousuario.dao;

import br.com.projetousuario.model.Categoria;
import br.com.projetousuario.model.Comunidade;
import br.com.projetousuario.model.Usuario;
import br.com.projetousuario.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComunidadeDAOImpl implements GenericDAO {

    private Connection conn;

    public ComunidadeDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Object> verMinhasComunidades(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> comunidades = new ArrayList<>();

        String sql = "select co.*, ca.nomecategoria, us.nomeusuario "
                + "from comunidade co "
                + "inner join categoria ca on co.idcategoria = ca.idcategoria "
                + "inner join usuario us on co.moderador1 = us.idusuario where moderador1 = ? ;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Comunidade comunidade = new Comunidade();
                comunidade.setIdComunidade(rs.getInt("idcomunidade"));
                comunidade.setNomeComunidade(rs.getString("nomeComunidade"));
                comunidade.setDescricaoComunidade(rs.getString("descricaoComunidade"));
                comunidade.setCategoriaComunidade(new Categoria(rs.getInt("idcategoria"), rs.getString("nomecategoria")));
                comunidade.setModeradorComunidade(new Usuario(rs.getInt("moderador1"), rs.getString("nomeusuario")));
                

                comunidades.add(comunidade);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao carregar comunidade. Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão. Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return comunidades;
    }
    
   
    public List<Object> verComunidadesPopulares() {
        List<Object> comunidades = new ArrayList<>(); //variável do tipo vetor
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados

        String sql = "select co.*, ca.* from comunidade co, categoria ca where co.idcategoria = ca.idcategoria and co.idcomunidade < 9 order by co.idcomunidade asc;";

        //"select c.*, p.*, pe.* from cliente c, profissao p, pessoa pe where c.idprofissao = p.idprofissao and c.idpessoa = pe.idpessoa;"; /
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
            while (rs.next()) { //enquanto existir um próximo registro no ResultSet faça ...
                Comunidade comunidade = new Comunidade(); //criar objeto
                comunidade.setIdComunidade(rs.getInt("idcomunidade"));
                comunidade.setNomeComunidade(rs.getString("nomecomunidade"));
                comunidade.setDescricaoComunidade(rs.getString("descricaocomunidade"));
                comunidade.setCategoriaComunidade(new Categoria(rs.getInt("idcategoria")));
                comunidade.setCategoriaComunidade(new Categoria(rs.getString("nomecategoria")));
                comunidades.add(comunidade); //adicionar no vetor
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar usuários. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão. " + e.getMessage());
                e.printStackTrace();
            }
        }
        return comunidades; //retornar para a servlet

    }

    @Override
    public Boolean cadastrar(Object object) {
        Comunidade comunidade = (Comunidade) object;
        PreparedStatement stmt = null;

        String sql = "insert into comunidade(nomecomunidade, descricaocomunidade, idcategoria, moderador1) "
                + "values(?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, comunidade.getNomeComunidade());
            stmt.setString(2, comunidade.getDescricaoComunidade());
            stmt.setInt(3, comunidade.getCategoriaComunidade().getIdCategoria());
            stmt.setInt(4, comunidade.getModeradorComunidade().getIdUsuario());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar comunidade. Erro" + e.getMessage());
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
        List<Object> comunidades = new ArrayList<>(); //variável do tipo vetor
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados

        String sql = "select co.*, ca.* from comunidade co, categoria ca where co.idcategoria = ca.idcategoria order by co.idcomunidade asc;";

        //"select c.*, p.*, pe.* from cliente c, profissao p, pessoa pe where c.idprofissao = p.idprofissao and c.idpessoa = pe.idpessoa;"; /
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
            while (rs.next()) { //enquanto existir um próximo registro no ResultSet faça ...
                Comunidade comunidade = new Comunidade(); //criar objeto
                comunidade.setIdComunidade(rs.getInt("idcomunidade"));
                comunidade.setNomeComunidade(rs.getString("nomecomunidade"));
                comunidade.setDescricaoComunidade(rs.getString("descricaocomunidade"));
                comunidade.setCategoriaComunidade(new Categoria(rs.getInt("idcategoria")));
                comunidade.setCategoriaComunidade(new Categoria(rs.getString("nomecategoria")));
                comunidades.add(comunidade); //adicionar no vetor
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar usuários. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão. " + e.getMessage());
                e.printStackTrace();
            }
        }
        return comunidades; //retornar para a servlet

    }

    @Override
    public Boolean excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "delete from publicacao where idcomunidade = ?;"
                + "delete from participante where idcomunidade = ?;"
                + "delete from comunidade where idcomunidade = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao excluir comunidade. Erro " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean alterar(Object object) {
        Comunidade comunidade = (Comunidade) object;
        PreparedStatement stmt = null;

        String sql = "update comunidade set nomecomunidade = ?, descricaocomunidade = ?, idcategoria = ? where idcomunidade = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, comunidade.getNomeComunidade());
            stmt.setString(2, comunidade.getDescricaoComunidade());
            stmt.setInt(3, comunidade.getCategoriaComunidade().getIdCategoria());
            stmt.setInt(4, comunidade.getIdComunidade());
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Problemas ao alterar comunidade. Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão. Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comunidade comunidade = null;

        String sql = "select co.*, ca.* from comunidade co, categoria ca where co.idcategoria = ca.idcategoria and co.idcomunidade = ?;";

//"select c.*, p.*, pr.* from cliente c, pessoa p, profissao pr where c.idpessoa = p.idpessoa and c.idprofissao =pr.idprofissao and p.idpessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();

            while (rs.next()) {
                comunidade = new Comunidade();
                comunidade.setIdComunidade(rs.getInt("idcomunidade"));
                comunidade.setNomeComunidade(rs.getString("nomecomunidade"));
                comunidade.setDescricaoComunidade(rs.getString("descricaocomunidade"));
                comunidade.setCategoriaComunidade(new Categoria(rs.getInt("idcategoria")));
                comunidade.setCategoriaComunidade(new Categoria(rs.getString("nomecategoria")));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao carregar comunidade. Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão. Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return comunidade;
    }

    

}

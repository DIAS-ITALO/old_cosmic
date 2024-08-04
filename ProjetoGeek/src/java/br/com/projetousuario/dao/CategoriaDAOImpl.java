package br.com.projetousuario.dao;

import br.com.projetousuario.model.Categoria;
import br.com.projetousuario.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements GenericDAO {

    private Connection conn;

    public CategoriaDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Object> carregarCategorias() {

        List<Object> categorias = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select * from categoria;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nomecategoria"));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar as categorias. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão." + e.getMessage());
                e.printStackTrace();
            }
        }

        return categorias;
    }

    @Override
    public Boolean cadastrar(Object object) {
        Categoria categoria = (Categoria) object;
        PreparedStatement stmt = null;

        String sql = "insert into categoria(nomecategoria) values(?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar categoria. Erro" + e.getMessage());
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
        List<Object> categorias = new ArrayList<>(); //variável do tipo vetor
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados

        String sql = "select * from categoria where idcategoria = idcategoria;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
            while (rs.next()) { //enquanto existir um próximo registro no ResultSet faça ...
                Categoria categoria = new Categoria(); //criar objeto
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setNomeCategoria(rs.getString("nomecategoria"));
                categorias.add(categoria); //adicionar no vetor
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
        return categorias; //
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
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

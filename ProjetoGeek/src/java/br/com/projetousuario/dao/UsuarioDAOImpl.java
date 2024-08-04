package br.com.projetousuario.dao;

import br.com.projetousuario.model.Usuario;
import br.com.projetousuario.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements GenericDAO {

    private Connection conn;

    public UsuarioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;

        String sql = "insert into usuario(nomeusuario, emailusuario, senhausuario, datanascimentousuario, apelidousuario) values(?, ?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.setString(4, usuario.getDataNascimentoUsuario());
            stmt.setString(5, usuario.getApelidoUsuario());
            
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar usuário. Erro" + e.getMessage());
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
    
    public Object logarUsuario (String email, String senha) {
     
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        Usuario usuario = null;
        String sql = "select * from usuario where emailusuario = ? and senhausuario = ?;";
        
        try{
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, email);
         stmt.setString(2, senha);
         rs = stmt.executeQuery();
         
         while(rs.next()){ //enquanto existir um próximo registro no ResultSet faça ...
             usuario = new Usuario(); //criar objeto
             usuario.setIdUsuario(rs.getInt("idusuario"));
             usuario.setNomeUsuario(rs.getString("nomeusuario"));
             usuario.setEmailUsuario(rs.getString("emailusuario"));
             usuario.setSenhaUsuario(rs.getString("senhausuario"));
             usuario.setDataNascimentoUsuario(rs.getString("datanascimentousuario"));
             usuario.setApelidoUsuario(rs.getString("apelidousuario"));
             
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao encontrar usuário. " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                 System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                 ex.printStackTrace();
            }
        }
        return usuario; //retornar para a servlet
    }

    @Override
    public List<Object> listar() {
        List<Object> usuarios = new ArrayList<>(); //variável do tipo vetor
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        
        String sql = "select * from usuario where idusuario = idusuario order by idusuario asc;";
        
        try{
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
         while(rs.next()){ //enquanto existir um próximo registro no ResultSet faça ...
             Usuario usuario = new Usuario(); //criar objeto
             usuario.setIdUsuario(rs.getInt("idusuario"));
             usuario.setNomeUsuario(rs.getString("nomeusuario"));
             usuario.setEmailUsuario(rs.getString("emailusuario"));
             usuario.setSenhaUsuario(rs.getString("senhausuario"));
             usuario.setDataNascimentoUsuario(rs.getString("datanascimentousuario"));
             usuario.setApelidoUsuario(rs.getString("apelidousuario"));
             usuarios.add(usuario); //adicionar no vetor
            }
        }catch(SQLException ex){
            System.out.println("Erro ao listar usuários. " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception e){
                 System.out.println("Erro ao fechar a conexão. " + e.getMessage());
                 e.printStackTrace();
            }
        }
        return usuarios; //retornar para a servlet
    }
    

    @Override
    public Boolean excluir(int idObject) {
       PreparedStatement stmt = null;
        String sql = "delete from usuario where idusuario = ?"; // commit confirma as alterações feitas na base, como se salvasse a alteração, rollback desfaz tudo oq vc fez dps  do commit
        
        try{
           stmt = conn.prepareStatement(sql);
           stmt.setInt(1, idObject);
           stmt.executeUpdate();
           return true;
        }catch(Exception e){
            System.out.println("Problemas ao excluir usuário. Erro " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean alterar(Object object) {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        
        String sql = "update usuario set nomeusuario = ?, emailusuario = ?, senhausuario = ?, datanascimentousuario = ?, apelidousuario = ? where idusuario = ?"; 
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());
            stmt.setString(4, usuario.getDataNascimentoUsuario());
            stmt.setString(5, usuario.getApelidoUsuario());
            stmt.setInt(6, usuario.getIdUsuario());
            stmt.executeUpdate();
            return true;
            
        }catch(Exception e){
            System.out.println("Problemas ao alterar usuário. Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar a conexão. Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
    }

}

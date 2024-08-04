package br.com.projetousuario.dao;

import br.com.projetousuario.model.Adm;
import br.com.projetousuario.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AdmDAOImpl implements GenericDAO{

    private Connection conn;

    public AdmDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());

        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {
        Adm adm = (Adm) object;
        PreparedStatement stmt = null;

        String sql = "insert into adm(nomeadm, emailadm, senhaadm, datanascimentoadm) values(?, ?, ?, ?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, adm.getNomeAdm());
            stmt.setString(2, adm.getEmailAdm());
            stmt.setString(3, adm.getSenhaAdm());
            stmt.setString(4, adm.getDataNascimentoAdm());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Problemas ao cadastrar adm. Erro" + e.getMessage());
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
    
    public Object logarAdm (String email, String senha) {
     
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        Adm adm = null;
        String sql = "select * from adm where emailadm = ? and senhaadm = ?;";
        
        try{
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, email);
         stmt.setString(2, senha);
         rs = stmt.executeQuery();
         
         while(rs.next()){ //enquanto existir um próximo registro no ResultSet faça ...
             adm = new Adm(); //criar objeto
             adm.setIdAdm(rs.getInt("idadm"));
             adm.setNomeAdm(rs.getString("nomeadm"));
             adm.setEmailAdm(rs.getString("emailadm"));
             adm.setSenhaAdm(rs.getString("senhaadm"));
             adm.setDataNascimentoAdm(rs.getString("datanascimentoadm"));
             
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
        return adm; //retornar para a servlet
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

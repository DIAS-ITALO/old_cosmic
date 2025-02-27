package br.com.projetousuario.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
        public static Connection getConnection() throws Exception{
        try{
            // carregar o driver do postgresql
            Class.forName(("org.postgresql.Driver"));
              return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdcosmic", "postgres", "postdba");     
                    
        }catch(Exception e){
            //mandar a mensagem de erro
            throw new Exception (e.getMessage());
        }
    }
        public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception{
        close (conn, stmt, rs);
        }
        
        public static void closeConnection(Connection conn, Statement stmt) throws Exception{
        close (conn, stmt, null);
        }
        
        public static void closeConnection(Connection conn) throws Exception{
        close (conn, null, null);
        }
        
        
  
   
      private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception{
  
       try{
           if (rs !=null){
           rs.close();
        }
        if (stmt!=null){
            stmt.close();
        }
        if (conn !=null){
            conn.close();
        }

        }catch(SQLException e){
        throw new Exception (e.getMessage());
        }
  
}  
}

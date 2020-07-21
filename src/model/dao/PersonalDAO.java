package model.dao;

import connection.Connectionfactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Personal;

public class PersonalDAO {

    /**
     *
     * @param p
     */
    public void create(Personal p){
        Connection con = Connectionfactory.getConnection();
        PreparedStatement stmt = null;
        
              try {
            stmt = con.prepareStatement("INSERT INTO personal (nome,cpf,email,registro,cep,celular,senha,endereco) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getEmail());
            stmt.setString(4,p.getRegistro());
            stmt.setString(5, p.getCep());
            stmt.setString(6, p.getCelular());
            stmt.setString(7,p.getSenha());
            stmt.setString(8,p.getEndereco());
            stmt.executeUpdate();
            //stmt = con.prepareStatement("SELECT * FROM Aluno");
           // p.setId(rs.getInt("id"));
            
            JOptionPane.showMessageDialog(null, "salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt);
                    
        }                  
    }
    
       public boolean checkLogin(String login, String senha){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
         
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM Personal WHERE email = ? and senha = ?");
           stmt.setString(1, login);
           stmt.setString(2, senha);
           
            rs =stmt.executeQuery();
            
            if(rs.next()){
                check = true;
                
           
              
            }
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return check;  
    }
     
       
       public int returnId(String login, String senha){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            int id = 0;
         
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM Personal WHERE email = ? and senha = ?");
           stmt.setString(1, login);
           stmt.setString(2, senha);
           
            rs =stmt.executeQuery();
            
            while(rs.next()){
                id = rs.getInt("idPersonal");
                
            }
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return id;  
    }
      
       public Personal returnPersonal(String login, String senha){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Personal personal = new Personal();
         
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM Personal WHERE email = ? and senha = ?");
           stmt.setString(1, login);
           stmt.setString(2, senha);
           
            rs =stmt.executeQuery();
            
            while(rs.next()){
                personal.setNome(rs.getString("Nome"));
                personal.setCep(rs.getString("cep"));
                personal.setCelular(rs.getString("celular"));
                personal.setCpf(rs.getString("Cpf"));
                personal.setEmail(rs.getString("Email"));
                personal.setRegistro(rs.getString("registro"));
                personal.setEndereco(rs.getString("endereco"));
                personal.setId(rs.getInt("IdPersonal"));

                
                //nome = rs.getString("Nome");
                
            }
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return personal;  
    }
       public Personal returnPersonal(int id){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Personal personal = new Personal();
         
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM Personal WHERE IdPersonal = ?");
           stmt.setInt(1, id);

           
            rs =stmt.executeQuery();
            
            while(rs.next()){
                personal.setNome(rs.getString("Nome"));
                personal.setCep(rs.getString("cep"));
                personal.setCelular(rs.getString("celular"));
                personal.setCpf(rs.getString("Cpf"));
                personal.setEmail(rs.getString("Email"));
                personal.setRegistro(rs.getString("registro"));
                personal.setEndereco(rs.getString("endereco"));
                personal.setId(rs.getInt("IdPersonal"));
                               
            }
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return personal;  
    }
}
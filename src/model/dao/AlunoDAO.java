package model.dao;

import connection.Connectionfactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.Personal;


public class AlunoDAO {
    
    
    public void create(Aluno c){
        Connection con = Connectionfactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO aluno(nome,cpf,email,cep,celular,endereco,Personal_idPersonal) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getCep());
            stmt.setString(5, c.getCelular());
            stmt.setString(6,c.getEndereco());
            stmt.setInt(7, c.getPersonal().getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt);
                    
        }
        
        
        
    }
    
    public void update(Aluno c){
        Connection con = Connectionfactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE aluno SET nome = ?, cpf = ?, email = ?, cep = ?, celular = ?, endereco = ?, Personal_idPersonal  = ? WHERE idAluno = ?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getCep());
            stmt.setString(5, c.getCelular());
            stmt.setString(6,c.getEndereco());
            stmt.setInt(7, c.getPersonal().getId());
            stmt.setInt(8, c.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: "+ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt);
                    
        }
        
        
        
    }
    public void delete(Aluno c){
        Connection con = Connectionfactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM aluno WHERE idAluno = ?");

            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: "+ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt);
                    
        }
        
        
        
    }
   public List<Aluno> read(int id){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            int idcomp;
            List<Aluno> alunos = new ArrayList<>();
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs =stmt.executeQuery();
            while(rs.next()){
              Aluno aluno = new Aluno();
              Personal personal = new Personal();
              aluno.setId(rs.getInt("idAluno"));
              aluno.setNome(rs.getString("Nome"));
              aluno.setCpf(rs.getString("Cpf"));
              aluno.setCep(rs.getString("cep"));
              aluno.setEmail(rs.getString("Email"));
              aluno.setCelular(rs.getString("celular"));
              aluno.setEndereco(rs.getString("endereco"));              
              personal.setId(rs.getInt("Personal_idPersonal"));
              aluno.setPersonal(personal);
              idcomp= personal.getId();
              if(id == idcomp){
              alunos.add(aluno);
              }
            }
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return alunos;  
    }
   public Aluno returnAluno(int id){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Aluno aluno = new Aluno();
         
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM Aluno WHERE IdAluno = ?");
           stmt.setInt(1, id);

           
            rs =stmt.executeQuery();
            
            while(rs.next()){
                aluno.setNome(rs.getString("Nome"));
                aluno.setCep(rs.getString("cep"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setCpf(rs.getString("Cpf"));
                aluno.setEmail(rs.getString("Email"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setId(rs.getInt("Personal_idPersonal"));
                               
            }
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return aluno;  
    }
   
   
}

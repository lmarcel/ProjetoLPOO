/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.Connectionfactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Aluno;
import model.bean.Exercicio;

/**
 *
 * @author almei
 */
public class ExercicioDAO {
    
    
public void create(Exercicio c){
        Connection con = Connectionfactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO exercicio(dia, tipo, nome, series, repeti, Aluno_idAluno) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, c.getDia());
            stmt.setString(2, c.getTipo());
            stmt.setString(3, c.getNome());
            stmt.setString(4, c.getSeries());
            stmt.setString(5, c.getRepeti());
            stmt.setInt(6, c.getAluno().getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Exercício salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt);
                    
        }                    
    }   


   
   public List<Exercicio> read(int id){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            int idcomp;

            List<Exercicio> exercicios = new ArrayList<>();
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM exercicio");
            rs =stmt.executeQuery();
            while(rs.next()){
              Exercicio exercicio = new Exercicio();
              Aluno aluno = new Aluno();

              exercicio.setExerId(rs.getInt("idExercicio"));
              exercicio.setDia(rs.getString("dia"));
              exercicio.setTipo(rs.getString("tipo"));
              exercicio.setNome(rs.getString("nome"));
              exercicio.setSeries(rs.getString("series"));              
              exercicio.setRepeti(rs.getString("repeti"));              
              aluno.setId(rs.getInt("Aluno_idAluno"));
              exercicio.setAluno(aluno);
              idcomp = aluno.getId();
              if(id == idcomp){
              exercicios.add(exercicio);
              }
            }
                    
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "nsso erro: "+ex);
            System.out.println(ex.getMessage());
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return exercicios;  
    }
   public List<Exercicio> selectDay(int id, String day){
            Connection con = Connectionfactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            int idcomp;

            List<Exercicio> exercicios = new ArrayList<>();
            
        try {            
            stmt = con.prepareStatement("SELECT * FROM exercicio WHERE dia LIKE ? ORDER BY tipo");
            stmt.setString(1, "%"+day+"%");
            rs =stmt.executeQuery();
            while(rs.next()){
              Exercicio exercicio = new Exercicio();
              Aluno aluno = new Aluno();

              exercicio.setExerId(rs.getInt("idExercicio"));
              exercicio.setDia(rs.getString("dia"));
              exercicio.setTipo(rs.getString("tipo"));
              exercicio.setNome(rs.getString("nome"));
              exercicio.setSeries(rs.getString("series"));              
              exercicio.setRepeti(rs.getString("repeti"));              
              aluno.setId(rs.getInt("Aluno_idAluno"));
              exercicio.setAluno(aluno);
              idcomp = aluno.getId();
              if(id == idcomp){
              exercicios.add(exercicio);
              }
            }
                    
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "nsso erro: "+ex);
            System.out.println(ex.getMessage());
        }finally{
            Connectionfactory.closeConnection(con, stmt, rs);
        }
            
          return exercicios;  
    }
   
       public void update(Exercicio c){
        Connection con = Connectionfactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE exercicio SET Nome = ?, dia = ?, tipo = ?, series = ?, repeti = ?, Aluno_idAluno  = ? WHERE idExercicio = ?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDia());
            stmt.setString(3, c.getTipo());
            stmt.setString(4, c.getSeries());
            stmt.setString(5, c.getRepeti());
            stmt.setInt(6, c.getAluno().getId());
            stmt.setInt(7, c.getExerId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: "+ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt);
                    
        }
                      
    }
       
           public void delete(Exercicio c){
        Connection con = Connectionfactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM exercicio WHERE idExercicio = ?");

            stmt.setInt(1, c.getExerId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: "+ex);
        }finally{
            Connectionfactory.closeConnection(con, stmt);
                    
        }
                        
    }
           
           
       
       
}

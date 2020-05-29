/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;
import java.sql.*;
/**
 *
 * @author MateoMA
 */
  public class DB {

   
    
  private static Statement connection(){
        
        try {
            
            Connection db  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NasaDB","postgres","pepin1159");
            
            Statement statement = db.createStatement();
            
            return statement;
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
           return null;
    } 
   
    public static ResultSet resultQuery(String sentencia) throws SQLException {
      
       Statement statement = connection();
       
       return statement.executeQuery(sentencia);
    }
  
     
    public static void insert(String sentencia) throws SQLException{
        
       Statement statement = connection();
      
       statement.executeUpdate(sentencia);
    }
 }

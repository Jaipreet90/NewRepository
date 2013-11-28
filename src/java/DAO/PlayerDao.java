/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Player;

/**
 *
 * @author trilok.sharma
 */
public class PlayerDao {
  
    public PlayerDao() {
    }
   
    
    public void insert(Player player) throws NamingException
    {

        
        String INSERT_STMT="insert into Player(name,address,city,province,postal_code) values(?,?,?,?,?)";       // JDBC variables
       
        DataSource ds = null;
        Connection connection = null;
        PreparedStatement insert_stmt = null;
      
        
         try {

            // Retrieve the DataSource from JNDI
            Context ctx = new InitialContext();
            if (ctx == null) {
                throw new RuntimeException("JNDI Context could not be found.");
            }
            ds = (DataSource) ctx.lookup("jdbc/myDatasource");
            
            if (ds == null) {
                throw new RuntimeException("DataSource could not be found.");
            }

            // Get a database connection
            connection = ds.getConnection("root","Simrandeep_singh");

            // Create SQL INSERT statement
            insert_stmt = connection.prepareStatement(INSERT_STMT,RETURN_GENERATED_KEYS);
           
            insert_stmt.setString(1,player.getName());
            insert_stmt.setString(2,player.getAddress());
            insert_stmt.setString(3,player.getCity());
            insert_stmt.setString(4,player.getProvince());
            insert_stmt.setString(5,player.getPostalcode());
            
            int id  = insert_stmt.executeUpdate(); 
            ResultSet generatedKeys = insert_stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            player.setPlayerID(generatedKeys.getInt(1));
            System.out.println("player id--"+player.getPlayerID());
        } else {
            throw new SQLException("Creating user failed, no generated key obtained.");
        }
            
           
            // Get the next Player object ID
            
    }catch (SQLException e) {
            throw new RuntimeException("A database error occured. "
                    + e.getMessage());

            // Handle any JNDI errors
        } catch (NamingException e) {
            throw new RuntimeException("A JNDI error occured. " + e.getMessage());

            // Clean up JDBC resources
        } finally {
            if (insert_stmt != null) {
                try {
                    insert_stmt.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}

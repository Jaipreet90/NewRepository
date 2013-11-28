package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.League;
import model.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DivisionDao {
    public DivisionDao() {
    }
    
    public void insert(Player player, League l, String division) throws NamingException
    {

        String INSERT_STMT="insert into Registration(PID,LID,division) values (?,?,?)";
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
            
            insert_stmt = connection.prepareStatement(INSERT_STMT);
           
            insert_stmt.setInt(1,player.getPlayerID());
            insert_stmt.setLong(2,l.getId());
            insert_stmt.setString(3,division);
           
            int id = insert_stmt.executeUpdate();
            
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

   

    
    
   
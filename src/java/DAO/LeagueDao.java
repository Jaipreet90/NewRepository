
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.League;
import model.Player;

/**
 *
 * @author trilok.sharma
 */
public class LeagueDao {

    public LeagueDao() {
    }
    
     public void insert(League league) throws NamingException
    {
 
        String INSERT_STMT="insert into League(year,season,title)values(?,?,?)";       // JDBC variables
        
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
            insert_stmt = connection.prepareStatement(INSERT_STMT,Statement.RETURN_GENERATED_KEYS);
            
            insert_stmt.setInt(1,league.getYear());
            insert_stmt.setString(2,league.getSeason());
            insert_stmt.setString(3,league.getTitle());
            
            int id  = insert_stmt.executeUpdate();  
            
            ResultSet generatedKeys = insert_stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            league.setId(generatedKeys.getLong(1));
            System.out.println("league id--"+league.getId());
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

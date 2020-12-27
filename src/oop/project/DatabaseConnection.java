

package oop.project;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ibrahim
 */
public class DatabaseConnection {
    
    static Connection conn;
    
    public static Connection createConnection(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketmanagment?autoReconnect=true&useSSL=false", "root", "admin");
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return conn;
    }
    
    public void add(){
        
    };
    
    public void  delete(){
        
    };
}

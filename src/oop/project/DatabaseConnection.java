

package oop.project;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ibrahim
 */
public abstract class DatabaseConnection {
    
    Connection conn;
    
    void createConnection(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketmanagment?autoReconnect=true&useSSL=false", "root", "admin");
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public abstract void add();
    
    public abstract void  delete();
}

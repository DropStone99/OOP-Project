/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author ibrahim
 */
public abstract class Tables {
    
    static  Connection conn = DatabaseConnection.createConnection();
    static  Statement St;
    static  ResultSet Rs;
    JTable  DisplayTable; 

    public Tables(JTable DisplayTable) {
        this.DisplayTable = DisplayTable;
    }
    
    public abstract void DisplayDataInTable();
    
    public abstract void ExecuteQuery(String sql, String message);

}

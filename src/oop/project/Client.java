/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * class is used to get the table of the clients in order.
 * @author ibrahim
 */
public class Client {
    private int ID;
    private String UserName;
    private String Password;
    private String E_mail;
    private int Phone;
    
    public Client(int ID, String UserName, String E_mail, String Password, int Phone) {
        this.ID = ID;
        this.UserName = UserName;
        this.Password = Password;
        this.E_mail = E_mail;
        this.Phone = Phone;
    }

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getE_mail() {
        return E_mail;
    }

    public int getPhone() {
        return Phone;
    }

}

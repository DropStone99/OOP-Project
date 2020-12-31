/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ibrahim
 */
public class ClientTable extends Tables{

    public ClientTable(JTable jtable) {
        super(jtable);
    }


    
    
    public ArrayList<Client> getClientList(){
        
        ArrayList<Client> clientList = new ArrayList<>();
        String sql = "SELECT * FROM CLIENT";
        try {
            St = conn.createStatement();
            Rs = St.executeQuery(sql);
            Client client;
            while(Rs.next()){
                client = new Client(Rs.getInt("C_ID"),Rs.getString("Name"),Rs.getString("E-mail"),Rs.getString("password"),Rs.getInt("phone"));
                clientList.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientList;
        
    }

    @Override
    public void DisplayDataInTable() {
       ArrayList<Client> list = getClientList();
        DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
        Object[] row = new Object[5];
        for(int i = 0 ; i < list.size(); i++){
            
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getUserName();
            row[2] = list.get(i).getE_mail();
            row[3] = list.get(i).getPassword();
            row[4] = list.get(i).getPhone();
            
            model.addRow(row);
            
        }
    }

    @Override
    public void ExecuteQuery(String sql, String message) {
        
    }
    
    public void DisplayTableClickedInTextField(JTextField ID, JTextField ClientName, JTextField Email, JTextField Password, JTextField Phone, JTable DisplayTable){
        int i = DisplayTable.getSelectedRow();
        TableModel modle = DisplayTable.getModel();
        ID.setText(modle.getValueAt(i, 0).toString());
        ClientName.setText(modle.getValueAt(i, 1).toString());
        Email.setText(modle.getValueAt(i, 2).toString());
        Password.setText(modle.getValueAt(i, 3).toString());
        Phone.setText(modle.getValueAt(i, 4).toString());
    }
    
}

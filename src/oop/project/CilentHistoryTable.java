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
public class CilentHistoryTable extends Tables{

    public ArrayList<ClientHistory> getClientHistoryList(){
        
        ArrayList<ClientHistory> clienthistoryList = new ArrayList<>();
        String sql = "SELECT * FROM CLIENT";
        try {
            St = conn.createStatement();
            Rs = St.executeQuery(sql);
            ClientHistory clienthistory;
            while(Rs.next()){
                clienthistory = new ClientHistory(Rs.getInt("ClientID"),Rs.getInt("EventID"),Rs.getString("Date"),Rs.getInt("TicketNumber"));
                clienthistoryList.add(clienthistory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clienthistoryList;
        
    }

    @Override
    public void DisplayDataInTable(JTable DisplayTable) {
       ArrayList<ClientHistory> list = getClientHistoryList();
        DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
        Object[] row = new Object[4];
        for(int i = 0 ; i < list.size(); i++){
            
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getEventID();
            row[2] = list.get(i).getDate();
            row[3] = list.get(i).getTicketNumber();
            
            model.addRow(row);
            
        }
    }

    @Override
    public void ExecuteQuery(String sql, String message) {
        
    }
    
    public void DisplayTableClickedInTextField(JTextField ClientID, JTextField EventID, JTextField Date, JTextField TicketNumber){
        int i = this.DisplayTable.getSelectedRow();
        TableModel modle = this.DisplayTable.getModel();
        ClientID.setText(modle.getValueAt(i, 0).toString());
        EventID.setText(modle.getValueAt(i, 1).toString());
        Date.setText(modle.getValueAt(i, 2).toString());
        TicketNumber.setText(modle.getValueAt(i, 3).toString());
    }
    
}

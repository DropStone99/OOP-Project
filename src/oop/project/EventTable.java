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
public class EventTable extends Tables{
    
    public ArrayList<Event> getEventList(){
        
        ArrayList<Event> EventList = new ArrayList<>();
        String sql = "SELECT * FROM EVENT";
        try {
            St = conn.createStatement();
            Rs = St.executeQuery(sql);
            Event event;
            while(Rs.next()){
                event = new Event(Rs.getInt("E_ID"),Rs.getString("Date"),Rs.getString("Place"),Rs.getString("Description"),Rs.getString("Time"),Rs.getInt("CategoryCode"),Rs.getInt("TicketNumber"));
                EventList.add(event);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return EventList;
        
    }

    @Override
    public void DisplayDataInTable(JTable DisplayTable) {
        ArrayList<Event> list = getEventList();
        DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
        Object[] row = new Object[7];
        for(int i = 0 ; i < list.size(); i++){
            
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getDate();
            row[2] = list.get(i).getPlace();
            row[3] = list.get(i).getDescription();
            row[4] = list.get(i).getTime();
            row[5] = list.get(i).getCategoryCode();
            row[6] = list.get(i).getTicketNumber();
            
            
            model.addRow(row);
            
        }
    }

    @Override
    public void ExecuteQuery(String sql, String message) {
        
    }
    
    public void DisplayTableClickedInTextField(JTextField E_ID, JTextField Date, JTextField Place, JTextField Description, JTextField Time, JTextField CategoryCode, JTextField TicketNumber){
        int i = this.DisplayTable.getSelectedRow();
        TableModel modle = this.DisplayTable.getModel();
        E_ID.setText(modle.getValueAt(i, 0).toString());
        Date.setText(modle.getValueAt(i, 1).toString());
        Place.setText(modle.getValueAt(i, 2).toString());
        Description.setText(modle.getValueAt(i, 3).toString());
        Time.setText(modle.getValueAt(i, 4).toString());
        CategoryCode.setText(modle.getValueAt(i, 5).toString());
        TicketNumber.setText(modle.getValueAt(i, 6).toString());
        
    }
    
}

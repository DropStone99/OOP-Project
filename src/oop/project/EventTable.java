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
import static oop.project.Tables.St;
import static oop.project.Tables.conn;

/**
 *
 * @author ibrahim
 */
public class EventTable extends Tables{

    public EventTable(JTable jtable) {
        super(jtable);
    }


    
    public ArrayList<Event> getEventList(){
        
        ArrayList<Event> EventList = new ArrayList<Event>();
        String sql = "SELECT * FROM `event`";
        try {
            St = conn.createStatement();
            Rs = St.executeQuery(sql);
            Event event;
            while(Rs.next()){
                event = new Event(Rs.getInt("E-code"),Rs.getString("date"),Rs.getString("place"),Rs.getString("Description"),Rs.getString("Time"),Rs.getInt("Category Code"),Rs.getInt("Ticket_Number"));
                EventList.add(event);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return EventList;
        
    }

    @Override
    public void DisplayDataInTable() {
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
        try {
            St = conn.createStatement();
            if(St.executeUpdate(sql) == 1){
                
                DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
                model.setRowCount(0);
                DisplayDataInTable();
                
                JOptionPane.showMessageDialog(null ,"Data "+message+" Succefully");
            }else{
                JOptionPane.showMessageDialog(null ,"Data Not "+message);
            }
        } catch (HeadlessException | SQLException ex) {
        }
    }
    
    public void DisplayTableClickedInTextField(JTextField E_ID, JTextField Date, JTextField Place, JTextField Description, JTextField Time, JTextField CategoryCode, JTextField TicketNumber){
        int i = DisplayTable.getSelectedRow();
        TableModel modle = DisplayTable.getModel();
        E_ID.setText(modle.getValueAt(i, 0).toString());
        Date.setText(modle.getValueAt(i, 1).toString());
        Place.setText(modle.getValueAt(i, 2).toString());
        Description.setText(modle.getValueAt(i, 3).toString());
        Time.setText(modle.getValueAt(i, 4).toString());
        CategoryCode.setText(modle.getValueAt(i, 5).toString());
        TicketNumber.setText(modle.getValueAt(i, 6).toString());
        
    }


}

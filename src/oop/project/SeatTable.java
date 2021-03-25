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
import static oop.project.Tables.Rs;
import static oop.project.Tables.St;
import static oop.project.Tables.conn;

/**
 *
 * @author ibrahim
 */
public class SeatTable extends Tables {

    public SeatTable(JTable DisplayTable) {
        super(DisplayTable);
    }
    
    public ArrayList<Seat> getSeatList(){
        
        ArrayList<Seat> SeatList = new ArrayList<Seat>();
        String sql = "SELECT * FROM Seat";
        try {
            St = conn.createStatement();
            Rs = St.executeQuery(sql);
            Seat seat;
            while(Rs.next()){
                seat = new Seat(Rs.getInt("seat_id"),Rs.getInt("Client id"),Rs.getInt("event id"),Rs.getString("date"),Rs.getInt("Amounts"));
                SeatList.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SeatList;
        
    }
    public ArrayList<Seat> getSeatList(String sql){
        
        ArrayList<Seat> SeatList = new ArrayList<Seat>();
        try {
            St = conn.createStatement();
            Rs = St.executeQuery(sql);
            Seat seat;
            while(Rs.next()){
                seat = new Seat(Rs.getInt("seat_id"),Rs.getInt("Client id"),Rs.getInt("event id"),Rs.getString("date"),Rs.getInt("Amounts"));
                SeatList.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return SeatList;
        
    }

    @Override
    public void DisplayDataInTable() {
        ArrayList<Seat> list = getSeatList();
        DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
        Object[] row = new Object[5];
        for(int i = 0 ; i < list.size(); i++){
            
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getClientID();
            row[2] = list.get(i).getEventID();
            row[3] = list.get(i).getDate();
            row[4] = list.get(i).getAmounts();
            
            model.addRow(row);
            
        } //To change body of generated methods, choose Tools | Templates.
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
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void DisplayTableClickedInTextField(JTextField SeatID,JTextField ClientID, JTextField EventID, JTextField Date, JTextField TicketNumber){
        int i = DisplayTable.getSelectedRow();
        TableModel modle = DisplayTable.getModel();
        SeatID.setText(modle.getValueAt(i, 0).toString());
        ClientID.setText(modle.getValueAt(i, 1).toString());
        EventID.setText(modle.getValueAt(i, 2).toString());
        Date.setText(modle.getValueAt(i, 3).toString());
        TicketNumber.setText(modle.getValueAt(i, 4).toString());
    }
    
}

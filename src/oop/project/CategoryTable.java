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
public class CategoryTable extends Tables{

    public CategoryTable(JTable DisplayTable) {
        super(DisplayTable);
    }

    public  ArrayList<Category> getCategoryList(){
        
        ArrayList<Category> CategoryList = new ArrayList<Category>();
        String sql = "SELECT * FROM category;";
        try {
            St = conn.createStatement();
            Rs = St.executeQuery(sql);
            Category category;
            while(Rs.next()){
                category = new Category(Rs.getInt("Code"),Rs.getString("Name"));
                CategoryList.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return CategoryList;
        
    }
    @Override
    public void DisplayDataInTable() {
        ArrayList<Category> list = getCategoryList();
        DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
        Object[] row = new Object[3];
        for(int i = 0 ; i < list.size(); i++){
            
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getName();
            
            model.addRow(row);
            
        }
    }

    @Override
    public void ExecuteQuery(String sql, String message) {
        
    }
    
    public void DisplayTableClickedInTextField(JTextField Category_ID, JTextField Name){
        int i = DisplayTable.getSelectedRow();
        TableModel modle = DisplayTable.getModel();
        Category_ID.setText(modle.getValueAt(i, 0).toString());
        Name.setText(modle.getValueAt(i, 1).toString());
    }


    

    
}

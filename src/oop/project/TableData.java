/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

/**
 *
 * @author ibrahim
 */
public abstract class TableData {
    
    private int ID;

    public TableData(int ID) {
        this.ID = ID;
    }
    
    public abstract int getID();   
}

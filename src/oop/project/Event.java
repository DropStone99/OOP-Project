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
public class Event extends TableData{
    protected int ID;
    protected String Date;
    protected String Place;
    protected String Description;
    protected String Time;
    protected int CategoryCode;
    protected int TicketNumber;

    public Event(int ID, String Date, String Place, String Description, String Time, int CategoryCode, int TicketNumber) {
        super(ID);
        this.ID = ID;
        this.Date = Date;
        this.Place = Place;
        this.Description = Description;
        this.Time = Time;
        this.CategoryCode = CategoryCode;
        this.TicketNumber = TicketNumber;
    }
    
    @Override
    public int getID() {
        return ID;
    }

    public String getDate() {
        return Date;
    }

    public String getPlace() {
        return Place;
    }

    public String getDescription() {
        return Description;
    }

    public String getTime() {
        return Time;
    }

    public int getCategoryCode() {
        return CategoryCode;
    }

    public int getTicketNumber() {
        return TicketNumber;
    }
    
    
}

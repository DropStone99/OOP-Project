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
public class ClientHistory extends TableData{
    protected int ClientID;
    protected int EventID;
    protected String Date;
    protected int TicketNumber;

    public ClientHistory(int ID, int EventID, String Date, int TicketNumber) {
        super(ID);
        this.ClientID = ID;
        this.EventID = EventID;
        this.Date = Date;
        this.TicketNumber = TicketNumber;
    }

    @Override
    public int getID() {
       return ClientID;
    }

    public int getEventID() {
        return EventID;
    }

    public String getDate() {
        return Date;
    }

    public int getTicketNumber() {
        return TicketNumber;
    }
    
}

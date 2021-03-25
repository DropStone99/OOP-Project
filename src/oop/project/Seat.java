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
public class Seat extends TableData{
    
    protected int SeatID;
    protected int ClientID;
    protected int EventID;
    protected String Date;
    protected int Amounts;

    public Seat(int ID, int ClientID ,int EventID, String Date, int Amounts) {
        super(ID);
        this.SeatID = ID;
        this.ClientID = ClientID;
        this.EventID = EventID;
        this.Date = Date;
        this.Amounts = Amounts;
    }

    @Override
    public int getID() {
        return SeatID;
    }

    public int getClientID() {
        return ClientID;
    }

    public int getEventID() {
        return EventID;
    }

    public String getDate() {
        return Date;
    }

    public int getAmounts() {
        return Amounts;
    }
    
}

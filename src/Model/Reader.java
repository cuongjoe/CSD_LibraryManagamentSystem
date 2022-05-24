/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Reader {
    private int rCode;
    private String name;
    private int bYear;

    public Reader() {
    }

    public Reader(int rCode, String name, int bYear) {
        this.rCode = rCode;
        this.name = name;
        this.bYear = bYear;
    }

    public int getrCode() {
        return rCode;
    }

    public void setrCode(int rCode) {
        this.rCode = rCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-8s | %-8s",rCode,name,bYear);
    }
    
    
    
}

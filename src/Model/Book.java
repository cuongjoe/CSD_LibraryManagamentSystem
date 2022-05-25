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
public class Book {
    private String bCode;
    private String title;
    private int quantity;
    private double price;

    public Book() {
    }

    public Book(String bCode, String title, int quantity, double price) {
        this.bCode = bCode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format (" %5s | %-12s | %-8s | %-8s",bCode,title,quantity,price);
    }
    
    
  
    
    
    
}

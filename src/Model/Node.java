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
public class Node {
    public Node next;
    public Book info;
    
    public Node(){
        
    }

    public Node( Book info ,Node next) {
        this.next = next;
        this.info = info;
    }
    
    public Node (Book b){
        this(b,null);
    }
    
    
}

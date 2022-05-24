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
public class ReaderNode {

  ReaderNode next;
  public Reader info;

    public ReaderNode() {
    }

    public ReaderNode( Reader info,ReaderNode next) {
        this.next = next;
        this.info = info;
    }

    public ReaderNode(Reader b) {
        this(b,null);
    }
  
    
    
  
}

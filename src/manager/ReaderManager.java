/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import Validation.Validation;
import Model.*;


/**
 *
 * @author Admin
 */
public class ReaderManager {
    Validation validate = new Validation();
    private ReaderNode head;
    private ReaderNode tail;
    

    public ReaderManager() {
        head = tail = null;
    }
    boolean isEmpty(){
        return head == null ;
    }
    void clear(){
        head =tail = null;
    }
    void visit(ReaderNode p){
        System.out.println(p.info);
    
    
}
}
    


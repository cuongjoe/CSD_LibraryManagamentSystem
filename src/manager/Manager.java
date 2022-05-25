/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import Validation.Validation;
import java.util.Scanner;

/**
 *
 * @author nguyendinhcuong
 */
public class Manager {
    
    Scanner sc = new Scanner(System.in);
    Validation validate = new Validation();
    public void readerManager(){
        ReaderManager rm = new ReaderManager();
        int choice;
        System.out.println("===============BOOK MANAGER============="+
                "1.1.      Load data from file\n" +
                "1.2.      Input & add to the end\n" +
                "1.3.      Display data\n" +
                "1.4.      Save book list to file\n" +
                "1.5.      Search by bcode\n" +
                "1.6.      Delete by bcode\n" +
                "1.7.      Sort by bcode\n" +
                "1.8.      Input & add to beginning\n" +
                "1.9.      Add after position  k\n" +
                "1.10.    Delete position k\n"+
                "1.0.     Exit\n"
                + "\n==================");
        do{
            System.out.println("Option: ");
            choice = validate.getInt("Your option", "Wrong input", 1, 10);
            switch(choice){
                case 1:                    
            }
        }while(true);     
    } 
}

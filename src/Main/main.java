/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Validation.Validation;
import java.io.IOException;
import java.util.Scanner;
import manager.Manager;

/**
 *
 * @author admin
 */
public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Validation validate = new Validation();
        Manager manager = new Manager();
        
        int choice;
        do {            
            System.out.println("------------MAIN MENU-------------");
            System.out.println("1. Book Manager");
            System.out.println("2. Reader Manager");
            System.out.println("----------------------------------");
            
            choice = validate.getInt("Option: ", "Option from [1,2]", 1, 2);
            switch(choice){
                case 1:
                    manager.bookManager();
                    break;
                case 2:
                    manager.readerManager();
                    break;
            }
            
            
        } while (choice != 0);
    }
}

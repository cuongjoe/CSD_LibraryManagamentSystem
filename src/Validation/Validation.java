/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public String getString(String msg, String err, String regex) {
        while (true) {

            System.out.println(msg);
            String line = sc.nextLine().trim();
            if (line.matches(regex)) {
                return line;
            } else {
                System.out.println(err);
            }
        }
    }

    public int getDouble(String msg, String err) {
        while (true) {
            try {
                System.out.println(msg);
                int num = Integer.parseInt(sc.nextLine().trim());
                if (num < 0) {
                    System.out.println(err);
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }

        }
    }

    public int getInt_2(String msg, String err) {
        while (true) {
            try {
                System.out.println(msg);
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.out.println(err);
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(err);

            }

        }
    }
    public int getInt(String msg , String err , int min , int max){
        while(true){
            try {
                System.out.println(msg);
                int num  = Integer.parseInt(sc.nextLine());
                if( num < min || num > max ){
                    System.out.println(err);
                }else{
                    return num ;
                }
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
              
    }
}

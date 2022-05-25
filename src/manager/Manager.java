/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import Validation.Validation;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nguyendinhcuong
 */
public class Manager {

    Scanner sc = new Scanner(System.in);
    Validation validate = new Validation();

    public void readerManager() throws IOException {
        ReaderManager rm = new ReaderManager();
        int choice;
        do {
            System.out.println("===============READ MANAGER=============\n"
                    + "1.      Load data from file\n"
                    + "2.      Input & add to the end\n"
                    + "3.      Display data\n"
                    + "4.      Save reader list to file\n"
                    + "5.      Search by rcode\n"
                    + "6.      Delete by rcode\n"
                    + "\n==================");

            System.out.println("Option: ");
            choice = Integer.valueOf(sc.nextLine());
            switch (choice) {
                case 1:
                    rm.f1();
                    break;
                case 2:
                    rm.f2();
                    break;
                case 3:
                    rm.f3();
                    break;
                case 4:
                    rm.f4();
                    break;
                case 5:
                    rm.f5();
                    break;
                case 6:
                    rm.f6();
            }
        } while (choice != 0);
    }

    public void bookManager() throws IOException {
        BookManager bm = new BookManager();
        int choice;

        System.out.println("==========BOOK MANAGER==========\n"
                + "1.      Load data from file\n"
                + "2.      Input & add to the end\n"
                + "3.      Display data\n"
                + "4.      Save book list to file\n"
                + "5.      Search by bcode\n"
                + "6.      Delete by bcode\n"
                + "7.      Sort by bcode\n"
                + "8.      Input & add to beginning\n"
                + "9.      Add after position  k\n"
                + "10.    Delete position k"
                + "\n========================");
        System.out.println("\n\t\t-------------------------");
        do {
            System.out.println("Option: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    bm.f1();
                    break;
                case 2:
                    bm.f2();
                    break;
                case 3:
                    bm.f3();
                    break;
                case 4:
                    bm.f4();
                    break;
                case 5:
                    bm.f5();
                    break;
                case 6:
                    bm.f6();
                    break;
                case 7:
                    bm.f7();
                    break;
                case 8:
                    bm.f8();
                    break;
                case 9:
                    bm.f9();
                    break;
                case 10:
                    bm.f10();
                    break;
            }
        } while (choice != 0);

    }

}

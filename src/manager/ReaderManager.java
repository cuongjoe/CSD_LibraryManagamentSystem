/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import Validation.Validation;
import Model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ReaderManager {

    Scanner sc = new Scanner(System.in);
    
    
    
    Validation validate = new Validation();
    private ReaderNode head;
    private ReaderNode tail;

    public ReaderManager() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }
//in ra thong tin cua node
    void visit(ReaderNode p) {
        System.out.println("R0"+p.info);

    }
//in ra toan bo node
    void traverse() {
        ReaderNode p = head;
        while (p != null) {
            visit(p);
            p = p.next;

        }
        System.out.println();
    }
//them vao cuoi cuar linked list
    void addLast(Reader reader) {
        ReaderNode q = new ReaderNode(reader);
        if (isEmpty()) {
            head = tail = q;

        } else {
            tail.next = q;
            tail = q;
        }
    }
//tim kiem node theo code
    ReaderNode SearchNodeByCode(String code) {
        ReaderNode p = head;
        while (p != null) {
            if (String.valueOf(p.info.getrCode()).equalsIgnoreCase(code)) {
                return p;

            }
            p = p.next;
        }
        return null;

    }
//tim kiem theo code
    void searchByCode(String code) {
        ReaderNode p = head;
        System.out.println("rCode    Name    Year");
        while (p != null) {
            if (String.valueOf(p.info.getrCode()).equalsIgnoreCase(code)) {
                visit(p);
            }
            p = p.next;
        }
    }
//xoa node dau tien
    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }

    }
//xoa node bat ki
    void delete(ReaderNode q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            deleteFirst();
            return;
        }
        ReaderNode find = head;
        while (find != null && find.next != q) {
            find = find.next;
        }
        if (find == null) {
            return;
        }
        ReaderNode qNext = q.next;
        find.next = qNext;
        if (find.next == null) {
            tail = find;
        }
    }
//xoa node dua tren code
    void deleteByCode(String code) {
        ReaderNode root = head;
        while (root != null) {
            ReaderNode p = SearchNodeByCode(code);
            delete(p);
            root = root.next;
        }
    }
//tim node lon nhat
    ReaderNode findMaxcode() {
        if (isEmpty()) {
            return null;
        }
        ReaderNode q = null;
        ReaderNode p = head;
        int x;
        x = p.info.getrCode();
        p = p.next;
        while (p != null) {
            if (p.info.getrCode() > x) {
                q = p;
                x = p.info.getrCode();
            }
            p = p.next;

        }
        return (q);

    }
//in ra size
    int size() {
        int i = 0;
        ReaderNode p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }
//doc file 
    void loadFile(String fname) throws IOException {
        BufferedReader br;
        try ( FileReader fr = new FileReader(fname)) {
            br = new BufferedReader(fr);
            String s;
            String a[];
            Reader reader;
            int rCode;
            String name;
            int year;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                rCode = Integer.valueOf(a[0].trim());
                name = a[1].trim();
                year = Integer.valueOf(a[2].trim());

                reader = new Reader(rCode, name, year);
                if (SearchNodeByCode(String.valueOf(reader.getrCode())) == null) {
                    addLast(reader);
                }

            }

        }
        br.close();
    }
    
    
//    String filename = "C://Users//Admin//Documents//GitHub//CSD_LibraryManagamentSystem//src//file/reader.txt";
    String filename = "C://Users//admin//Documents//JAVA-core project//CSD_LibraryManagamentSystem//src//file/reader.txt";
//in file
    void savefile(String filename) {
        try(FileWriter fw = new FileWriter(filename); PrintWriter pw = new PrintWriter(fw)){
            ReaderNode p = head;
            while(p!=null){
                int code = p.info.getrCode();
                String name = p.info.getName();
                int year = p.info.getbYear();
                pw.printf("%-8s | %-8s | &-8s \r\n", code,name,year);
                p = p.next;
            }
        } catch (IOException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Reader getReader(){
        int rCode = 0;
        if(isEmpty()){
            rCode = 0;
        }else{
            rCode = findMaxcode().info.getrCode()+1;
        }
        String name = validate.getString("Name: ", "Please enter character!", "[a-zA-Z0-9]+");
        int year = validate.getInt("Year: ", "Must be between 1900 to 2010", 1900, 2010);
        Reader reader = new Reader(rCode, name, year);
        return reader;
    }
    
    void f1(){
    clear();
        System.out.println("rCode      Name     Year");
        try {
            loadFile(filename);
            traverse();
        } catch (IOException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void f2(){
        Reader reader = getReader();
        if(SearchNodeByCode(String.valueOf(reader.getrCode() ) )== null){
            addLast(reader);
            System.out.println("Success");
            return;            
        }
        System.out.println("existed");
        
        
    }
    void f3(){
        if(isEmpty()){
            System.out.println("Data is Empty");
            return;
        }
        traverse();
    }
   void f4() throws IOException{
       if(isEmpty()){
           System.out.println("Data is Empty");
           return;
       }
       String filename = validate.getString("File name :", "File name format Error", "[a-zA-Z0-9]+");
       savefile("file/" + filename + ".txt") ;
       System.out.println("SAVED");
       
   }
   void f5(){
       if(isEmpty()){
           System.out.println("Data is Empty");
           return;
       }
       System.out.println("rCode : ");
       String rcode = sc.nextLine();
      if(SearchNodeByCode(rcode) != null){
          SearchNodeByCode(rcode);
          return;
      }
       System.out.println("Book not found");
   }
   void f6(){
       if ( isEmpty()){
           System.out.println("Data is Empty");
          return;
       }
       System.out.println("rCode : ");
       String rcode = sc.nextLine();
       if(SearchNodeByCode(rcode) != null){
           deleteByCode(rcode);
           traverse();
           return;
       }
       System.out.println("Book not found ");
      
   }
    public static void main(String[] args) {
        ReaderManager r = new ReaderManager();
        r.f1();
        r.traverse();
//        r.f5();
//        r.f6();
        
    }
    
}
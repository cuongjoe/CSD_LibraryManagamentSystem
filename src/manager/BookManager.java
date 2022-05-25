/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import Model.Book;
import Model.Node;
import Validation.Validation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author nguyendinhcuong
 */
public class BookManager {

    Scanner sc = new Scanner(System.in);
    Validation validate = new Validation();

    Node head;
    Node tail;

    public BookManager() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
    }

    void visit(Node p) {
        System.out.println(p.info);
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addLast(Book book) {
        Node q = new Node(book);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addFirst(Book book) {
        head = new Node(book, head);
        if (tail == null) {
            tail = head;
        }
    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    void insertAfterPos(Node q, Book book) {
        if (q == null) {
            return;
        }
        Node qNext = q.next;
        Node pNew = new Node(book, qNext);
        q.next = pNew;
        if (tail == q) {
            tail = pNew;
        }
    }

    Node searchNodeByCode(String code) {
        Node p = head;
        while (p != null) {
            if (p.info.getbCode().equalsIgnoreCase(code)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void visitBefore(Node p) {
        double value = p.info.getQuantity() * p.info.getPrice();
        String dp = String.format("%-5s   | %-12s | %-8s | %-8s | %-8s",
                p.info.getbCode(), p.info.getTitle(), p.info.getQuantity(), p.info.getPrice(), value);
        System.out.println(dp);
    }

    void searchByCode(String code) {
        Node p = head;
        System.out.println("Code      Title        Quantity    Price      Value");
        while (p != null) {
            if (p.info.getbCode().equalsIgnoreCase(code)) {
                visitBefore(p);
            }
            p = p.next;
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void delete(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            deleteFirst();
            return;
        }
        Node find = head;
        while (find != null && find.next != q) {
            find = find.next;
        }
        if (find == null) {
            return;
        }
        Node qNext = q.next;
        find.next = qNext;
        if (find.next == null) {
            tail = find;
        }
    }

    void deleteByCode(String code) {
        Node root = head;
        while (root != null) {
            Node p = searchNodeByCode(code);
            delete(p);
            root = root.next;
        }
    }

    void updatePriceByCode(String code, int price) {
        Node root = head;
        while (root != null) {
            Node p = searchNodeByCode(code);
            p.info.setPrice(price);
            root = root.next;
        }
    }

    void sortByCodeDEC() {
        Node pi, pj;
        Book b;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.getbCode().compareTo(pj.info.getbCode()) > 0) {
                    b = pj.info;
                    pj.info = pi.info;
                    pi.info = b;
                }
            }
        }
    }

    void sortByCodeINC() {
        Node pi, pj;
        Book b;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pi.info.getbCode().compareTo(pj.info.getbCode()) < 0) {
                    b = pj.info;
                    pj.info = pi.info;
                    pi.info = b;
                }
            }
        }
    }

    void display() {
        Node p = head;
        System.out.println("Code      Title        Quantity    Lended     Price      Value");
        while (p != null) {
            visitBefore(p);
            p = p.next;
        }
        System.out.println();
    }

    void visitNEW(Node p) {
        String dp = String.format("%-5s  %-12s  %-8s  %-8s",
                p.info.getbCode(), p.info.getTitle(), p.info.getQuantity(), p.info.getPrice());
        System.out.println(dp);
    }

    void displayTravel() {
        Node p = head;
        while (p != null) {
            visitNEW(p);
            p = p.next;
        }
        System.out.println();
    }

    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

    void loadFile(String fname) throws IOException {
        BufferedReader br;
        try ( FileReader fr = new FileReader(fname)) {
            br = new BufferedReader(fr);
            String s;
            String a[];
            Book book;
            String bcode, title;
            int quantity;
            double price;
            while (true) {
                s = br.readLine();
                if (s == null || s.trim().length() < 3) {
                    break;
                }
                a = s.split("[|]");
                bcode = a[0].trim();
                title = a[1].trim();
                quantity = Integer.valueOf(a[2].trim());
                price = Double.valueOf(a[3].trim());
                book = new Book(bcode, title, quantity, price);
                if (searchNodeByCode(book.getbCode()) == null) {
                    addLast(book);
                }
            }
        }
        br.close();
    }

    void Savefile(String fname) throws IOException {
        try ( FileWriter fw = new FileWriter(fname);  PrintWriter pw = new PrintWriter(fw)) {
            Node p = head;
            while (p != null) {
                String code = p.info.getbCode();
                String title = p.info.getTitle();
                int quantity = p.info.getQuantity();
                double price = p.info.getPrice();
                pw.printf("%5s   | %-12s | %-8s | %-8s \r\n", code, title, quantity, price);
                p = p.next;
            }
        }
    }

    Book getBook() {
        String bcode = validate.getString("Code : ", "Please enter character!", "[a-zA-Z0-9]+");
        String title = validate.getString("Title : ", "Please enter character!", "[a-zA-Z0-9]+");
        int quantity = validate.getInt_2("Quantity : ", "Quantity must be greater than 0");
        double price = validate.getDouble("Price : ", "Quantity must be greater than 0");

        Book book = new Book(bcode, title, quantity, price);
        return book;
    }

    String file1 = "C://Users//admin//Documents//JAVA-core project//CSD_LibraryManagamentSystem//src//file/book.txt";

    void f1() throws IOException {
        clear();
        System.out.println("Code     Title     Quantity     Price");
        loadFile(file1);
        traverse();
    }

    void f2() {
        Book book = getBook();
        if (searchNodeByCode(book.getbCode()) == null) {
            addLast(book);
            System.out.println("Success");
            return;
        }
        System.out.println("Existed");
    }

    void f3() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        display();
    }

    void f4() throws IOException {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        String filename = validate.getString("Filename: ", "Wrong format", "[a-zA-Z0_9]+");
        Savefile("file/" + filename + ".txt");
        System.out.println("Done");
    }

    void f5() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("bCode");
        String bCode = sc.nextLine();
        if (searchNodeByCode(bCode) != null) {
            searchByCode(bCode);
            return;
        }
        System.out.println("Not found");
    }

    void f6() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        System.out.println("bCode: ");
        String bCode = sc.nextLine();
        if (searchNodeByCode(bCode) != null) {
            deleteByCode(bCode);
            display();
            System.out.println("Already delete");
            return;
        }
        System.out.println("Not found");
    }

    void f7() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        System.out.print("Sort by"
                + "1. Desc\n"
                + "2. Asc\n");
        int choice = validate.getInt("\tOption: ", "Choose between 1 or 2", 1, 2);
        switch (choice) {
            case 1:
                sortByCodeDEC();
                break;
            case 2:
                sortByCodeINC();
                break;
        }
        display();
    }

    void f8(){
        Book book = getBook();
        if(searchNodeByCode(book.getbCode()) == null){
            addFirst(book);
            System.out.println("Success");
            return;
        }
        System.out.println("Already Existed");
    }
    
    void f9(){
        if(isEmpty()){
            System.out.println("Not existed position");
            return;
        }
        int index = validate.getInt("Position: ", "Position from [1, "+ size()+"]", 1, size());
        Book book = getBook();
        insertAfterPos(pos(index-1), book);
        display();
        System.out.println("Success");
    }
    
    void f10(){
        if(isEmpty()){
            System.out.println("List is empty");
            return;
        }
        int index = validate.getInt("Position: ", "Position from [1, "+ size()+"]", 1, size());
        delete(pos(index-1));
        display();
        System.out.println("Deleted");
    }
    public static void main(String[] args) throws IOException {
        BookManager bm = new BookManager();
        bm.f1();
    }
}

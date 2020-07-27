package com.manager.book;

import org.junit.Test;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookManager {
    private Book[] books;
    Scanner scan = new Scanner(System.in);

    SimpleDateFormat simpDate = new SimpleDateFormat("yyyy-MM-dd");

    //初始化：图书馆成立的时候预先增加的一些书
    @Test
    public void init() {
        books = new Book[10];
        //初始化放三本书
        Book book0 = new Book();
        book0.setId(001);
        book0.setState(1);
        book0.setName("JavaEE");
        books[0] = book0;

        Book book1 = new Book();
        book1.setId(002);
        book1.setState(1);
        book1.setName("JavaWeb");
        books[1] = book1;


        Book book2 = new Book();
        book2.setId(003);
        book2.setState(1);
        book2.setName("JavaSSM");
        books[2] = book2;

    }

    public void menu() {
        System.out.println("==============+欢迎进入图书管理系统+============");
        System.out.println("请根据提示选择");
        System.out.println("1.增加图书");
        System.out.println("2.删除图书");
        System.out.println("3.借阅图书");
        System.out.println("4.归还图书");
        System.out.println("5.图书风云榜");
        System.out.println("6.查看图书");
        String choice = scan.next();
        switch (choice) {
            case "1":
                addBook();
                break;
            case "2":
                deleteBook();
                break;
            case "3":
                borrowBook();
                break;

            case "4":
                returnBook();
                break;
            case "5":
                bookRank();
                break;
            case "6":
                showBooks(books);
                break;
            default:
                System.out.println("输入有误:");
                isBreakMenu();
                break;
        }
    }

    private void isBreakMenu() {
        System.out.println("是否返回主菜单: 是（y）/退出（其它）");
        if (scan.next().equals("y"))
            menu();
    }

    private void addBook() {
        System.out.println("增加图书");
        Book newBook = new Book();
        System.out.println("请输入书的编号");
        int id = scan.nextInt();

        System.out.println("请输入书的名字");
        String name = scan.next();

        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setState(1);
        /* 错误代码：这b代表指向数组的一个引用，而b=book，则表示现在不指向数组了而指向new的新对象
        for (Book b : books){
            if (b == null)
                b = book;
            break;
        }*/
        int position = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null)
                position = i;
        }
        if (position != -1) {
            books[position] = book;
            System.out.println("增加成功");
        } else System.out.println("原书架已满");
        isBreakMenu();
    }

    private void deleteBook() {
        System.out.println("删除图书");
        System.out.println("请输入要删除图书的编号");
        int deleteId = scan.nextInt();
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getId() == deleteId) {
                books[i] = null;
                break;
            }
        }
        isBreakMenu();

    }

    private void borrowBook() {
        System.out.println("借阅图书");
        System.out.println("请输入要借阅图书的编号");
        int borrowId = scan.nextInt();
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getId() == borrowId) {
                books[i].setState(0);
                books[i].setBorrowDate(new Date());
                break;
            }
        }
        isBreakMenu();
    }

    private void returnBook() {
        System.out.println("归还图书");
        System.out.println("请输入要归还图书的编号");
        int returnId = scan.nextInt();
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getId() == returnId) {
                books[i].setState(1);
                books[i].setBorrowDate(null);
                books[i].setBorrowCount(books[i].getBorrowCount() + 1);
                break;
            }
        }
        menu();
    }

    private void bookRank() {
        System.out.println("图书风云榜");
        Book[] newBooks = new Book[books.length];
        for (int i = 0; i < newBooks.length; i++) {
            newBooks[i] = books[i];
        }
        int position = -1;
        for (int i = 0; i < newBooks.length; i++) {
            for (int j = 0; j < newBooks.length - i - 1; j++) {
                if (newBooks[j] != null && newBooks[j + 1] != null)
                    if (newBooks[j].getBorrowCount() < newBooks[j + 1].getBorrowCount()) {
                        Book temp = newBooks[j];
                        newBooks[j] = newBooks[j + 1];
                        newBooks[j + 1] = temp;
                    }
            }
        }
        showBooks(newBooks);
        isBreakMenu();
    }

    //查看所有书列表
    private void showBooks(Book[] books) {
        String borrowDate;
        String starte;
        System.out.println("编号\t\t书名\t\t库存\t\t被借日期\t\t被借次数");
        for (Book book : books) {

            if (book != null) {
                borrowDate = book.getBorrowDate() == null ? "-" : simpDate.format(book.getBorrowDate());
                starte = book.getState() == 1 ? "在库" : "不在库";
                System.out.println(book.getId() + "\t\t" + book.getName() + "\t" + starte + "\t\t" + borrowDate + "\t\t\t" +
                        book.getBorrowCount());
            }
        }
        isBreakMenu();
    }

}

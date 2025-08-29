package Project;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Book[] books=new Book[100];
        int bookCount=0;
        while(true){
            System.out.println("====== Library Menu =======");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("Enter your choice");

            int choice=sc.nextInt();
            if(choice==1){
                System.out.println("You selected Add Book");
                System.out.println("Enter Title of Book");
                String title=sc.nextLine();
                System.out.println("Enter Author of Book");
                String author=sc.nextLine();
                boolean exist=false;
                for(int i=0;i<bookCount;i++){
                    if(books[i].title.equalsIgnoreCase(title) && books[i].author.equalsIgnoreCase(author)){
                        exist=true;
                        break;
                    }
                }
                if(!exist){
                    if(bookCount>=books.length){
                        Book[] newBooks=new Book[books.length*2];
                        for(int i=0;i<bookCount;i++){
                            newBooks[i]=books[i];
                        }
                        books=newBooks;
                    }
                    Book newBook=new Book(bookCount+1,title,author);
                    books[bookCount]=newBook;
                    bookCount++;
                    System.out.println("Book added successfully.");
                }
                else{
                    System.out.println("Book is already exist");
                }
                if(bookCount>=books.length){
                    Book[] newBooks=new Book[books.length*2];
                    for(int i=0;i<bookCount;i++){
                        newBooks[i]=books[i];
                    }
                    books=newBooks;
                }
                Book newBook=new Book(bookCount+1,title,author);
                books[bookCount]=newBook;
                bookCount++;
                System.out.println("Book added successfully.");
            }
            else if(choice==2){
                if(bookCount==0){
                    System.out.println("No Books Available");
                }
                else {
                    System.out.println("Displaying All Books..");
                    for(int i=0;i<bookCount;i++){
                        Book b=books[i];
                        System.out.println(b.id+" --> "+b.title+" By "+b.author);
                    }
                }
            }
            else if(choice==3){
                System.out.println("Enter title of Book");
                String title=sc.next();
                boolean flag=false;
                int idx=0;
                for(int i=0;i<bookCount;i++){
                    Book b=books[i];
                    if(b.title.equalsIgnoreCase(title)){
                        idx=i;
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    for(int i=idx;i<bookCount-1;i++){
                        books[i]=books[i+1];
                    }
                    bookCount--;
                }
                else{
                    System.out.println("Book is not available to delete");
                }
            }
            else if(choice==4){
                System.out.println("Enter the Title of Book");
                String title=sc.next();
                boolean flag=false;
                for(int i=0;i<bookCount;i++){
                    Book b=books[i];
                    if(b.title.equalsIgnoreCase(title)){
                        flag=true;
                        System.out.println("Book is available -- ID: " + b.id + " Title: " + b.title + " Author: " + b.author);
                    }
                }
                if(!flag){
                    System.out.println("Book is not available");
                }
            }
            else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }
}

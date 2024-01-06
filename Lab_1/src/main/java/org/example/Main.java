package org.example;

import java.util.ArrayList;
import java.util.Scanner;


class Book
{
    String title;
    String author;
    String isbn;
    int year;

    public Book(String title, String author, String isbn, int year)
    {
        this.title = title;

        this.author = author;

        this.isbn = isbn;

        this.year = year;
    }
}

class Library
{
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book)
    {
        books.add(book);

        System.out.println("Book added to the library.");
    }

    public void showAllBooks()
    {
        if (books.isEmpty())
        {
            System.out.println("The library is empty.");
        }
        else
        {
            System.out.println("Library books:");

            for (Book book : books)
            {
                System.out.println("Title: " + book.title + ", Author: " + book.author + ", ISBN: " + book.isbn + ", Year: " + book.year);
            }
        }
    }

    public void searchBookByTitle(String title)
    {
        for (Book book : books)
        {
            if (book.title.equalsIgnoreCase(title))
            {
                System.out.println("Book found - Title: " + book.title + ", Author: " + book.author + ", ISBN: " + book.isbn + ", Year: " + book.year);

                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public void removeBookByISBN(String isbn)
    {
        for (Book book : books)
        {
            if (book.isbn.equals(isbn))
            {
                books.remove(book);

                System.out.println("Book removed from the library.");

                return;
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("1. Add a book");

            System.out.println("2. Show all books");

            System.out.println("3. Search a book by title");

            System.out.println("4. Remove a book by ISBN");

            System.out.println("5. Exit");


            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter year of publication: ");
                    int year = scanner.nextInt();

                    Book newBook = new Book(title, author, isbn, year);
                    library.addBook(newBook);
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    System.out.print("Enter the title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBookByTitle(searchTitle);
                    break;
                case 4:
                    System.out.print("Enter ISBN to remove: ");
                    String removeISBN = scanner.nextLine();
                    library.removeBookByISBN(removeISBN);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }
}
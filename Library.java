import java.util.*;

public class Library 
{
    static ArrayList<Book> books = new ArrayList<>();
    public static void addBook()
    {
        System.out.println("Enter book details :-");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter book author: ");
        String author = sc.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added to library...");
    }
    public static void removeBook()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title to remove: ");
        String title = sc.nextLine();
        boolean removed = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book removed from library...");
                removed = true;
                break;
            }
        }        
        if (!removed) {
            System.out.println("Book not found in library!!");
        }
    }
    public static void searchBook()
    {
        System.out.print("Enter book title to search: ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found in library!!");
                System.out.println("Title: " + book.title + ", Author: " + book.author); 
                found = true;
                return;
            }
        }
        System.out.println("Book not found in library!!");
    }
    public static void displayBooks()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Books in library :-");
        for (Book book : books) {
            System.out.println("- Title: " + book.title + ", Author: " + book.author);
        }
        System.out.println("Books in library displayed!!");
    }
    public static void updateBook()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title to update: ");
        String title = sc.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.print("Enter new book title: ");
                String newTitle = sc.nextLine();
                System.out.print("Enter new book author: ");
                String newAuthor = sc.nextLine();
                books.set(books.indexOf(book), new Book(newTitle, newAuthor));
                System.out.println("Book details updated successfully!!");
                return;
            }
        }
        System.out.println("Book not found in library!!");
    }
    public static void borrowBook()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title to borrow: ");
        String title = sc.nextLine();

        for(Book book : books)
        {
            if(book.title.equalsIgnoreCase(title))
            {
                if(book.issued)
                {
                    System.out.println("Book is already borrowed.");
                }
                else
                {
                    System.out.print("Enter borrower name: ");
                    String borrower = sc.nextLine();
                    book.issued = true;
                    System.out.println(borrower + " borrowed \"" + book.title + "\" successfully.");
                }
                return;
            }
        }
        System.out.println("Book is not available in library.");
    }
    public void run()
    {
        int choice;
        Scanner sc=new Scanner(System.in);
        
        do{

            System.out.println("\n===Library Management System===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Update Book");
            System.out.println("6. Borrow Book");
            System.out.print("Enter your choice : ");
            choice=sc.nextInt();

            if(choice < 7)
            {
                if(choice <= 6)
                {
                    switch (choice) {
                        case 1:
                            addBook();
                            break;
                        case 2:
                            removeBook();
                            break;
                        case 3:
                            searchBook();
                            break;
                        case 4:
                            displayBooks();
                            break;
                        case 5:
                            updateBook();
                            break;
                        case 6:
                            borrowBook();
                            break;
                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                }
            }
            else if(choice == 7){
            System.out.println("Exiting Library Management System. Goodbye!");
            }
            else{
                System.out.println("Invalid choice! Please try again.");
            }
        }while(choice != 7);
    }
    

    public static void main(String args[]){
        Library lib = new Library();
        lib.run();
    }
}

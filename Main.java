import java.util.*;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issueBook() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }
}

// User class (optional for future expansion)
class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() { return name; }
    public int getUserId() { return userId; }
}

// Library class
class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issueBook();
                System.out.println(title + " issued successfully.");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println(title + " returned successfully.");
                return;
            }
        }
        System.out.println("Book not found or wasn't issued.");
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - " +
                (book.isIssued() ? "Issued" : "Available"));
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Java Basics", "James Gosling"));
        lib.addBook(new Book("Effective Java", "Joshua Bloch"));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show books");
            System.out.println("2. Issue book");
            System.out.println("3. Return book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear newline buffer

            switch (choice) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    lib.issueBook(issueTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    lib.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Thank you for using the library system!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

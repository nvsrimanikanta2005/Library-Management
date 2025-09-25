import java.util.*;
class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }
}
class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        System.out.println("\nBooks in Library:");
        for (Book b : books) {
            String status = b.isIssued ? "Taken1" : "Available";
            System.out.println(b.id + ". " + b.title + " (" + status + ")");
        }
    }
    void issueBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book '" + b.title + "' given to " + user.name);
                } else {
                    System.out.println("Book is already taken");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
    void returnBook(int bookId, User user) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book '" + b.title + "' returned by " + user.name);
                } else {
                    System.out.println("This book was not taken");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        library.addBook(new Book(1, "Java Programming"));
        library.addBook(new Book(2, "Python Basics"));
        library.addBook(new Book(3, "Data Structures"));
        System.out.print("Enter your User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        User user = new User(id, name);
        int choice;
        do {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Show Books");
            System.out.println("2. Take Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    library.showBooks();
                    System.out.print("Enter Book ID to take: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId, user);
                    break;
                case 3:
                    library.showBooks();
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId, user);
                    break;
                case 4:
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 9.99, "Fiction"));
        library.addBook(new Book("1984", "George Orwell", 1949, 8.99, "Science Fiction"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", 1813, 7.99, "Romance"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 10.99, "Fiction"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 9.99, "Fiction"));
        library.addBook(new Book("To the Lighthouse", "Virginia Woolf", 1927, 12.99, "Fiction"));
        library.addBook(new Book("Brave New World", "Aldous Huxley", 1932, 8.99, "Science Fiction"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 11.99, "Fantasy"));
        library.addBook(new Book("The Odyssey", "Homer", -800, 6.99, "Epic Poetry"));
        library.addBook(new Book("Hamlet", "William Shakespeare", 1599, 7.99, "Drama"));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 24.99, "Fantasy"));
        library.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 14.99, "Fantasy"));
        library.addBook(new Book("The Alchemist", "Paulo Coelho", 1988, 9.99, "Fiction"));
        library.addBook(new Book("The Chronicles of Narnia", "C.S. Lewis", 1950, 19.99, "Fantasy"));
        library.addBook(new Book("Moby-Dick", "Herman Melville", 1851, 13.99, "Adventure"));
        library.addBook(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890, 8.99, "Gothic Fiction"));

        // Perform searches
        List<Book> booksByAuthor = library.searchByAuthor("J.K. Rowling");
        List<Book> booksByYear = library.searchByYear(1890);
        List<Book> booksByTitle = library.searchByTitle("Hamlet");
        List<Book> booksByGenre = library.searchByGenre("Fantasy");

        // Perform aggregation operations
        double averagePrice = library.averageBookPrice();
        Book mostExpensive = library.mostExpensiveBook();
        Book cheapest = library.cheapestBook();
        Book oldest = library.oldestBook();
        List<Book> recentBooks = library.recentBooks(5);

        // Print sorted books
        System.out.println("Books sorted by title:");
        library.printBooksSortedByTitle();

        System.out.println("Books sorted by author:");
        library.printBooksSortedByAuthor();

        System.out.println("Books sorted by publication year:");
        library.printBooksSortedByPublicationYear();

        // Perform advanced queries
        String authorWithMostBooks = library.authorWithMostBooks();
        String mostPopularGenre = library.mostPopularGenre();
        int yearWithMostPublishedBooks = library.yearWithMostPublishedBooks();

        // Print the results
        System.out.println("Books by author: " + booksByAuthor);
        System.out.println("Books by year: " + booksByYear);
        System.out.println("Books by title: " + booksByTitle);
        System.out.println("Books by genre: " + booksByGenre);
        System.out.println("Average book price: " + averagePrice);
        System.out.println("Most expensive book: " + mostExpensive);
        System.out.println("Cheapest book: " + cheapest);
        System.out.println("Oldest book: " + oldest);
        System.out.println("Recent books: " + recentBooks);
        System.out.println("Author with most books: " + authorWithMostBooks);
        System.out.println("Most popular genre: " + mostPopularGenre);
        System.out.println("Year with most published books: " + yearWithMostPublishedBooks);
    }
}
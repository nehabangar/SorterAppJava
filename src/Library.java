import java.util.*;
import java.util.stream.Collectors;

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchByYear(int year) {
        return books.stream()
                .filter(book -> book.getYearOfPublication() == year)
                .collect(Collectors.toList());
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public double averageBookPrice() {
        return books.stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);
    }

    public Book mostExpensiveBook() {
        return books.stream()
                .max(Comparator.comparing(Book::getPrice))
                .orElse(null);
    }

    public Book cheapestBook() {
        return books.stream()
                .min(Comparator.comparing(Book::getPrice))
                .orElse(null);
    }

    public Book oldestBook() {
        return books.stream()
                .min(Comparator.comparing(Book::getYearOfPublication))
                .orElse(null);
    }

    public List<Book> recentBooks(int years) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int targetYear = currentYear - years;

        return books.stream()
                .filter(book -> book.getYearOfPublication() >= targetYear)
                .collect(Collectors.toList());
    }

    public void printBooksSortedByTitle() {
        printBookListHeader("Books Sorted by Title");
        books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(this::printBook);
        printBorder();
    }

    public void printBooksSortedByAuthor() {
        printBookListHeader("Books Sorted by Author");
        books.stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .forEach(this::printBook);
        printBorder();
    }

    public void printBooksSortedByPublicationYear() {
        printBookListHeader("Books Sorted by Publication Year");
        books.stream()
                .sorted(Comparator.comparing(Book::getYearOfPublication))
                .forEach(this::printBook);
        printBorder();
    }

    private void printBookListHeader(String header) {
        int headerLength = header.length();
        printBorder();
        System.out.println("| " + header + " |");
        printBorder();
    }

    private void printBook(Book book) {
        System.out.println("| Title: " + book.getTitle());
        System.out.println("| Author: " + book.getAuthor());
        System.out.println("| Year: " + book.getYearOfPublication());
        System.out.println("| Price: " + book.getPrice());
        System.out.println("| Genre: " + book.getGenre());
        printBorder();
    }

    private void printBorder() {
        System.out.println("+----------------------------------+");
    }

    public String authorWithMostBooks() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String mostPopularGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public int yearWithMostPublishedBooks() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getYearOfPublication, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}

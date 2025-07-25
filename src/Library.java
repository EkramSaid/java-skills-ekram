public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        Book book2 = new Book("1984", "George Orwell", 328);
        Textbook textbook = new Textbook("Java Programming", "John Smith", 500, "Computer Science", 3);

        book1.borrowBook();
        book1.displayInfo();
        book1.returnBook();

        System.out.println("\n---");

        book2.displayInfo();
        book2.borrowBook();

        System.out.println("\n---");

        textbook.displayInfo();
        textbook.borrowBook();
    }
}

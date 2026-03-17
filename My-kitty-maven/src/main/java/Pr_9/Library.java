package Pr_9;

public class Library {
    private String name;

    public Library(String name) {
        this.name = name;
    }
    public class Book{
        private String author;
        private String title;

        public Book(String author, String title) {
            this.author = author;
            this.title = title;
        }
        public String bookLabel(){
            return "Library: " + name + "author" + author + "title: " + title;
        }
    }
}

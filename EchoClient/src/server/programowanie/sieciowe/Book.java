package server.programowanie.sieciowe;

public abstract class Book implements Comparable<Book> {

    private double value;
    private int ISBNnumber;
    private String title, author, publisher;

    public Book() {
        this(0000);
    }
 
    public Book(int ISBNnumber) {
        this(ISBNnumber, "TITLE");
    }

    public Book(int ISBNnumber, String title) {
        this(ISBNnumber, title, "AUTHOR");
    }

    public Book(int ISBNnumber, String title, String author) {
        this(ISBNnumber, title, author, "PUBLISHER");
    }

    public Book(int ISBNnumber, String title, String author,
            String publisher) {
        this(ISBNnumber, title, author, publisher, 0.00);
    }

    public Book(int ISBNnumber, String title, String author,
            String publisher, double value) {
        this.ISBNnumber = ISBNnumber;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.value = value;
    }
    
    public String toString() {
        return "ISBN:" + ISBNnumber + " Tytuł:" + title + " Autor:" + author + " Wydawca:" + publisher + " Cena:" + value + "zł ";
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if(value>0.00)
            this.value = value;
        else
            System.out.println("Incorrect data");
    }

    public int getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(int ISBNnumber) {
        if(ISBNnumber>0)
            this.ISBNnumber = ISBNnumber;
        else
            System.out.println("Incorrect data");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length()>0)
            this.title = title;
        else
            System.out.println("Incorrect data");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.length()>0)
            this.author = author;
        else
            System.out.println("Incorrect data");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if(publisher.length()>0)
            this.publisher = publisher;
        else
            System.out.println("Incorrect data");
    }

    @Override
    public final int compareTo(Book b) {
        return this.getISBNnumber()-b.getISBNnumber();
    }
  
    public final boolean equals(Book b){
        if(this.getISBNnumber()>b.getISBNnumber() || this.getISBNnumber()<b.getISBNnumber())
            return false;
        return true;
    }
}

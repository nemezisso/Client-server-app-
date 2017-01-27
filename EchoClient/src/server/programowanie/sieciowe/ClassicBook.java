package server.programowanie.sieciowe;
/**
 * Klasa ClassicBook dziedziczy po klasie Book
 * Posiada pola, które mogą posiadać tylko książki papierowe
 * 
 * @author Bartek
 */
public class ClassicBook extends Book{
    private String binding;
    private int pageCount;
    private double weight;
    
    public ClassicBook(int ISBNnumber, String title, String author,
                String publisher, double value){
        super(ISBNnumber,title,author,publisher,value);
        this.pageCount=00;
        this.weight=00;
        this.binding="BINDING";
    }
    public ClassicBook(int ISBNnumber, String title, String author,
                String publisher, double value,int pageCount){
        super(ISBNnumber,title,author,publisher,value);
        this.pageCount=pageCount;
        this.weight=00;
        this.binding="BINDING";
    }
    public ClassicBook(int ISBNnumber, String title, String author,
                String publisher, double value,int pageCount,double weight){
        super(ISBNnumber,title,author,publisher,value);
        this.pageCount=pageCount;
        this.weight=weight;
        this.binding="BINDING";
    }
    /**
     * Konstruktor klasy ClassicBook
     * @param ISBNnumber numer ISBN książki
     * @param title tytuł książki
     * @param author autor książki
     * @param publisher wydawca książki
     * @param value cena książki
     * @param pageCount ilość stron książki
     * @param weight waga książki (w kilogramach)
     * @param binding oprawa książki (twarda, miękka)
     */
    public ClassicBook(int ISBNnumber, String title, String author,
                String publisher, double value,int pageCount,double weight,String binding){
        super(ISBNnumber,title,author,publisher,value);
        this.pageCount=pageCount;
        this.weight=weight;
        this.binding=binding;
    }

    @Override
    public String toString() {
        return super.toString()+"Liczba stron:"+pageCount+" Waga:"+weight+"kg Oprawa:"+binding+" ";
    }
    
    public String getBinding() {
        return binding;
    }
    public void setBinding(String binding) {
        this.binding = binding;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }   

}
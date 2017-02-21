package server.programowanie.sieciowe;
/** Klasa Ebook dziedziczy po klasie DigitalBook
 * 
 * @author Bartek
 */
public class Ebook extends DigitalBook {
    private String format;
    
    public Ebook(int ISBNnumber, String title, String author,
                String publisher, double value,double size,boolean DRM,
                String quality){
        super(ISBNnumber,title,author,publisher,value,size,DRM,quality);
        this.format="PDF";
    }
     /**
     * Konstruktor klasy Ebook
     * @param ISBNnumber numer ISBN książki
     * @param title tytuł książki
     * @param author autor książki
     * @param publisher wydawca książki
     * @param value cena książki
     * @param size rozmiar w kb książki
     * @param DRM zabezpieczenie w postaci DRM książki (true/false)
     * @param quality jakość książki
     * @param format format książki (mobi, pdf itd.)
     */
    public Ebook(int ISBNnumber, String title, String author,
                String publisher, double value,double size,boolean DRM,
                String quality,String format){
        super(ISBNnumber,title,author,publisher,value,size,DRM,quality);
        this.format=format;
    }

    @Override
    public String toString() {
        return super.toString()+"Format:"+format+" ";
    }
    
    
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        if(format.length()>0)
            this.format = format;
        else
            System.out.println("Incorrect data");
    }

    
}


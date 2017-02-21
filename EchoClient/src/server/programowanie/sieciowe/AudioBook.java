package server.programowanie.sieciowe;
/**
 * Klasa AudioBooka, dziedziczy po klasie DigitalBook
 * rozszerza ją o dodatkowe pola 
 * @author Bartek
 */
public class AudioBook extends DigitalBook{
    private String format;
    private double duration;
    
    public AudioBook(int ISBNnumber, String title, String author,
                String publisher, double value,double size,boolean DRM,
                String quality){
        super(ISBNnumber,title,author,publisher,value,size,DRM,quality);
        this.format="XYZ";
        this.duration=1.0;
    }
    public AudioBook(int ISBNnumber, String title, String author,
                String publisher, double value,double size,boolean DRM,
                String quality, String format){
        super(ISBNnumber,title,author,publisher,value,size,DRM,quality);
        this.format=format;
        this.duration=1.0;
    }
    /**
     * Konstruktor klasy AudioBook
     * @param ISBNnumber numer ISBN książki
     * @param title tytuł książki
     * @param author autor książki
     * @param publisher wydawca książki
     * @param value cena książki
     * @param size rozmiar w kb książki
     * @param DRM zabezpieczenie w postaci DRM książki (true/false)
     * @param quality jakość książki
     * @param format format cyfrowy książki (audio,mp3 itd.)
     * @param duration czas trwania książki (w godzinach)
     */
    public AudioBook(int ISBNnumber, String title, String author,
                String publisher, double value,double size,boolean DRM,
                String quality, String format, double duration){
        super(ISBNnumber,title,author,publisher,value,size,DRM,quality);
        this.format=format;
        this.duration=duration;
    }

    @Override
    public String toString() {
        return super.toString()+"Format:"+format+" Czas trwania:"+duration+"h ";
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        if(duration>0.00)
             this.duration = duration;
        else
            System.out.println("Incorrect data");
    }

    
      
}


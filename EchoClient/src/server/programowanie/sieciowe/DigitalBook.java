package server.programowanie.sieciowe;
/**
 * Klasa abstakcyjna dziedzicząca po klasie Book
 * Są tu dodatkowe pola, należące tylko do książek cyfrowych.
 * @author Bartek
 */
public abstract class DigitalBook extends Book{
    private String quality;
    private double size;
    private boolean DRM;
    
    public DigitalBook(int ISBNnumber, String title, String author,
                String publisher, double value){
        super(ISBNnumber,title,author,publisher,value);
        this.size=100;
        this.DRM=true;
        this.quality="QUALITY";
    }
    public DigitalBook(int ISBNnumber, String title, String author,
                String publisher, double value,double size){
        super(ISBNnumber,title,author,publisher,value);
        this.size=size;
        this.DRM=true;
        this.quality="QUALITY";
    }
    public DigitalBook(int ISBNnumber, String title, String author,
                String publisher, double value,double size,boolean DRM){
        super(ISBNnumber,title,author,publisher,value);
        this.size=size;
        this.DRM=DRM;
        this.quality="QUALITY";
    }
    public DigitalBook(int ISBNnumber, String title, String author,
                String publisher, double value,double size,boolean DRM,String quality){
        super(ISBNnumber,title,author,publisher,value);
        this.size=size;
        this.DRM=DRM;
        this.quality=quality;
    }

    @Override
    public String toString() {
        return super.toString()+"Rozmiar:"+size+" DRM:"+DRM+" Jakość:"+quality+" ";
    }

    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public boolean isDRM() {
        return DRM;
    }
    public void setDRM(boolean DRM) {
        this.DRM = DRM;
    }
}

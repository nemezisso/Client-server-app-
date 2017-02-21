package client.programowanie.sieciowe;

import javax.swing.JOptionPane;

/** Klasa dzięki której możemy wywołać statyczne metody,
 * pozwalające na dodawanie książek i wysłanie do serwera
 *
 * Metody statyczne zwracają String, ponieważ łatwo można edytować zawartość
 * @author Bartek
 */
public class GenerateBook {
    
    /** Klasa pobierająca od urzytkowika dane dotyczące książki klasycznej
     * 
     * @return String classicBook
     */
    public static String GenerateClassicBook(){
        String classic="ISBN:"+ISBNstring()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+valueString()+"zł Liczba stron:"+pageCountString()+" Waga:"+
                weightString()+"kg Oprawa:"+binding();
        return classic;
    }
    /** Klasa pobierająca od urzytkowika dane dotyczące Ebooka
     * 
     * @return String Ebook
     */
    public static String GenerateEbook(){
        String ebook="ISBN:"+ISBNstring()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+valueString()+"zł Rozmiar:"+sizeString()+" DRM:"+DRM()+
                " Jakość:"+quality()+" Format:"+format();
        return ebook;
    }
    /** Klasa pobierająca od urzytkowika dane dotyczące Audiobooka
     * 
     * @return String Audiobook
     */
    public static String GenerateAudioBook(){
        String audio="ISBN:"+ISBNstring()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+valueString()+"zł Rozmiar:"+sizeString()+" DRM:"+DRM()+
                " Jakość:"+quality()+" Format:"+format()+" Czas trwania:"+durationString()+"h";
        return audio;
    }
    /**
     * Statyczna metoda zwracająca numer ISBN
     * W zwróconym stringu znajdować się znajdować się będzie numer ISBN
     * @return String ISBN 
     */
    public static String ISBNstring(){
        String ISBNstring;
        while(true){
                try{
                ISBNstring=JOptionPane.showInputDialog(null,"Podaj numer ISBN ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać liczbę!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        
        return ISBNstring;
    }
    /**
     * Statyczna metoda zwracająca tytuł
     * W zwróconym stringu znajdować się znajdować się będzie tytuł książki
     * @return String title
     */
    public static String title(){
        String title;
        while(true){
                try{
                title=JOptionPane.showInputDialog(null,"Podaj tytuł ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać tytuł!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return title;
    }
    /**
     * Statyczna metoda zwracająca Autora
     * W zwróconym stringu znajdować się znajdować się będą dane autora
     * @return String author
     */
    public static String author(){
        String author;
        while(true){
                try{
                author=JOptionPane.showInputDialog(null,"Podaj autora ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać autora!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return author;
    }
    /**
     * Statyczna metoda zwracająca nazwę wydawcy
     * W zwróconym stringu znajdować się znajdować się będzie nazwa wydawcy
     * @return String publisher
     */
    private static String publisher(){
        String publisher;
        while(true){
                try{
                publisher=JOptionPane.showInputDialog(null,"Podaj nazwę wydawcy ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać nazwę wydawcy!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return publisher;
    }
    /**
     * Statyczna metoda zwracająca cenę
     * W zwróconym stringu znajdować się znajdować się będzie cena
     * @return String value
     */
    private static String valueString(){
        String valueString;
        while(true){
                try{
                valueString=JOptionPane.showInputDialog(null,"Podaj cenę: ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać cenę!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return valueString;
    }
    /**
     * Statyczna metoda zwracająca liczbę stron
     * W zwróconym stringu znajdować się znajdować się będzie liczba stron książki
     * @return String pageCount
     */
    private static String pageCountString(){
        String pageCountString;
        while(true){
                try{
                pageCountString=JOptionPane.showInputDialog(null,"Podaj liczbę stron: ","Książka klasyczna",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać liczbę stron!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return pageCountString;
    }
    /**
     * Statyczna metoda zwracająca wagę książki
     * W zwróconym stringu znajdować się znajdować się będzie liczba z wagą książki
     * @return String ISBN 
     */
    private static String weightString(){
        String weightString;
        while(true){
                try{
                weightString=JOptionPane.showInputDialog(null,"Podaj wagę: ","Książka klasyczna",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać wagę!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return weightString;
    }
    /**
     * Statyczna metoda zwracająca oprawę
     * W zwróconym stringu znajdować się znajdować się będzie tekst
     * twarda/miękka oprawa
     * @return String binding
     */
    private static String binding(){
        String binding;
        while(true){
                try{
                binding=JOptionPane.showInputDialog(null,"Podaj rodzaj okładki(miękka,twarda) ","Książka klasyczna",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać rodzaj okładki!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return binding;
    }
    /**
     * Statyczna metoda zwracająca format
     * W zwróconym stringu znajdować się znajdować się będzie format książki
     * np. pdf, mobi, mp3, audio itd.
     * @return String format
     */
    private static String format(){
        String format;
        while(true){
                try{
                format=JOptionPane.showInputDialog(null,"Podaj format cyfrowy ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać format cyfrowy!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return format;
    }
    /**
     * Statyczna metoda zwracająca jakość książki
     * W zwróconym stringu znajdować się znajdować się będzie napis z jaką jakość posiada książka
     * słaba, dobra, bardzo dobra itd.
     * @return String quality
     */
    private static String quality(){
        String quality;
        while(true){
                try{
                quality=JOptionPane.showInputDialog(null,"Podaj jakość(słaba,niska,średnia,dobra,bardzo dobra ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać jakość!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return quality;
    }
    /**
     * Statyczna metoda zwracająca rozmiar książki
     * W zwróconym stringu znajdować się znajdować się będzie rozmar książki w kb
     * @return String size
     */
    private static String sizeString(){
        String sizeString;
        while(true){
                try{
                sizeString=JOptionPane.showInputDialog(null,"Podaj rozmiar: ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać rozmiar!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return sizeString;
    }
    /**
     * Statyczna metoda zwracająca czas trwania
     * W zwróconym stringu znajdować się znajdować się będzie 
     * czas trwania podany w godzinach
     * @return String duration
     */
    private static String durationString(){
        String durationString;
        while(true){
                try{
                durationString=JOptionPane.showInputDialog(null,"Podaj czas trwania: ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać czas trwania!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return durationString;
    }
    /**
     * Statyczna metoda zwracająca DRM
     * Metoda zwraca prawdę jeśli książka posiada zabezpieczenie w postaci DRM
     * Jeśli nie posiada zabezpieczenia metoda zwraca fałsz
     * @return boolean DRM
     */
    private static boolean DRM(){
       String DRM;
       String[] choose={"Tak","Nie"};
       while(true){
                try{
                 DRM =(String)JOptionPane.showInputDialog(null,"Czy książka posiada zabezpieczenie DRM?","Książka cyfrowa",
                 JOptionPane.QUESTION_MESSAGE,null,choose,0);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Błąd","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
       }
       if(DRM=="Tak") return true;
       
       return false;
    }
}

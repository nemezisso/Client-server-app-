package client.programowanie.sieciowe;

import javax.swing.JOptionPane;

/** Klasa dzięki której możemy wywołać statyczne metody,
 * pozwalające na dodawanie książek i wysłanie do serwera
 *
 * @author Bartek
 */
public class GenerateBook {
    
    /** Klasa pobierająca od urzytkowika dane dotyczące książki klasycznej
     * 
     * @return String classicBook
     */
    public static String GenerateClassicBook(){
        String classic="ISBN:"+ISBN()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+value()+"zł Liczba stron:"+pageCount()+" Waga:"+
                weight()+"kg Oprawa:"+binding();
        return classic;
    }
    /** Klasa pobierająca od urzytkowika dane dotyczące Ebooka
     * 
     * @return String Ebook
     */
    public static String GenerateEbook(){
        String ebook="ISBN:"+ISBN()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+value()+"zł Rozmiar:"+size()+" DRM:"+DRM()+
                " Jakość:"+quality()+" Format:"+format();
        return ebook;
    }
    /** Klasa pobierająca od urzytkowika dane dotyczące Audiobooka
     * 
     * @return String Audiobook
     */
    public static String GenerateAudioBook(){
        String audio="ISBN:"+ISBN()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+value()+"zł Rozmiar:"+size()+" DRM:"+DRM()+
                " Jakość:"+quality()+" Format:"+format()+" Czas trwania:"+duration()+"h";
        return audio;
    }
    /**
     * Statyczna metoda zwracająca numer ISBN
     * W zwróconym stringu znajdować się znajdować się będzie numer ISBN
     * @return String ISBN 
     */
    private static String ISBN(){
        String str;
        int foo;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj numer ISBN ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                foo=Integer.parseInt(str);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać liczbę!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        
        return str;
    }
    /**
     * Statyczna metoda zwracająca tytuł
     * W zwróconym stringu znajdować się znajdować się będzie tytuł książki
     * @return String title
     */
    private static String title(){
        String str;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj tytuł ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać tytuł!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca Autora
     * W zwróconym stringu znajdować się znajdować się będą dane autora
     * @return String author
     */
    private static String author(){
        String str;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj autora ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać autora!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca nazwę wydawcy
     * W zwróconym stringu znajdować się znajdować się będzie nazwa wydawcy
     * @return String publisher
     */
    private static String publisher(){
        String str;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj nazwę wydawcy ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać nazwę wydawcy!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca cenę
     * W zwróconym stringu znajdować się znajdować się będzie cena
     * @return String value
     */
    private static String value(){
        String str;
        double foo;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj cenę: ","Książka",
                    JOptionPane.QUESTION_MESSAGE);
                foo=Double.parseDouble(str);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać cenę!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca liczbę stron
     * W zwróconym stringu znajdować się znajdować się będzie liczba stron książki
     * @return String pageCount
     */
    private static String pageCount(){
        String str;
        int foo;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj liczbę stron: ","Książka klasyczna",
                    JOptionPane.QUESTION_MESSAGE);
                foo=Integer.parseInt(str);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać liczbę stron!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca wagę książki
     * W zwróconym stringu znajdować się znajdować się będzie liczba z wagą książki
     * @return String ISBN 
     */
    private static String weight(){
        String str;
        double foo;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj wagę: ","Książka klasyczna",
                    JOptionPane.QUESTION_MESSAGE);
                foo=Double.parseDouble(str);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać wagę!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca oprawę
     * W zwróconym stringu znajdować się znajdować się będzie tekst
     * twarda/miękka oprawa
     * @return String binding
     */
    private static String binding(){
        String str;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj rodzaj okładki(miękka,twarda) ","Książka klasyczna",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać rodzaj okładki!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca format
     * W zwróconym stringu znajdować się znajdować się będzie format książki
     * np. pdf, mobi, mp3, audio itd.
     * @return String format
     */
    private static String format(){
        String str;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj format cyfrowy ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać format cyfrowy!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca jakość książki
     * W zwróconym stringu znajdować się znajdować się będzie napis z jaką jakość posiada książka
     * słaba, dobra, bardzo dobra itd.
     * @return String quality
     */
    private static String quality(){
        String str;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj jakość(słaba,niska,średnia,dobra,bardzo dobra ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać jakość!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca rozmiar książki
     * W zwróconym stringu znajdować się znajdować się będzie rozmar książki w kb
     * @return String size
     */
    private static String size(){
        String str;
        double foo;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj rozmiar: ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                foo=Double.parseDouble(str);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać rozmiar!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca czas trwania
     * W zwróconym stringu znajdować się znajdować się będzie 
     * czas trwania podany w godzinach
     * @return String duration
     */
    private static String duration(){
        String str;
        double foo;
        while(true){
                try{
                str=JOptionPane.showInputDialog(null,"Podaj czas trwania: ","Książka cyfrowa",
                    JOptionPane.QUESTION_MESSAGE);
                foo=Double.parseDouble(str);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Proszę podać czas trwania!","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
           }
        return str;
    }
    /**
     * Statyczna metoda zwracająca DRM
     * Metoda zwraca prawdę jeśli książka posiada zabezpieczenie w postaci DRM
     * Jeśli nie posiada zabezpieczenia metoda zwraca fałsz
     * @return boolean DRM
     */
    private static boolean DRM(){
       String str;
       String[] choose={"Tak","Nie"};
       while(true){
                try{
                 str =(String)JOptionPane.showInputDialog(null,"Czy książka posiada zabezpieczenie DRM?","Książka cyfrowa",
                 JOptionPane.QUESTION_MESSAGE,null,choose,0);
                break;
                }catch(NumberFormatException n){JOptionPane.showMessageDialog(null,
                        "Błąd","Błąd", JOptionPane.INFORMATION_MESSAGE);
                }
       }
       if(str=="Tak") return true;
       return false;
    }
}

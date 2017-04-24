package client.programowanie.sieciowe;

import javax.swing.JOptionPane;

public class GenerateBook {
    
    public static String GenerateClassicBook(){
        String classic="ISBN:"+ISBNstring()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+valueString()+"zł Liczba stron:"+pageCountString()+" Waga:"+
                weightString()+"kg Oprawa:"+binding();
        return classic;
    }

    public static String GenerateEbook(){
        String ebook="ISBN:"+ISBNstring()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+valueString()+"zł Rozmiar:"+sizeString()+" DRM:"+DRM()+
                " Jakość:"+quality()+" Format:"+format();
        return ebook;
    }

    public static String GenerateAudioBook(){
        String audio="ISBN:"+ISBNstring()+" Tytuł:"+title()+" Autor:"+author()+" Wydawca:"+
                publisher()+" Cena:"+valueString()+"zł Rozmiar:"+sizeString()+" DRM:"+DRM()+
                " Jakość:"+quality()+" Format:"+format()+" Czas trwania:"+durationString()+"h";
        return audio;
    }
 
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

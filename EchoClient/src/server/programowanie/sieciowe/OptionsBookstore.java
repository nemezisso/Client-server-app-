package server.programowanie.sieciowe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa wykonująca operacje i polecenia od klienta
 * @author Bartek
 */
public class OptionsBookstore {
        ArrayList<ClassicBook> classic=new ArrayList();
        ArrayList<Ebook> ebook=new ArrayList();
        ArrayList<AudioBook> audio=new ArrayList();
    /**
     * Metoda load zwraca ArrayList<Book>
     * Wczytuje dane z pliku txt
     * Inicjuje i uzupełnia listy: classic, ebook, audio
     * 
     * @return 
     */
    public ArrayList<Book> load(){
        ArrayList<Book> bookshop=new ArrayList();
       
        File file= new File("ksiegarnia.txt");
        Scanner in=null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OptionsBookstore.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(in.hasNextLine()){
            String str;
            str=in.nextLine();
            int count=OptionsBookstore.check(str);

          switch(count){
              case 1:
                    bookshop.add(OptionsBookstore.loadClassicBook(str));
                    classic.add(OptionsBookstore.loadClassicBook(str));
                    break;
              case 2:
                    bookshop.add(OptionsBookstore.loadAudioBook(str));
                    audio.add(OptionsBookstore.loadAudioBook(str));
                    break;
              case 3:
                    bookshop.add(OptionsBookstore.loadEbook(str));
                    ebook.add(OptionsBookstore.loadEbook(str));
                    break;
              default:
                 System.out.println("LOADING");
                  break;           
          }
          

        }
            in.close();
            file.exists();
            return bookshop;
    }
    /**
     * Klient po wprowadzeniu textu- show: 
     * -all
     * -classic
     * -digital
     * dostaje w odpowiedzi listę obiektów z książkami
     */
    public void showReply(PrintWriter out,String text,ArrayList<Book> bookshop){
        String str="";
        if(text.startsWith("all", 6)){
            for(int i=0;i<bookshop.size();i++)
                str+=(String)bookshop.get(i).toString()+"@";
        out.println(str+"@");
        }
        else if(text.startsWith("classic", 6)){
            for(int j=0;j<classic.size();j++)
                str+=(String)classic.get(j).toString()+"@";
        out.println(str);
        }
        else if(text.startsWith("ebook", 6)){
            for(Object o: ebook)
                str+=o+"@";
        out.println(str);
        }
        else if(text.startsWith("audiobook", 6)){
            for(Object o: audio)
                str+=o+"@";
        out.println(str);
        }
        else if(text.startsWith("digital", 6)){
            for(Object o: ebook)
                str+=o+"@";
            for(Object ob: audio)
                str+=ob+"@";
        out.println(str);
        }
            
        else
        out.println("ERROR!");
    }
    /**
     * Metoda do wyszukiwania ksiązki po numerze ISBN:
     * Książążka zwraca obiekt książki jeśli książka znajduje się w bazie
     * Jeśli książki nie znaleziono w bazie wysyła do klienta odpowiedz o braku książki
     */
    public static boolean searchBooksByISBN(String numberISBN, ArrayList<Book> bookshop,PrintWriter out){
        String regex="ISBN:(.*) Tytuł:";
        numberISBN=numberISBN.substring(13);
        
        for(int i=0;i<bookshop.size();i++){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(bookshop.get(i).toString());
                if(matcher.find()){
                    if(numberISBN.equals(matcher.group(1))){
                        out.println(bookshop.get(i));
                        return true;
                    }
                }               
        }
        out.println("Not found!");
        return false;
    }
    /**
     * Metoda sortowania książki po numerze ISBN
     * Sortuje i wyświetla posortowaną listę wszystkich książek
     * @param bookshop
     * @param out 
     */
    public static void sortByISBN(ArrayList<Book> bookshop,PrintWriter out){
        Collections.sort(bookshop);
            for(Object o:bookshop)
                out.print(o+"@");
            out.println();
    }
    public void addClassicBook(String text) throws FileNotFoundException, IOException{
        String str=loadClassicBook(text).toString();
        classic.add(loadClassicBook(text));
        saveBookInFileTxt(str);
        
    }
    
    public void addEbook(String text) throws IOException{
        String str=loadEbook(text).toString();
        ebook.add(loadEbook(text));
        saveBookInFileTxt(str);
    }
    
    public void addAudioBook(String text) throws IOException{
        String str=loadAudioBook(text).toString();
        audio.add(loadAudioBook(text));
        saveBookInFileTxt(str);
    }
    /**
     * Prywatna metoda dzięki której wczytany tekst z pliku txt zostaje zmieniony na obiekt typu ClassicBook
     */
    private static ClassicBook loadClassicBook(String str){
        String regex="ISBN:(.*) Tytuł:(.*) Autor:(.*) Wydawca:(.*) Cena:(.*)zł Liczba stron:(.*) Waga:(.*)kg Oprawa:(.*)";
        ClassicBook book=null;
        int ISBN=-1,pageCount=-1;
        double value=-1,weight=-1;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        
            if(matcher.find()){
                ISBN=Integer.parseInt(matcher.group(1));
                value=Double.parseDouble(matcher.group(5));
                pageCount=Integer.parseInt(matcher.group(6));
                weight=Double.parseDouble(matcher.group(7));
            }
        return book=new ClassicBook(ISBN,matcher.group(2),matcher.group(3),matcher.group(4),value,pageCount,
                 weight, matcher.group(8));
    }
    /**
     * Prywatna metoda dzięki której wczytany tekst z pliku txt zostaje zmieniony na obiekt typu Ebook
     */
    private static Ebook loadEbook(String str){
        String regex="ISBN:(.*) Tytuł:(.*) Autor:(.*) Wydawca:(.*) Cena:(.*)zł Rozmiar:(.*) DRM:(.*) Jakość:(.*) Format:(.*)";
        int ISBN=-1;
        double value=-1,size=-1;
        boolean DRM=false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
            if(matcher.find()){
                ISBN=Integer.parseInt(matcher.group(1));
                value=Double.parseDouble(matcher.group(5));
                size=Double.parseDouble(matcher.group(6));
                DRM=Boolean.parseBoolean(matcher.group(7));
                
            }
        Ebook book=new Ebook(ISBN,matcher.group(2),matcher.group(3),matcher.group(4), value, size, DRM,
                    matcher.group(8), matcher.group(9));
        return book;
    }
    /**
     * Prywatna metoda dzięki której wczytany tekst z pliku txt zostaje zmieniony na obiekt typu AudioBook
     */
    private static AudioBook loadAudioBook(String str){
        String regex="ISBN:(.*) Tytuł:(.*) Autor:(.*) Wydawca:(.*) Cena:(.*)zł Rozmiar:(.*) DRM:(.*) Jakość:(.*) Format:(.*) Czas trwania:(.*)h";
        AudioBook book=null;
        int ISBN=-1;
        double value=-1,size=-1,duration=-1;
        boolean DRM=false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if(matcher.find()){
                ISBN=Integer.parseInt(matcher.group(1));
                value=Double.parseDouble(matcher.group(5));
                size=Double.parseDouble(matcher.group(6));
                DRM=Boolean.parseBoolean(matcher.group(7));
                duration=Double.parseDouble(matcher.group(10));
                
            }
         
        return book=new AudioBook(ISBN, matcher.group(2),matcher.group(3),matcher.group(4), value, size, DRM,
                    matcher.group(8), matcher.group(9),duration);
        
    }
    /**
     * Metoda statyczna zapisująca string w pliku tekstowym
     * @param text
     * @throws FileNotFoundException 
     */
    private static void saveBookInFileTxt(String text) throws FileNotFoundException, IOException{
        FileWriter file = new FileWriter("ksiegarnia.txt", true);
        BufferedWriter out = new BufferedWriter(file);
        
        out.write("\r\n");
        out.write(text);
        out.close();
        file.close();
 
    }
    /**
     * Prywatna metoda sprawdzająca jakiego typu jest dana książka
     * Jeśli posiada liczbę stron- jest to książka klasyczna
     * Jeśli posiada format i czas trwania jest to AudioBook
     * Jeśli posiada tylko format jest to Ebook
     * Jeśli kryteria nie są spełnione metoda zwraca 0
     */
    private static int check(String str){
        String regexClassic="Liczba stron:(.*)Waga:";
        String regexAudioBook="Format:(.*) Czas trwania:";
        String regexEbook="Format:(.*) ";
        
          Pattern pattern = Pattern.compile(regexClassic);
          Matcher matcher = pattern.matcher(str);
            if(matcher.find())
                return 1;
            else{
              pattern = Pattern.compile(regexAudioBook);
              matcher=pattern.matcher(str);
                  if(matcher.find())
                        return 2;
            }
           
            pattern = Pattern.compile(regexEbook);
            matcher=pattern.matcher(str);
                if(matcher.find())
                    return 3;
            
            return 0;
          
    }
}
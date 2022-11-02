/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template..,.
 */
package trials;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class hangMan {
    static Scanner sc = new Scanner(System.in);
    final static String vocabBox [][] = {
        {"ANIMALS", "DOG", "CAT", "ROOSTER", "TIGER", "LION"},
        {"COUNTRY", "PHILIPPINES", "CANADA", "KOREA", "AMERICA", "RUSSIA"}, 
        {"FOOD", "SINIGANG", "BURGER", "STEAK", "CALAMARE", "ADOBO"}};
    static ArrayList<Character> wordAr = new ArrayList<Character>();
    static int cat = 0;
    static int word = 0;
    static int wrongCount = 0;
   
    static int trials = 5;
    static int wrongAnsCount = 0;
    static ArrayList<Integer> place = new ArrayList<Integer>();
   
    public static void main(String [] man) throws InterruptedException{
        
        welcome();
        //UnderLine String
//        String txt="Welcome Back";
//        String utxt = String.join("\u0332",txt.split("",-1));
//        System.out.println(utxt);
        Thread.sleep(3000);
        wordBox();
        game();
    }
    static void welcome(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠴⣶⡒⠦⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⣠⠖⣩⠶⠛⠉⠉⠳⡀⢱⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⡀⠑⠤⣀⡀⠔⣊⠴⠋⠀⠀⠀⠀⠀⠀⡇⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠈⠛⠷⠴⠒⠊⠁⠀⠀⠀⠀⠀⠀⠀⢠⠃⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣎⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡌⢦⣀⡀⠀⠀⠀⠀⢀⣀⣠⣤⣤⣤⣤⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣦⡤⠶⣛⣯⣿⡦⢴⡶⠦⢦⣤⣉⣙⣶⠦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣽⠿⠛⠉⠀⠀⠈⠉⠀⠀⠀⠀⠀⣤⣚⣛⡏⠀⣈⣼⣦⡉⠳⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠀⠹⣿⡿⠁⠀⣷⣮⡾⠃⠀⠀⠙⢦⣄⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠞⠀⠀⠀⣀⣤⣴⡖⠶⢶⣦⣄⠰⣾⣻⣿⣷⠤⣞⣉⣹⠀⡠⠚⢻⡆⠀⠀⠀⠀⠀⠙⢷⣄⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⡾⠀⠀⢀⣼⢿⣇⠀⠳⡤⠖⡟⣿⣷⡙⠋⠉⠀⠀⠙⠋⠁⠈⠿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⡀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢰⣇⡀⠀⡞⠁⣀⡻⠗⠶⢵⣴⡿⠋⢹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣆⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢸⢸⠀⠀⢳⡸⣷⣦⡾⣧⡀⢈⣦⣀⠞⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡆\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢸⢸⠀⠀⠀⠙⠺⠤⠤⠼⣿⠾⠛⠁⠀⠀⢀⢀⠤⠂⠀⣀⣀⣤⡤⠤⣤⣤⡤⣤⣄⡀⠀⠉⠀⠀⠀⠀⠀⢹\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢸⡄⠀⠀⠀⠀⠀⠀⡀⠀⠉⠀⠀⢀⣠⠖⢛⣠⡴⠞⠛⠉⠁⠀⠀⠀⠀⠈⠉⠒⠦⣟⠿⢶⣤⣤⣀⠀⢀⡟\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡴⠀⣡⡶⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠒⠮⠼⠽⠟⠋⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⡏⣠⡞⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⣀⠀⠀⠀⠀⢀⣶⠏⠀⣴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⢸⡄⢻⣗⣶⡆⢰⡾⠁⢀⡼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠈⢷⡄⠙⠛⠓⠈⠁⣠⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠲⠤⡤⠴⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⣀⠀⠀⠀⢀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀      ⠀MONGI'S THE HANGMAN GAME⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        //System.out.println("""
        //                   ________
        //                   |      O
        //                   |     /|\\
        //                   |     / \\
        //                   |
        //                   --------------""");
    }
    static void wordBox(){
        Random rand = new Random();
        cat = rand.nextInt(2 - 0) + 0;
        System.out.println(vocabBox[cat][0]);
        word = rand.nextInt(4 - 1) + 1;
        //System.out.println(vocabBox[cat][word]);
        int length = vocabBox[cat][word].length();
        int place = 1;
        System.out.println("HINT! (" + length + " letters)");
        for(int i = 0; i < length; i++){
            
            System.out.println(place + "= ");
            place++;
        }
        for(int i = 0; i < length; i++){
        wordAr.add(vocabBox[cat][word].charAt(i));
        }
        //System.out.println(Arrays.toString(wordAr));
    }
    static void game() throws InterruptedException{
        int look = 0;
        
        for(int i = 0; i < wordAr.size(); i++){
            place.add(i);
        }
        Collections.fill(place,wordAr.size()+1);
        
        //System.out.println(place.get(1) + " " + place.size());
        
            boolean cont = true;
            int pos = 0;
            
            while(cont){
                System.out.print("Type your guessed letter: ");
                char let = Character.toUpperCase(sc.next().charAt(0));
                for(int i = 0; i < vocabBox[cat][word].length(); i++){
                    if(!wordAr.contains(let)){
                        System.out.println("Wrong Guess!");
                        wrongAnsCount++;
                        hang();
                        break;
                    }
                    if(let == wordAr.get(pos)) {
                        
                        if(!place.contains(pos)){
                            
                            place.set(i,pos);        
                        }                 
                    }   
                    pos++;
                }
                pos = 0; 
                int pMent = 1;
                for(int i = 0; i < place.size(); i++){
                    if(place.get(i) == wordAr.size()+1){
                            System.out.println(pMent + "= ");                        
                    }
                    else{
                        System.out.println(pMent + "= " + wordAr.get(place.get(i)));
                    }
                    pMent++;
                }
                
                if(!place.contains(wordAr.size()+1)){                    
                    System.out.println("Congrats! You Won and Saved Me! Thank You Nerd ⸜(｡˃ ᵕ ˂ )⸝");
                    break;
                }
                if(wrongAnsCount == 5){
                    System.out.println("Mongi Died... You Lose");
                    Thread.sleep(1000);
                    System.out.println("BOBO AMPUTA");
                   break;
                } 
                //System.out.println(place.size() + " " + wordAr.size());
                }
                
               //System.out.println(wrongAnsCount);
            
        //System.out.println(place);
    }
   static void hang(){
        if(wrongAnsCount == 1){
            System.out.println("""
                           ________
                          """);
        }
        else if(wrongAnsCount == 2){
           System.out.println("""
                           ________
                           |      O
                           """);
        }
        else if(wrongAnsCount == 3){
             System.out.println("""
                           ________
                           |      O
                           |     /|\\
                           """);
        }
        else if(wrongAnsCount == 4){
            System.out.println("""
                           ________
                           |      O
                           |     /|\\
                           |     / \\
                           """);
        }
        else{
            System.out.println("""
                           ________
                           |      O
                           |     /|\\
                           |     / \\
                           |
                           --------------""");
    
        }
    }
}

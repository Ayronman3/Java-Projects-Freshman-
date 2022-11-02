/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

        
package tiktaktoe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author acer
 */
public class Tiktaktoe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        char [][] gBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
        while(true){
        displayGBoard(gBoard);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your Desired Placement: ");
        int place = sc.nextInt();
        
        placement(place, gBoard, "player");
        Random R = new Random();
        int cpuPlace = R.nextInt(9) + 1;
        placement(cpuPlace, gBoard, "cpu");
        displayGBoard(gBoard);
        
        }
        
        

    }
    static void displayGBoard(char[][] gBoard){
    for(char [] l : gBoard)
        {
            for(char c : l)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    static void placement(int place, char [][] gBoard, String user){
         char piece = 'X';
        if(user.equals("player")){
            piece = 'X';
        }
        else if (user.equals("cpu")){
            piece = 'O';
        }
        switch(place)
        {
            case 1:
                gBoard [0][0] = piece;
                break;
            case 2:
                gBoard [0][2] = piece;
                break;
            case 3:
                gBoard [0][4] = piece;
                break;
            case 4:
                gBoard [2][0] = piece;
                break;
            case 5:
                gBoard [2][2] = piece;
                break;
            case 6:
                gBoard [2][4] = piece;
                break;
            case 7:
                gBoard [4][0] = piece;
                break;
            case 8:
                gBoard [4][2] = piece;
                break;
            case 9:
                gBoard [4][4] = piece;
                break;
        }
    }
    public static String filter(){
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List lastRow = Arrays.asList(7, 8, 9);
        List topConl = Arrays.asList(1, 4, 7);
        List midColn = Arrays.asList(2, 5, 8);
        List lastColn = Arrays.asList(3, 6, 9);
        List diagL = Arrays.asList(1, 5, 9);
        List diagR = Arrays.asList(3, 5, 7);
        
        
        return "";
    }
    
    
}

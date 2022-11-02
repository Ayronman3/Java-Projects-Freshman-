/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casestudy1.bakery.cashier;

/**
 *
 * @author acer
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class inventoryAndSales {
    //Global Variables
    static Scanner sc = new Scanner(System.in);
    static Scanner numSc = new Scanner(System.in);
    static int option;
    static boolean loopControl;
    static String products [] = {"Cheese Bread", "Ensaymada", "Ham and Cheese", "Hopia",
            "Monay", "Pan de Coco", "Pandesal", "Spanish Bread", "Putok", "Tasty"};
    static int priceOfProducts [] = {7, 6, 6, 5, 5, 5, 3, 5, 5, 7};
    static int quantity [] = {100,100,100,100,100,100,100,100,100,100};
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException {
        //Displaying the Welcome Page
        welcomePage();
        //Delay for 2 sec
        Thread.sleep(2000);
        //Displaying the Menu
        Menu();
        loopControl = true;
        //All Objects
        newTransaction NewTransaction = new newTransaction();
        stocks Stocks = new stocks();
        report Report = new report();
        while(loopControl){
        option = 0;
        //Displaying the Options
        mainMenu();
        switch(option){
            
            case 1:
                //New Transaction Method
                NewTransaction.main(products, priceOfProducts, quantity);
                System.out.println("Please Wait A Second...");
                Thread.sleep(1000);
                break;
            case 2:
                //Stocls Method
                Stocks.main(products, quantity);
                System.out.println("Please Wait A Second...");
                Thread.sleep(1000);
                break;
            case 3:
                //Report Method
                Report.main(quantity);
                System.out.println("Please Wait A Second...");
                Thread.sleep(1000);
                break;
            case 4:
                //Exit Method
                exit();
                break;
            default:   
                System.out.println("Attention! Please Enter Valid Number!");
                break;
        }
        }
        
    }
    static void welcomePage(){
        System.out.println("°•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━••");
        System.out.println("=┃                 @           @  @ @ @   @      @ @ @     @ @ @    @     @  @ @ @                 ┃=");
        System.out.println("=┃                  @         @   @       @     @        @       @  @ @ @ @  @                     ┃=");
        System.out.println("=┃                   @   @   @    @ @     @     @        @       @  @  @  @  @ @                   ┃=");
        System.out.println("=┃                    @ @ @ @     @       @     @        @       @  @     @  @                     ┃=");
        System.out.println("=┃                     @   @      @ @ @   @ @ @  @ @ @     @ @ @    @     @  @ @ @                 ┃=");
        System.out.println("=┃                                                                                                 ┃=");
        System.out.println("=┃                                        @ @ @ @ @    @ @ @                                       ┃=");
        System.out.println("=┃                                            @       @     @                                      ┃=");
        System.out.println("=┃                                            @       @     @                                      ┃=");
        System.out.println("=┃                                            @        @ @ @                                       ┃=");
        System.out.println("=┃                                                                                                 ┃=");
        System.out.println("=┃                 @     @ @     @ @       @ @        @      @   @  @ @ @   @ @  @   @             ┃=");
        System.out.println("=┃                @ @    @   @  @          @   @     @ @     @  @   @      @  @   @ @              ┃=");
        System.out.println("=┃               @   @   @@@    @          @@@      @   @    @@     @ @    @@      @               ┃=");
        System.out.println("=┃              @  @  @  @   @  @          @   @   @  @  @   @  @   @      @ @     @               ┃=");
        System.out.println("=┃             @       @ @  @    @ @       @ @    @       @  @    @ @ @ @  @  @    @               ┃=");
        System.out.println("°•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━••");
        }
    static void Menu(){
        System.out.println("°•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━••");
        System.out.println("=┃                                              MENU                                               ┃=");
        System.out.println("=┃                                                                                                 ┃=");
        System.out.println("=┃         Products                             Price                               Stocks         ┃=");
        System.out.println("=┃                                                                                                 ┃=");
        System.out.println("=┃         [1].Cheese Bread                       7                                  100           ┃=");
        System.out.println("=┃         [2].Ensaymada                          6                                  100           ┃=");
        System.out.println("=┃         [3],Ham and Che                        6                                  100           ┃=");
        System.out.println("=┃         [4].Hopia                              5                                  100           ┃=");
        System.out.println("=┃         [5].Monay                              5                                  100           ┃=");
        System.out.println("=┃         [6].Pan de Coco                        5                                  100           ┃=");
        System.out.println("=┃         [7].Pandesal                           3                                  100           ┃=");
        System.out.println("=┃         [8]. Spanish Bread                     5                                  100           ┃=");
        System.out.println("=┃         [9].Putok                              5                                  100           ┃=");
        System.out.println("=┃         [10].Tasty                             7                                  100           ┃=");
        System.out.println("°•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━••");
        
    }
    static void mainMenu(){
    System.out.println("°•━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━•°");
    System.out.println("=┃                Menu:            ┃=");
    System.out.println("=┃   [1] New transaction           ┃=");
    System.out.println("=┃   [2] Stocks                    ┃=");
    System.out.println("=┃   [3] Report                    ┃=");
    System.out.println("=┃   [4] Exit                      ┃=");
    System.out.println("°•━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━•°");
    System.out.print("\nPlease Enter Your Option: ");
    option = numSc.nextInt();
    }
    
    static void exit(){
        System.out.println("Thank you for trusting ABC Bakery! Hope to see you again!- ABC Bakery Management");
        System.out.println("Program Terminated");
        loopControl = false;
        
    }
    
}

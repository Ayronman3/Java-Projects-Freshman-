/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casestudy1.bakery.cashier;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class stocks {
    public Scanner sc =  new Scanner(System.in);
    public Scanner numSc = new Scanner(System.in);
    static final int max = 100;
    static final int min = 15;
    public void main(String products[], int quantity[]){
        //Convertng the quantity array to String array
        String a [] = new String[quantity.length];
        for(int i = 0; i < quantity.length; i++){
            //Checking the Number of characters To adjust the spacing
            if(String.valueOf(quantity[i]).length() <3 && String.valueOf(quantity[i]).length() > 1 ){
                a[i] = String.valueOf(quantity[i]) + " ";
            }
            else if(String.valueOf(quantity[i]).length() <2){
                 a[i] = String.valueOf(quantity[i]) + "  ";
            }
            else{
                a[i] = String.valueOf(quantity[i]);
            }
        }
        // Display Items and Quantity
        int arrange = 1;
      
        System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
        System.out.println("┃                     STOCKS                   ┃");
        System.out.println("┃                                              ┃");
        System.out.println("┃  Products                            Stocks  ┃");
        System.out.println("┃                                              ┃");
        System.out.println("┃  [1].Cheese Bread                     "+a[0]+"    ┃");
        System.out.println("┃  [2].Ensaymada                        "+a[1]+"    ┃");
        System.out.println("┃  [3],Ham and Cheese                   "+a[2]+"    ┃");
        System.out.println("┃  [4].Hopia                            "+a[3]+"    ┃");
        System.out.println("┃  [5].Monay                            "+a[4]+"    ┃");
        System.out.println("┃  [6].Pan de Coco                      "+a[5]+"    ┃");
        System.out.println("┃  [7].Pandesal                         "+a[6]+"    ┃");
        System.out.println("┃  [8].Spanish Bread                    "+a[7]+"    ┃");
        System.out.println("┃  [9].Putok                            "+a[8]+"    ┃");
        System.out.println("┃  [10].Tasty                           "+a[9]+"    ┃");
        System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
    

            // If-statement to alert user whenever item(s) stock is less than 15
            for (int i = 0; i<quantity.length; i++){
                if (quantity[i] <= min){
                System.out.println("\n");
                System.out.println(" [ RECOMMENDED: ]  A certain product(s) is/are low in stock, please restock.");
                i = 11;
            }}

            // Ask if user wants to Add stocks or No
            System.out.println("\n");
            System.out.print("Do You Want To Add Stocks? [1] Yes, [2] No: ");
            int stock = numSc.nextInt();
            
            // If yes, ask user to enter the Item Number of the Item to add stocks
            if (stock == 1) {
                System.out.println("\nItem Number: ");
                    int item = numSc.nextInt();
                        
                        // If user inputted a wrong number, refresh
                        while (item > products.length){
                            System.out.println("\nIncorrect item, please input another item");
                                System.out.println("\nItem Number: ");
                                item = numSc.nextInt();
                        }
                                       
                // Inform what item the user chose then ask user to input how much to add
                System.out.println("\nYou have chosen: " +products[item-1]);
                System.out.println("Quantity: ");
                int quant = numSc.nextInt();
                        
                        // Formula to add user-inputted Quantity to Quant Array
                        quantity[item-1] = quantity[item-1] + quant;
                            
                            // Inform If user inputted quantity which sum is more than "max" 
                            if (quantity[item-1] > max){
                            System.out.println("\nMax stock is 100. Please enter another number");
                            
                            // Immediately deduct user input
                            quantity[item-1] = quantity[item-1] - quant;
                        } else {
                            
                            // Inform user of successful input
                            System.out.println("\n" +quant +" Stock(s) has been added to " +products[item-1]);
                        }    
                        
                            // Refresh Display
                            main(products, quantity);
                        
            // If no, prompt user to go back to main menu            
            } else if (stock == 2) {
                System.out.println("\nPress any key to go to the Menu");
                sc.nextLine();

                        // If user inputted anything else, refresh
                        } else {
                            main(products,quantity);
                            }
                        }
    }

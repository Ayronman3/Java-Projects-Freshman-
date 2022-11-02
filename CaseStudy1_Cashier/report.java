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
public class report {
    public Scanner sc = new Scanner(System.in);
   public void main(int quantity[]){
       //Converting the quantity array to String array
       String b [] = new String[quantity.length];
        for(int i = 0; i < quantity.length; i++){
            //Checking the Length to adjust the spacing
            if(String.valueOf(quantity[i]).length() <3 && String.valueOf(quantity[i]).length() > 1 ){
                b[i] = String.valueOf(quantity[i]) + " ";
            }
            else if(String.valueOf(quantity[i]).length() <2){
                 b[i] = String.valueOf(quantity[i]) + "  ";
            }
            else{
                b[i] = String.valueOf(quantity[i]);
            }
        }
        // Display Items and Quantity
        System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
        System.out.println("┃                     REPORT                   ┃");
        System.out.println("┃                                              ┃");
        System.out.println("┃  Products                            Stocks  ┃");
        System.out.println("┃                                              ┃");
        System.out.println("┃  [1].Cheese Bread                     "+b[0]+"    ┃");
        System.out.println("┃  [2].Ensaymada                        "+b[1]+"    ┃");
        System.out.println("┃  [3],Ham and Che                      "+b[2]+"    ┃");
        System.out.println("┃  [4].Hopia                            "+b[3]+"    ┃");
        System.out.println("┃  [5].Monay                            "+b[4]+"    ┃");
        System.out.println("┃  [6].Pan de Coco                      "+b[5]+"    ┃");
        System.out.println("┃  [7].Pandesal                         "+b[6]+"    ┃");
        System.out.println("┃  [8].Putok                            "+b[8]+"    ┃");
        System.out.println("┃  [9].Spanish Bread                    "+b[7]+"    ┃");
        System.out.println("┃  [10].Tasty                           "+b[9]+"    ┃");
        System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
        
        System.out.println("Press any key and Enter to return to Main Menu..");
        sc.nextLine();
   }
}

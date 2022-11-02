/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casestudy1.bakery.cashier;

/**
 *
 * @author acer
 */
import java.util.ArrayList;
import java.util.Scanner;
public class newTransaction {
    static Scanner sc =  new Scanner(System.in);
    static Scanner numSc = new Scanner(System.in);
    
    public void main(String products[], int priceOfProducts[], int quantity[]){
        
        int count;
        int itemNum = 0;
        int item = 0;
        int itemQuant = 0;
        int productIndex = 0;
        double cashAmount;
        boolean control = true;
        boolean control2;
        boolean control3;
        boolean control4;
        boolean askName = true;
        String customerName = null;
        double subTotals [];
        //Declaring ArrayList of objects
        ArrayList list = new ArrayList();     
        ArrayList <String> receipt  = new ArrayList <>(); 
        while(control){
            // Loop COntrol Variables
            count = 1;
            control2 = true;
            control3 = true;
            control4 = true;
            int ans = 0;
            // Display products
            System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━•");
            System.out.println("┃                      MENU                    ┃");
            System.out.println("┃                                              ┃");
            System.out.println("┃  Products                             Price  ┃");
            System.out.println("┃                                              ┃");
            System.out.println("┃  [1].Cheese Bread                       7    ┃");
            System.out.println("┃  [2].Ensaymada                          6    ┃");
            System.out.println("┃  [3].Ham and Cheese                     6    ┃");
            System.out.println("┃  [4].Hopia                              5    ┃");
            System.out.println("┃  [5].Monay                              5    ┃");
            System.out.println("┃  [6].Pan de Coco                        5    ┃");
            System.out.println("┃  [7].Pandesal                           3    ┃");
            System.out.println("┃  [8].Spanish Bread                      5    ┃");
            System.out.println("┃  [9].Putok                              5    ┃");
            System.out.println("┃  [10].Tasty                             7    ┃");
            System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━━༺༻━━━━━━━━━━━━━━━━━━━━━━━━━━•");
            //Ask Customer's Name
            if(askName){
            System.out.print("Please Enter Customer's Name:");
            customerName = sc.nextLine();
            askName = false;
            }
            //Entering Items
            while(control2){
                System.out.print("Please Enter Item: ");
                itemNum = numSc.nextInt();
                if((itemNum - 1) > 10){
                    System.out.println("ATTENTION!! You Have Entered Wrong Item Number. Please Try Again..");
                }
                // Item is not available
                else if(quantity[itemNum-1] == 0){
                    System.out.println("Sorry. " + products[itemNum-1] + " is currently not available.");
                    System.out.print("Do you still wish to continue? [1] Yes, [2] No: ");
                    int cont = numSc.nextInt();
                    int ext = 1;
                    while(ext == 1){
                        // Just get the remaining quantity
                        if(cont ==1){
                            ext = 2;
                            control = true;

                        }
                        //end the method to return to main menu
                        else if(cont == 2){
                            System.out.println("Press any key and Enter to retrun to Main Menu");
                            sc.nextLine();
                            return;
                        }
                        else{
                            System.out.println("Please Enter Valid Number!");
                            ext = 1;
                        }
                    }
                    
                }
                // Item is available
                else{
                //Getting Index of Item Picked
                    while(control3){
                        item = itemNum -1;
                        System.out.print("Please Enter Quantity: ");
                        itemQuant = numSc.nextInt();
                        //item stock is insufficient
                        if(itemQuant > quantity[item]){
                            System.out.println("Warning!Stocks Insufficient!");
                            System.out.println("We now currently have " + quantity[item] + " " + products[item] + " available.");
                            while(control4){
                                System.out.print("Do you still wish to continue?[1] Yes, [2] NO: ");
                                ans = numSc.nextInt();
                                // Customer gets the remaining stocks
                                //Exiting loop
                                if(ans == 1){
                                    itemQuant = quantity[item];
                                    control4 = false;
                                    control3 = false;
                                    control2 = false;
                                    control = false;  
                                }
                                // Customer looks for another item to order
                                else if(ans == 2){
                                    control4 = false;
                                    control3 =false;
                                    control2 = false;
                                    //Making item quantity that the user entered 0 to return to Menu
                                    itemQuant  = 0;
                                }
                                else{
                                System.out.println("Please Enter Valid Number!");
                                control4 = true;
                                }
                            }
                        }
                        //item has sufficient stock
                        else{
                            control3 = false;
                            control2 = false;
                        }
                    }
                }
            }
            //Checking if quantity has value
            if(itemQuant  != 0){
                //Getting Subtotal
                double subtotal = itemQuant*priceOfProducts[item];
                // Updating the stocks
                quantity[item] = quantity[item] - itemQuant;
                //Adding items to ArrayList
                list.add(products[item]);
                list.add(item);
                list.add(priceOfProducts[item]);
                list.add(itemQuant);
                list.add(subtotal);

                //Asking if user wants to Void answer
                System.out.print("Do you want to void an order?[1] Yes, [2] No: ");
                int Void = numSc.nextInt();
                if(Void == 1){
                    //Removing item
                    System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
                    System.out.println("Items in Shopping Cart:\n");
                    int countr = 1;
                    for(int i = 0; i < list.size(); i+=5){
                    System.out.println("["+countr+"]" + list.get(i) + "\t\t" + list.get(i+2) + "*" +
                        list.get(i+3));
                    countr++;
                    }
                    
                    System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
                    
                    System.out.println("Which Item Do You Want To Be Reomoved? (Please Enter the NUMBER of the Product)");
                    int productVoid = numSc.nextInt();
                    int getNext = 5;
                    int current = 0;
                    
                    for(int j = 0; j < productVoid; j++ ){
                        
                        if(j+1 == productVoid){
                            j = productVoid-1;
                        }
                        else{
                            current += getNext;
                        }
                    }
                    
                    // Getting the index of Voided Item to the list and get the index of its quantity
                    String voidProduct = String.valueOf(list.get(current));
                    int voidedItem = 0;
                    productIndex = list.indexOf(voidProduct);
                    voidedItem = Integer.valueOf(list.get(productIndex + 1).toString());
                    //Updating the stocks
                    quantity[voidedItem] = quantity[voidedItem] +  Integer.valueOf(list.get(productIndex+3).toString());    
                    System.out.println(String.valueOf(list.get(current)) + " has been removed from your orders");
                    list.subList(current, current+5).clear();
                }
                //Adding Orders
                System.out.print("Do You Want To Add Order? [1] Yes, [2] No: ");
                int addOrder = numSc.nextInt();
                if(addOrder == 1){
                    askName = false;
                }
                //Ending the loop
                else{
                    control = false;
                }
            }
            // When item quantity is 0, it will enter the main loop again
            else{
                control = true;
            }
           
            
            
        }
        //Asking for payment
        double change = 0;
        double sum = 0;
        subTotals = new double[list.size()/5];
        int counter = 4;
        //Converting subtotal objects to double
        for(int j = 0; j < list.size()/5; j++){
            subTotals [j] = Double.valueOf(list.get(counter).toString());
            counter+=5;
        }
        //Getting the total
        for(int i = 0; i < subTotals.length; i++){
            sum+=subTotals[i];
        }
        System.out.println("Total Amount To Pay: " + sum);
        boolean exctMon = true;
        cashAmount = 0;
        //Checking if Money Entered is Sufficient
        while(exctMon){
            System.out.println("Please Enter Cash Amount: ");
            cashAmount = numSc.nextDouble();
            if(cashAmount >= sum){
                exctMon = false;
            }
            else{
                System.out.println("Warning!! Cash Amount Entered is Insufficient!");
            }
        }
        System.out.println("Recieved Amount: " + cashAmount);
        //Getting the change
        change = cashAmount - sum;
        int getQuant = 2;
        int getPrice = 3;
        int getSubTotal = 4;
        //Displaying The Order Summary/Receipt

        for(int j = 0; j < list.size(); j++){
            if(String.valueOf(list.get(j)).length() > 4 && String.valueOf(list.get(j)).length() <= 6){
            receipt.add(String.valueOf(list.get(j)) + "       ");
            }
            else{
                receipt.add(String.valueOf(list.get(j)).trim());
            }
        }
        System.out.println();
        System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
        System.out.println("\n\t\t    ABC BAKERY");
        System.out.println("\nOrder Summary");
        System.out.println("\nName of Customer: " + customerName);
        System.out.println();
        System.out.println("ITEMS   \t      QUANTITY\t         PRICE");
        for(int i = 0; i < receipt.size(); i+=5){
            System.out.println(receipt.get(i) + "\t\t" + receipt.get(i+getQuant) + "*" +
                    receipt.get(i+getPrice) + "\t\t" + "Php " + receipt.get(i+getSubTotal));
           
        }
        System.out.println("**************************************************");
        System.out.println("Total: " + "\t\t\t\t\tPhp " + sum);
        System.out.println("Cash: " + "\t\t\t\t\tPhp " + cashAmount);
        System.out.println("Change:" + "\t\t\t\t\tPhp " + change);
        System.out.println("==================================================");
        System.out.println("       Thank you for choosing ABC Bakery!");
        System.out.println("•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•");
        
        
        System.out.println("\nPress Any Key and Enter to return to Main Menu ");
        sc.nextLine();
    }
    
    
    
    
}

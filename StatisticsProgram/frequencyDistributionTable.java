/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trials;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author acer
 */
/**
 * TO DO LIST
 * GET INPUTS SA USER
 * LAGAY SA LOOB NG ARRAY
 * COUNT ALL INPUTS
 * SORT THE ARRAY
 * GET LOWEST AND HIGHEST
 * GET THE RANGE
 * GET THE CLASS WIDTH
 * CREATE CLASSES
 * COMPARE LAHAT NG INPUTS NI USER SA EVERY ELEMENT SA CLASSES
 * COUNT YUNG PUMASOK SA RANGE NG CLASS FOR THE TALLY AND FREQUENCY (THE SAME LANG)
 * GET THE SUM OF ALL FREQUENCIES
 * CREATE THE CUMMULATIVE FREQUENCIES
 * CREATE THE RELATIVE FREQUENCIES
 * GET THE SUM OF ALL RF
 * CREATE THE MIDPOINTS
 * CREATE THE CLASS BOUNDARIES
 * DISPLAY SA TABLE
*/
public class frequencyDistributionTable {
    static Scanner sc = new Scanner(System.in);
    static Scanner word = new Scanner(System.in);
    public static void main(String []args) throws InterruptedException{
        
        double dataSet[];
        double lClass[];
        double hClass[];
        int frequency [];
        int cF [];
        double RF[];
        float midPoints[];
        double cBoundaries[][];
        String uInputs[];
        double Range = 0;
        double cWidth = 0;
        
        System.out.println("___________________________________________________________________________________________________________________________________________________________");
        while(true){
          
            //Getting and Sorting the Data
            System.out.println("Enter your data set. Pleae Include a comma (,) every numbers..");
            System.out.print("Please Enter Data Set: ");
            String inputs = word.nextLine();
            System.out.print("Please Enter The Number of Classes To Be Used (i): ");
            int numC = sc.nextInt();

            uInputs = inputs.split(",", 0);
            
            dataSet = new double[uInputs.length];
            for(int a = 0; a < uInputs.length; a++){
                
                dataSet [a] = Double.parseDouble(uInputs[a]);
            }
            System.out.println("Here Are The Data: " + Arrays.toString(dataSet));
            Arrays.sort(dataSet);
            System.out.println(Arrays.toString(dataSet));
            System.out.println("********************************************************************************************");
            //Displaying the Lowest and Highest Data
            System.out.println("Lowest Data: " + dataSet[0]);
            System.out.println("Highest Data: " + dataSet[dataSet.length-1]);
           //Geeting and Displaying the Range
            Range =dataSet[dataSet.length-1] - dataSet[0];
            
            System.out.println("Range: " + Range);
            //Getting and Displaying the Class Width
            double numCS = numC;
            cWidth = (int)Math.ceil(Range/numCS);
            System.out.println("Class Width: " + cWidth);
            int cCounter = 1;
            double counter = dataSet[0]; 
            int last = dataSet.length - 1;

            while(counter < dataSet[last]){
                counter = counter + cWidth;
                if(counter <= dataSet[last]){
                    cCounter++;
                }
            }
            
            //Creating and Displaying the Classes

            lClass = new double [cCounter];
            lClass[0]= dataSet[0];
            hClass = new double [cCounter];
            for(int c = 1; c < lClass.length; c++){
                lClass [c] = lClass[c-1] + cWidth;
            }
            for(int d = 0; d < hClass.length; d++){
                hClass[d] = lClass[d] + (cWidth - 1);
            }
            System.out.println("********************************************************************************************");
            System.out.println("Classes: ");
            for(int k = 0; k < lClass.length; k++){
                System.out.println(lClass[k] + "-" + hClass[k]);
            }

            System.out.println("********************************************************************************************");
            //Creating and Displaying the Frequencies
            int limit = 0;
            frequency = new int[lClass.length];
            while(limit < lClass.length){
                int tally = 0;
                for(int d = 0; d < dataSet.length; d++){
                    if(dataSet[d] >= lClass[limit] && dataSet[d] <= hClass[limit]){
                        tally++;
                    }

                }
                frequency[limit] = tally;
                limit++;
            } 
            
            System.out.println("Frequency:");
            for(int l = 0; l < frequency.length; l++){
                System.out.println(frequency[l]);
            }
            System.out.println("********************************************************************************************");
            //Creating the Cummulative Frequencies
            cF = new int[lClass.length];
            int sumF = 0; 

            for(int e = 0; e < frequency.length; e++){
               sumF += frequency[e];
               cF[e] = sumF;
            }
            System.out.println("Summation of f/n: " + sumF);
            System.out.println("********************************************************************************************");
            //Displaying The Cummulative Frequencies
            System.out.println("CF:");
            for(int m = 0; m<cF.length; m++){
                System.out.println(cF[m]);
            }
            System.out.println("********************************************************************************************");
            //Getting and Displaying the Relative Frequencies
            double rF = 0;
            double rRf = 0;
            int dLength = dataSet.length;
            RF = new double[frequency.length];
            for(int f = 0; f < frequency.length; f++){
                rF = (double)frequency[f]/ dLength;
                rRf = Math.round(rF*100.0)/100.0;
                RF[f] = rRf;
            }
            System.out.println("RF: ");
            for(int n = 0; n <RF.length; n++){
                System.out.println(RF[n]);
            }

            //Summation of RF
            double sumRf = 0;
            for(int g = 0; g < RF.length; g++){
                sumRf = Double.sum(sumRf, RF[g]);
            }
            System.out.println("Summation of RF: " + Math.round(sumRf));
            System.out.println("********************************************************************************************");
            midPoints = new float[lClass.length];
            float mPoints = 0;
            for(int h = 0; h < midPoints.length; h++){
                mPoints = (float)(lClass[h]+hClass[h]) / 2;
                midPoints[h] = mPoints;
            }

            //Display The Midpoints
            System.out.println("MidPoints(x): ");
            for(float o : midPoints){
                System.out.println(o);
            }
            System.out.println("********************************************************************************************");
            //Creating the Class Boundaries
            cBoundaries = new double[lClass.length][2];
            for(int i = 0; i < cBoundaries.length; i++){

                for(int j = 0; j < cBoundaries[i].length-1; j++){
                cBoundaries[i][j] = (double)lClass[i] - 0.5;    
                cBoundaries[i][j+1] = (double)hClass[i] + 0.5;
                }

            }
            //Printing the Class Boundaries
            System.out.println("Class Boundaries:");
            for(int p = 0; p < cBoundaries.length; p++){
                for(int q = 0; q < cBoundaries[p].length-1; q++){
                    System.out.println(cBoundaries[p][q] + "-" + cBoundaries[p][1]);
                }
            }
            //Displaying Results in Table Form hehe
            System.out.println("***************************************************************************************************************************");

            System.out.println("CLASSES\t\tTALLY\t\tf\t\tCF\t\tRF\t\tX\t\tCLASS BOUNDARIES");
            int bound = 1;
            String lClassVal [] = new String [hClass.length];
            for(int s = 0; s < lClassVal.length; s++){
                lClassVal[s] = String.valueOf(hClass[s]);
            }
            //Fixing The Postions ef Elements in the Table
            boolean isManyChar = false;
            for(int r = 0;  r < lClass.length; r++){
                
                if(lClassVal[r].length() >=4){
                    isManyChar = true;
                }
                
                if(isManyChar){
                    System.out.println(lClass[r] + "-" + hClass[r] + "\t" + frequency[r] + "\t\t" + frequency[r] + "\t\t" + cF[r] + 
                                "\t\t" + RF[r] + "\t\t" +  midPoints[r] + "\t\t" + cBoundaries[r][0] + "-" + cBoundaries[r][bound]);
                    }
                else{
                    System.out.println(lClass[r] + "-" + hClass[r] + "\t\t" + frequency[r] + "\t\t" + frequency[r] + "\t\t" + cF[r] + 
                                "\t\t" + RF[r] + "\t\t" +  midPoints[r] + "\t\t" + cBoundaries[r][0] + "-" + cBoundaries[r][bound]);
                    }
            }
            System.out.println("       \t\t     \t\t______\t\t  \t\t_______");
            System.out.println("       \t\t     \t\tΣf/n:" + sumF + "\t\t  \t\tRF:" + sumRf);
            System.out.println("***************************************************************************************************************************");

            System.out.println("___________________________________________________________________________________________________________________________________________________________");
            
            //Prompting The User To Use the Program Again
            System.out.println("Would You Like To Use This Program Again?[Y/N]");
            String choose = word.nextLine();
            
            if(choose.equalsIgnoreCase("Y")){
                System.out.println("Great! Please Just Wait For A Sec...");
                Thread.sleep(4000);
            }
            else{
                System.out.println("Thank You For Uing This Program!");
                break;
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class SkewnessShit {
    public static void main(String[] skew){
        int choice;
        int useAgain;
        double mean;
        double median;
        double sampStd;
        double popStd;
        double skewness = 0;
        double range;
        String inputs;
        String uInputs[];
        double dataSet[];
        Scanner sc = new Scanner(System.in);
        Scanner strSc = new Scanner(System.in);
        System.out.println("___________________________________________________________________________________________________________________________________________________________");
        while(true){
            try{
                System.out.println("Please Choose An Option:\n[1]. Sample Data\n[2]. Population Data");
                System.out.print("Enter Your Choice Here: ");
                choice = sc.nextInt();
                System.out.println("********************************************************************************************");
            }
            catch(Exception e){
                System.out.println("Please Enter 1 or 2 only. Bobo amp...");    
                System.out.println("Please Choose An Option:\n[1]. Sample Data\n[2]. Population Data");
                System.out.print("Enter Your Choice Here: ");
                sc.next();//to re-enter choice
                choice = sc.nextInt();
                System.out.println("********************************************************************************************");
            }
            System.out.println("Enter your data set. Pleae Include a comma (,) every numbers..");
            System.out.print("Please Enter Data Set: ");
            inputs = strSc.nextLine();
            System.out.println("********************************************************************************************");
            //putting dataset into string array
            uInputs = inputs.split(",", 0);
            //parsing dataset into double and putting them inside an array...
            dataSet = new double[uInputs.length];
            for(int a = 0; a < uInputs.length; a++){
                dataSet [a] = Double.parseDouble(uInputs[a]);
            }
            Arrays.sort(dataSet);
            System.out.println("Your data set is: " + Arrays.toString(dataSet));
            mean = Math.round((sum(dataSet)/dataSet.length)*100.0)/100.0;
            median = getMedian(dataSet);
            ungroupedDataMode(dataSet);
            range = dataSet[dataSet.length-1] - dataSet[0];
            System.out.println("********************************************************************************************");
            if(choice == 1){
                sampStd =getStdSamp(dataSet,mean);
                skewness = getSampSkew(mean,median,sampStd);
                System.out.println("Mean: " + mean + "\nMedian: " + median + "\nRange: " + range + "\nStandard Deviation: " + sampStd);
                status(skewness);
            }
            else{
                popStd = getPopStd(dataSet,mean);
                skewness = getPopSkew(mean,median,popStd);
                System.out.println("Mean: " + mean + "\nMedian: " + median + "\nRange: " + range +"\nStandard Deviation: " + popStd);
                status(skewness);
            }
            System.out.println("********************************************************************************************");
            try{
                System.out.println("Do you wish to continue maderpaker? [1]Yes [2]No");
                useAgain = sc.nextInt();
                System.out.println("********************************************************************************************");

            }
            catch(Exception e){
                System.out.println("Please Enter 1 or 2 only. Bobo amp...");
                System.out.println("Do you wish to continue maderpaker? [1]Yes [2]No");
                sc.next();// To re-enter answer again.... 
                useAgain = sc.nextInt();
                System.out.println("********************************************************************************************");
            }
            if(useAgain != 1){
                System.out.println("___________________________________________________________________________________________________________________________________________________________");
                    break;
                }
        }
    }
    private static double sum(double arr[]){
        double sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }
    private static double getMedian(double arr[]){
        double median;
        if(arr.length%2 == 0){
                median = (arr[(arr.length/2)-1] + arr[arr.length/2])/2;
            }
            else{
                median = arr[arr.length/2];
            }
        return median;
    }
    private static double getStdSamp(double arr[], double mean){
        double sumData = 0;
        double sampStd;
        for(int i = 0; i < arr.length; i++){
            sumData = sumData + Math.pow(((arr[i] - mean)), 2);
        }
        sampStd = Math.round(Math.sqrt(sumData/(arr.length-1))*100.0)/100.0;
        return sampStd;
    }
    private static double getPopStd(double arr[], double mean){
        double sumData = 0;
        double popStd;
        for(int i = 0; i < arr.length; i++){
            sumData = sumData + Math.pow(((arr[i] - mean)), 2);
        }
        popStd = Math.round(Math.sqrt(sumData/(arr.length))*100.0)/100.0;
        return popStd;
    }
    private static double getSampSkew(double mean, double median, double sampStd){
        double skew = Math.round((((3*(mean - median))/sampStd)*100.0))/100.0;
        return skew;
    }
    private static double getPopSkew(double mean, double median, double sampStd){
        double skew = Math.round((((3*(mean -median))/sampStd)*100.0))/100.0;
        return skew;
    }
    private static void status(double skewness){
        if(skewness <0){
            System.out.println("Skewness: " + skewness + "\nTherefore, it is Negatively Skewed");
        }
        else if(skewness > 0){
            System.out.println("Skewness: " + skewness + "\nTherefore, it is Positively Skewed");
        }
        else{
            System.out.println("Skewness: " + skewness + "\nTherefore, it is Normally Skewed");
        }
    }
    static void ungroupedDataMode(double finalData[]){
        int count = 1;
        int max_count = 0;
        double val = 0;
        int j = 0;
        int max_value;
       //Initializing ArrayLists for the frequencies and Elements
       ArrayList<Integer> frequency = new ArrayList<>();
       ArrayList<Double> elements = new ArrayList<>();
       ArrayList<Integer> index = new ArrayList<>();
      
        for(int i = 1; i < finalData.length; i++){
            //Checking the Equivalency of The Two Consecutive Elements 
            if (finalData[i] == finalData[j] ) {
                count++;
            } 
            if(finalData[i] != finalData[j] || i == finalData.length-1) {
                if (count > max_count) {
                    max_count = count;
                    val = finalData[j];
                    frequency.add(max_count);
                    elements.add(val);
                }
                //Reset The Count  
                max_count = 0;
                count = 1;
            }
            j++;
        }
        max_value = Collections.max(frequency);
        for(int i = 0; i < frequency.size(); i++){
            if(frequency.get(i) == max_value){
                index.add(i);
            }
        }
        if(index.size()>1 && Collections.max(frequency) !=1){
            System.out.println("These Data Set is MultiModal!");
            System.out.println("The  Modes are the Following: ");
            for(int d =0; d < index.size(); d++){  
                if(elements.get(index.get(d)) % 1 == 0){
                    System.out.println("\t" + elements.get(index.get(d)).intValue() + ": " + frequency.get(index.get(d)));
                }
                else{
                    System.out.println("\t" + elements.get(index.get(d)) + ": " +  frequency.get(index.get(d)));
                }
            }
        }
        //Checking If ALL of The Frequencies are the same
        else if((Collections.max(frequency) == frequency.get(0) && frequency.size() > 1) && (index.size()>1 && Collections.max(frequency) !=1)){
            System.out.println("These Data Set is MultiModal!");
            System.out.println("The  Modes are the Following: ");
            int nextEl =0;
            for(int d =0; d < frequency.size(); d++){
                if(frequency.get(d) == frequency.get(nextEl +1)){ 
                    if(elements.get(index.get(d)) % 1 == 0){
                        System.out.println("\t" + elements.get(d).intValue() + ": " + frequency.get(d).intValue());
                    }
                    else{
                        System.out.println("\t" + elements.get(d) + ": " + frequency.get(d));
                    }
                    }
            }
        }
        else if(Collections.max(frequency) == 1){
            System.out.println("No Mode. There are NO DUPLICATES");
        }
        else{
            if(elements.get(index.get(0)) % 1 == 0){
            System.out.println("Mode: " + elements.get(index.get(0)).intValue());
            }
            else{
                System.out.println("Mode: " + elements.get(index.get(0)));
            }
        }
    }

}

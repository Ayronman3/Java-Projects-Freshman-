// TO DO:
// FIX THE IF - ELSE STATEMENT IN THE BMI METHOD AND GET THE VALUE OF HEIGHT IN METERS AND INPUT IT AS VAL2.
// CREATE A GUI
// IMPROVE SELECTION QUESTIONS
// USE STRING AS VARIABLE FOR WHILE LOOP
// ADD MORE OPERATIONS
// ADD MORE COMPLEX MATHEMATICAL OPERATIONS


import java.util.Scanner;
public class calculator{
	static double val1, val2, result, result1;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		System.out.println("*********************************************************************************************");
		System.out.println();
		System.out.println("This is my first Calculator Program!");
		System.out.println();
		System.out.println("*********************************************************************************************");
		
		System.out.println("Do you wish to continue? Press 1 for YES and 2 for NO." );

		int choose = sc.nextInt();
		while(choose == 1){

		// CHOOSING WHAT OPERATION TO USE

		System.out.println("---------------------------------------------------------------------");
		System.out.println("OPERATIONS AVAILABLE");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Inches To Feet Converter\n6. Feet To Inches Converter\n7. Kilometer To Miles Converter\n8. Miles To Kilometer Converter\n9. Kilograms To Pounds Converter\n10. Pounds To Kilograms Converter\n11. BMI Converter");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Please choose an operation");
		int choice = sc.nextInt();
		System.out.println();

		// ACTIVITAING OR CALLING THE METHOD OF THE OPERATION ACCORDING TO THE USER'S INPUT

		// Addition
		if (choice == 1){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the sum: " + add());
		System.out.println();
		System.out.println("*********************************************************************************************");
		}

		// Subraction
		else if (choice == 2){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the difference: " + subtract());
		System.out.println();
		System.out.println("*********************************************************************************************");
		}

		// Multiplication
		else if (choice == 3){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the product: " +  multiply());
		System.out.println();
		System.out.println("*********************************************************************************************");
		}

		// Division
		else if (choice ==4) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the quotient: " + divide());
		System.out.println();
		System.out.println("*********************************************************************************************");
		}

		// CONVERTERS

		//Inches To Feet
		else if (choice ==5) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the result of the conversion " + inchToFeet() + " ft.");
		System.out.println();
		System.out.println("*********************************************************************************************");
		}

		// Feet To Inches
		else if (choice ==6) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the result of the conversion: " + feetToInch() + " in.");
		System.out.println();
		System.out.println("*********************************************************************************************");
		}	

		// Kilometer To Miles
		else if (choice ==7) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the result of the conversion: " + kmToMiles() + " mi.");
		System.out.println();
		System.out.println("*********************************************************************************************");
		}

		// Miles To Kilometer
		else if (choice ==8) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the result of the conversion: " + milesToKilometer() + " km.");
		System.out.println();
		System.out.println("*********************************************************************************************");
		}
		
		// Kilograms To Pounds
		else if (choice ==9) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the result of the conversion: " + kgToLb() + " lb.");
		System.out.println();
		System.out.println("*********************************************************************************************");
		}	

		// Pounds To Kilograms
		else if (choice ==10) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("This is the result of the conversion: " + lbToKg() + " kg.");
		System.out.println();
		System.out.println("*********************************************************************************************");
		}	
	
		//BMI
		else if (choice ==11) {
		System.out.println("---------------------------------------------------------------------");
		bmi();
		System.out.println();
		System.out.println("*********************************************************************************************");
		}

	System.out.println("Do you wish to continue? Press 1 for YES and 2 for NO." );
	int choose2 = sc.nextInt();
	choose = choose2;

	if(choose == 2){	
			
	System.out.println("Thank you for using this program. Have a great day ahead! Godspeed!!");
	System.out.println("\t\t\t\t\t\t-From the programmer");
	break;
		}
	}
}
	// Addition Method
	 static double add(){
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter First number: ");
		val1 = sc.nextDouble();
		System.out.println("Enter Second number: ");
		val2 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");	
		result = val1 + val2;
		return result;
	}
	// Subtraction Method
	static double subtract(){
	
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter First number: ");
		val1 = sc.nextDouble();
		System.out.println("Enter Second number: ");
		val2 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result = val1 - val2;
		return result;
	}
	// Multiplication Method
	static double multiply(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter First number: ");
		val1 = sc.nextDouble();
		System.out.println("Enter Second number: ");
		val2 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result = val1 * val2;
		return result;
	}
	// Division Method
	static double divide(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter First number: ");
		val1 = sc.nextDouble();
		System.out.println("Enter Second number: ");
		val2 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result = val1 / val2;
		return result;
	}

	// CONVERTERS

	// Inch  To Feet Converter Method
	static double inchToFeet(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter Inch value: ");
		val1 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result1 = val1 / 12;
		// ROUND OFF FEET
		double result = Math.round(result1*100.0)/100.0; 
		return result;
	}
	// Feet To Inch Converter Method
	static double feetToInch(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter Feet value: ");
		val1 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result1 = val1 * 12;
		// ROUND OFF INCHES
		double result = Math.round(result1*100.0)/100.0; 
		return result;
	}
	// Kilometer To Miles Converter Method
	static double kmToMiles(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter Kilometer value: ");
		val1 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result1 = val1 / 1.609;
		//ROUND OFF MILES
		double result = Math.round(result1*100.0)/100.0; 
		return result;
	}
	// Miles To Kilometer Converter Method
	static double milesToKilometer(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter Miles value: ");
		val1 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result1 = val1 * 1.609;
		//ROUND OFF KM
		double result = Math.round(result1*100.0)/100.0; 
		return result;
	}
		
	static double kgToLb(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter Weight in Kilogram: ");
		val1 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result1 = val1 * 2.205;
		// ROUND OFF POUNDS
		double result = Math.round(result1*100.0)/100.0;
		return result;
	}
	static double lbToKg(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter Weight in Pounds: ");
		val1 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result1 = val1 / 2.205;
		// ROUND OFF KILOGRAMS
		double result = Math.round(result1*100.0)/100.0;
		return result;
	}
	// BMI Calculator Method
	static void bmi(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Enter Weight in Kilogram: ");
		val1 = sc.nextDouble();
		System.out.println("Do rou know your height in Meters?");
		System.out.println("If YES, Press y. If No, Press n.");
		// GETTING THE FIRST CHARACTER
		char ans = sc.next().charAt(0);
		if (ans == 'y'){
			System.out.println("Great! Let's Proceed");
			
		}
		else{
			System.out.println("Enter your Height in Feet: ");
			double height = sc.nextDouble();
			double heightInMeters = height/ 3.281;
			// ROUND OFF HEIGHT
			double heightRoundOff = Math.round(heightInMeters*100.0)/100.0; 
			System.out.println("This is your Height in Meters: " + heightRoundOff);
			
		}
		System.out.println("Please Enter your Height in Meters");
		double val2 = sc.nextDouble();
		System.out.println("---------------------------------------------------------------------");
		result = val1 / (val2*val2);
		
		// Asking If User wants to know his/her Nutritional Status 
		System.out.println("Do you want to know your Nutritional Status? ");
		System.out.println("If Yes, enter 1. If No, enter 2.");
		double answer = sc.nextDouble();
		if (answer == 1) {
			if(result < 18.5){
				System.out.println("Your BMI is : " + result + " You are UNDERWEIGHT");
			}
			else if(result >= 18.5 && result <= 24.9){
				System.out.println("Your BMI is : " + result + " You are NORMAL");
			}
			else if(result >= 25.0 && result <= 29.9){
				System.out.println("Your BMI is : " + result + " You are OVERWEIGHT");
				// Programmer's Recommendations To User
				System.out.println("Do you want some recommedation? Press y for YES and n for No,");
				// GETTING THE FIRST CHARACTER
				char answer2 = sc.next().charAt(0);
				if (answer2 == 'y'){
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Here are some of my recommended website to read!" );
				System.out.println();
				System.out.println("https://www.medicalnewstoday.com/articles/324123\nhttps://www.cdc.gov/healthyweight/losing_weight/index.html\nhttps://www.healthline.com/nutrition/30-ways-to-lose-weight-naturally\nhttps://www.healthline.com/nutrition/how-to-lose-weight-as-fast-as-possible#2.-Eat-protein,-fat,-and-vegetables");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Here are some YouTube channels to visit!");
				System.out.println();
				System.out.println("https://www.youtube.com/channel/UCFjc9H89-RpWuIStDqhO7AQ\nhttps://www.youtube.com/user/SelfMagazine\nhttps://www.youtube.com/user/ChloesAddiction");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Way to go warrior! You can do it! I'm rooting for you!");
				}
				else if(answer2 == 'n'){
					System.out.println("Your BMI is : " + result + " You are OVERWEIGHT");
				}
			

			}
			else if (result >= 30.0 && result <= 34.9){
				System.out.println("Your BMI is : " + result + " You are OBESE");
				// Programmer's Recommendations To User
				System.out.println("Do you want some recommedation? Press y for YES and n for No,");
				// GETTING THE FIRST CHARACTER
				char answer3 = sc.next().charAt(0);
				if (answer3 == 'y'){
					System.out.println("---------------------------------------------------------------------");
					System.out.println("Here are some of my recommended website to read!" );
					System.out.println();
					System.out.println("https://www.medicalnewstoday.com/articles/324123\nhttps://www.cdc.gov/healthyweight/losing_weight/index.html\nhttps://www.healthline.com/nutrition/30-ways-to-lose-weight-naturally\nhttps://www.healthline.com/nutrition/how-to-lose-weight-as-fast-as-possible#2.-Eat-protein,-fat,-and-vegetables");
					System.out.println("---------------------------------------------------------------------");
					System.out.println("Here are some YouTube channels to visit!");
					System.out.println();
					System.out.println("https://www.youtube.com/channel/UCFjc9H89-RpWuIStDqhO7AQ\nhttps://www.youtube.com/user/SelfMagazine\nhttps://www.youtube.com/user/ChloesAddiction");
					System.out.println("---------------------------------------------------------------------");
					System.out.println("Way to go warrior! You can do it! I'm rooting for you!");
				}
				else if(answer3 == 'n'){
					System.out.println("Your BMI is : " + result + " You are OBESE");
				}	
			
	
		} // END OF IF STATEMENT FOR BMI METHOD
		else if (answer == 2) {
			System.out.println("This is your BMI: " + result);
		} // END OF ELSE IF STATEMENT FOR BMI METHOD(CANNOT USE ELSE. THERE'S AN ERROR(else don't have if).
		
		}
		
	} // END OF BMI METHOD
	
} //END OF CLASS
/*  Author: Mauricio Rojas 
 * 	Date: September 20th, 2018
 * 	Description: This program opens and reads a file
 */

import java.util.*;


public class SimulateMarket {
	//Main Method tells you to run the program from Sample.java
	public static void main(String[] args) {
		System.out.println("Hello!\n\nPlease run this from Sample.java");
		System.out.println("\nThank you! :)");
	}
	
	
	//Linear Simulation Model
	public static void linear(double min, double max,double average,
			double median, double standardDeviation) 
	{
		int size = 3582;
		
		
		double linearInvestAverage = 100.0;
		double linearAverage = .0016;
		
		
		for (int i = 0; i < 3582; i++) {
			linearInvestAverage = (linearAverage + 1) * linearInvestAverage ;
		}

		double linearInvestMedian = 100.0;
		double linearMedian = .0029;
		for (int i = 0; i < 3582; i++) {
			linearInvestMedian = (linearMedian + 1) * linearInvestMedian ;
		}

		
		
		
		//Linear Distribution | Simulation Statistics
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Linear Simulation Statistics:\n");
		System.out.println("Total Result with the average: " + linearInvestAverage);
		System.out.println("Total Result with the median: " + linearInvestMedian);
		
		//Linear Distribution | Sample Statistics
		System.out.println("\n\nSample Statistics: \n");
		System.out.format("%-23s %15s %14s %n%-10s %10s %10s", 
				"Size: " + size, "Min: " + min, "Max: " + max
			  , "Mean: " + average, "Median: " + median, "SD: " + standardDeviation);
		System.out.println("\n-----------------------------------------------------\n\n");
	}
	
	//Distributional Simulation Model
	public static void distributional(double min, double max,double average,
			double median, double standardDeviation, double equity2 ) 
	{	
		int size = 1000;
		

		
		//Distributional Simulation | Simulation Statistics
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Distributional Simulation Statistics:\n");
		System.out.println("Total Result: " + equity2);
		
		//Linear Simulation | Sample Statistics
		System.out.println("\n\nSample Statistics: \n");
		System.out.format("%-23s %15s %14s %n%-10s %10s %10s", 
				"Size: " + size, "Min: " + min, "Max: " + max
			  , "Mean: " + average, "Median: " + median, "SD: " + standardDeviation);
		System.out.println("\n-----------------------------------------------------");
	}
	
	//MonteCarlo Simulation Model
	public static void monteCarlo(double min, double max,double average,
			double median, double standardDeviation, double equity) 
	{		
		int size = 3582;
	
		//Monte Carlo Simulation | Simulation Statistics
		System.out.println("\n\n\n-----------------------------------------------------");
		System.out.println("Monte Carlo Simulation Statistics:\n");
		System.out.println("Total Result: " + equity);
		
		//Monte Carlo Simulation | Sample Statistics
		System.out.println("\n\nSample Statistics\n");
		System.out.format("%-23s %15s %14s %n%-10s %10s %10s", 
				"Size: " + size, "Min: " + min, "Max: " + max
			  , "Mean: " + average, "Median: " + median, "SD: " + standardDeviation );
		System.out.println("\n-----------------------------------------------------");
	}
}

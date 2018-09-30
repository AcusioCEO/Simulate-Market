/*  Author: Mauricio Rojas 
 * 	Date: September 20th, 2018
 * 	Description: This program opens and reads a file
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;



public class Sample {

	//Makes an ArrayList of type Double
	static ArrayList<Double> array = new ArrayList<Double>();
	static ArrayList<Double> linearData = new ArrayList<Double>();
	static ArrayList<Double> distributionalData = new ArrayList<Double>();
	static ArrayList<Double> monteCarloData = new ArrayList<Double>();



	public static void main(String[] args) throws Exception {
		
		System.out.println("\n\n\n\n|----------Running Processes---------------------|");
		//Step 1: Open the sample data from a file and reads it
		System.out.println("\nOpening Sample data ... ");
		FileReader SP500Data = new FileReader("SP500-Weekly.txt"); 
		BufferedReader reader = new BufferedReader(SP500Data);

		//Empty String Array
		String text = "";
		//Reads the open file line by line 
		String line = reader.readLine();

		//Read till the end of each line
		while (line != null) 
		{	//Update the blank string array 'text' and fill it with the data from the file that is being read. Add a break between each line. 
			text += line + "\n"; 
			//Move to the next line
			line = reader.readLine();
		}

		//Store all the file data in memory & close the file
		System.out.println("Finished opening Sample data ... ");		
		//Close the file, so that there are no leaks in your code
		reader.close();

		//Step 2: Reformat the data so we can pull statistics
		//We want to be able to use ComputeStats()
		//We have to get rid of the date first
		System.out.println("Getting rid of the dates...");
		System.out.println("Shrinking to just the right column ... ");

		//Splits the 'text' array by the spaces
		String[] splitStr = text.split("\\s+");

		//Step 3: Add the data to our ArrayList<Double> 'array'
		//Will go through the entire set of data
		for (int i = 0; i <= 7164; i++) {
			if (i % 2 != 0) {
				//Will convert the String to a Double value for each
				double str2Dbl = Double.parseDouble(splitStr[i]);
				//Adds the new Double data to the ArrayList 'array'
				array.add(str2Dbl);
			}
		}
		//The data has been reformatted completely at this point
		System.out.println("Done shrinking ... Thank you! \n");
		System.out.println("|------------------------------------------------|\n\n");

		
		computeStats();
		simulationStats();
	}

	//Gets all the statistics from the simulation data
	static void simulationStats(){
		
		
//		ComputeLinear.computeStats(linearData);
		ComputeDistributional.computeStats(distributionalData);
		ComputeMonteCarlo.computeStats(monteCarloData);
		
	}

	static void computeStats() {

		System.out.println("|--------------Sample Statistics-----------------|\n");
		//sorts the array list
		Collections.sort(array);
		
		//Calculate Min/Max
		double min = Collections.min(array);
		double max = Collections.max(array);
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		
		//Calculate the Average
		double sum = 0;
		for (double i : array) {
			sum += i;
		}
		double average = sum / array.size();
		//prints out the average
		System.out.println("Average : " + average);

		
		// Calculate Median (middle number)
		double median = 0;
		double pos1 = Math.floor((array.size() - 1.0) / 2.0);
		double pos2 = Math.ceil((array.size() - 1.0) / 2.0);
		if (pos1 == pos2) {
			median = array.get((int)pos1);
		}
		else {
			median = ( array.get((int)pos1) + array.get((int)pos2) ) / 2.0 ;
		}
		System.out.println("Median: " + median);


		//Calculate Standard Deviation
		double sd = 0;
		for (int i = 0; i < array.size(); i++) {

			sd += ( (array.get(i) - average) * (array.get(i) - average) ) / ( array.size() - 1 );
		}
		double standardDeviation = Math.sqrt(sd);
		System.out.println("Standard Deviation: " + standardDeviation);
		System.out.println("\n|------------------------------------------------|\n\n");


		
//-----------------------Simulation Models------------------------------------

		//Linear Simulation
		SimulateMarket.linear(min, max, average, median, standardDeviation);


		//Distributional Simulation 
		double equity2 = 100.00;

		for (int i = 0; i < 1000; i++) 
		{
			Random random = new Random();
			
			double randGaus = random.nextGaussian();
			randGaus = (randGaus * standardDeviation) + average;
			equity2 =+ (1 + randGaus )* equity2;
			distributionalData.add(equity2);
		}
		
		

		SimulateMarket.distributional( min, max, average, median, standardDeviation, equity2);


		//Monte Carlo Simulation
		double equity = 100.00;

		for (int i = 0; i < 3582 ; i++) 
		{	
			Random r = new Random();
			double randomSample = array.get(r.nextInt(array.size()));
			equity =+ (1 + randomSample) * equity ;		
			monteCarloData.add(equity);
		}
		SimulateMarket.monteCarlo(min, max, average, median, standardDeviation, equity);
		
	}
		

	}




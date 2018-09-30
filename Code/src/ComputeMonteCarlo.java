import java.util.*;
import java.util.ArrayList;

public class ComputeMonteCarlo {
	public static void computeStats(ArrayList<Double> monteCarloData) {

				System.out.println("\n\n|--------------Monte Carlo Statistics-----------------|\n");
				//sorts the array list
				Collections.sort(monteCarloData);
				
				//Calculate Min/Max
				double min = Collections.min(monteCarloData);
				double max = Collections.max(monteCarloData);
				System.out.println("Min: " + min);
				System.out.println("Max: " + max);
				
				//Calculate the Average
				double sum = 0;
				for (double i : monteCarloData) {
					sum += i;
				}
				double average = sum / monteCarloData.size();
				//prints out the average
				System.out.println("Average : " + average);
		
				
				// Calculate Median (middle number)
				double median = 0;
				double pos1 = Math.floor((monteCarloData.size() - 1.0) / 2.0);
				double pos2 = Math.ceil((monteCarloData.size() - 1.0) / 2.0);
				if (pos1 == pos2) {
					median = monteCarloData.get((int)pos1);
				}
				else {
					median = ( monteCarloData.get((int)pos1) + monteCarloData.get((int)pos2) ) / 2.0 ;
				}
				System.out.println("Median: " + median);
		
		
				//Calculate Standard Deviation
				double sd = 0;
				for (int i = 0; i < monteCarloData.size(); i++) {
		
					sd += ( (monteCarloData.get(i) - average) * (monteCarloData.get(i) - average) ) / ( monteCarloData.size() - 1 );
				}
				double standardDeviation = Math.sqrt(sd);
				System.out.println("Standard Deviation: " + standardDeviation);
				System.out.println("\n|------------------------------------------------|\n\n");

	}
}

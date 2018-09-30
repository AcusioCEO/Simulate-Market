import java.util.*;
import java.util.ArrayList;

public class ComputeDistributional {
	public static void computeStats(ArrayList<Double> distributionalData) {

				System.out.println("\n\n\n\n|--------------Distributional Statistics-----------------|\n");
//				//sorts the array list
//				Collections.sort(linearData);
				
				//Calculate Min/Max
				double distributionalMin = Collections.min(distributionalData);
				double distributionalMax = Collections.max(distributionalData);
				System.out.println("Min: " + distributionalMin);
				System.out.println("Max: " + distributionalMax);
				
				//Calculate the Average
				double sum = 0;
				for (double i : distributionalData) {
					sum += i;
				}
				double distributionalAverage = sum / distributionalData.size();
				//prints out the average
				System.out.println("Average : " + distributionalAverage);
		
				
				// Calculate Median (middle number)
				double distributionalMedian = 0;
				double pos1 = Math.floor((distributionalData.size() - 1.0) / 2.0);
				double pos2 = Math.ceil((distributionalData.size() - 1.0) / 2.0);
				if (pos1 == pos2) {
					distributionalMedian = distributionalData.get((int)pos1);
				}
				else {
					distributionalMedian = ( distributionalData.get((int)pos1) + distributionalData.get((int)pos2) ) / 2.0 ;
				}
				System.out.println("Median: " + distributionalMedian);
		
		
				//Calculate Standard Deviation
				double sd = 0;
				for (int i = 0; i < distributionalData.size(); i++) {
		
					sd += ( (distributionalData.get(i) - distributionalAverage) * (distributionalData.get(i) - distributionalAverage) ) / ( distributionalData.size() - 1 );
				}
				double distributionalStandardDeviation = Math.sqrt(sd);
				System.out.println("Standard Deviation: " + distributionalStandardDeviation);
				System.out.println("\n|------------------------------------------------|\n\n");
				
				
	
	}
}

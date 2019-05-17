import java.io.*;
import java.util.Scanner;

/**
* This is the Scheduler 
*
* @author Amelia Tran
* @version 4/25/2019
*/

public class Scheduler {
	// declare gloabl variables
	private static Scanner parser;
	private static String token;
	private static PriorityQueue<Double, Integer, Integer> data = 
        	new PriorityQueue<Double, Integer, Integer>();
    private static Entry<Double, Integer, Integer> entry;

    /** main method to scan the files 
	* @param args -main method argument
	*/
	public static void main (String[] args) throws FileNotFoundException {	
		// declare local variables
		Integer time = new Integer(0);
		File infile = new File(args[0]);
        parser = new Scanner(infile);
        int intValue = 0;
        Double priority = 0.0;
        Integer val = 0;

        String result = "";   
        int count = 0;
        
        // add the first 5 jobs
        while (count<5) {
				token = parser.next();
				time = Integer.parseInt(token);
				intValue = time.intValue();
				priority = 1.0/intValue;
				entry = new Entry<>(priority, time, 0);
				data.add(entry);
				count ++;
		}
		// if there is still jobs in the queue
		while (!data.isEmpty()) {
			// remove the 1st job in the queue
			result = result +" "+ data.remove();

			// update the age and priority of the jobs left in the queue	
			for (int i =0; i < data.size(); i++){
				updateAge();
				if (data.get(i).getAge()>3) {
					data.get(i).setPriority(data.get(i).getPriority() + 0.2);
				}
			}
				
			// rearrange the queue
			data.siftDown(data.size()/2);

			// add another job
			if (parser.hasNext()) {
				token = parser.next();
				time = Integer.parseInt(token);
				intValue = time.intValue();
				priority = 1.0/intValue;
				entry = new Entry<>(priority, time, 0);
				data.add(entry);
			}
		}	
		
		// 12, 35, 75, 250, 400, 1000, 600, 378, 957
		System.out.print(result);
		System.out.println();
		
	}

	/**
	* The method to update the age
	*/
	public static void updateAge() {
		for (int i =0; i < data.size(); i++){
			data.get(i).setAge(data.get(i).getAge()+1);
		}
	}

} 
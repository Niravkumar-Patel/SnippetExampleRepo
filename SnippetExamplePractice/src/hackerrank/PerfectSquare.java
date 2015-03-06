package hackerrank;

import java.util.Scanner;

public class PerfectSquare {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Please Enter Your Lower Limit");
		int low = in.nextInt();
		int high = in.nextInt();
		in.close();
		
		int smallestNumber = (int)Math.ceil(Math.sqrt(low));
		int highestNumber = (int)Math.floor(Math.sqrt(high));
		
		System.out.println("Total Number of Perfect square are:"+(highestNumber-smallestNumber+1));
	}
}

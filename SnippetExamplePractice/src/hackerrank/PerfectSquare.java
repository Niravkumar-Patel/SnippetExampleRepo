package hackerrank;

public class PerfectSquare {

	public static void main(String args[]){
		int low = 17;
		int high = 100;
		
		int smallestNumber = (int)Math.ceil(Math.sqrt(low));
		int highestNumber = (int)Math.floor(Math.sqrt(high));
		
		System.out.println(highestNumber-smallestNumber+1);
	}
}

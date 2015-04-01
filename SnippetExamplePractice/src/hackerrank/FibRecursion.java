package hackerrank;

public class FibRecursion {
	
	public static void main(String args[]){
		int inputNum = 8;
		
		System.out.println("Fibonacci number at "+inputNum+" position is:"+computeFib(inputNum));
	}
	
	public static int computeFib(int n){
		if(n==0) return 0;
		if( n==1 || n ==2) return 1;
		/*
		 * recursion call with previous number
		 */
		return computeFib(n-1)+computeFib(n-2);		
	}

}

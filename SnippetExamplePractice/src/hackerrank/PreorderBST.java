package hackerrank;

import java.util.Stack;

public class PreorderBST {
	
public static void main(String args[]){
		
		int[] inputPreOrderArray = {1,2,3};
		System.out.println(checkBST(inputPreOrderArray));
	
		int[] inputPreOrderArray1 = {3,2,1,5,4,6};
		System.out.println(checkBST(inputPreOrderArray1));
		
		int[] inputPreOrderArray2 = {3,4,5,1,2};
		System.out.println(checkBST(inputPreOrderArray2));
	
		/*Scanner in = new Scanner(System.in);
		int testCaseNumber = Integer.parseInt(in.nextLine());
		ArrayList<String> output = new ArrayList<String>(); 
		while(testCaseNumber>0){
			int size = Integer.parseInt(in.nextLine());
			int[] preOrderArray = new int[size];
			String[] numberStrArray = in.nextLine().split(" ");
			for(int i=0;i<numberStrArray.length;i++){
				preOrderArray[i] = Integer.parseInt(numberStrArray[i]);
			}
			output.add(checkBST(preOrderArray));
			testCaseNumber--;
		}
		
		for(int i=0;i<output.size();i++){
			System.out.println(output.get(i));
		}
		
		in.close();*/
	}
	
	public static String checkBST(int[] inOrderArray){
		Stack<Integer> s = new Stack<Integer>();
		int lower = -1;
		for(int i=0;i<inOrderArray.length;i++){
			if(lower>-1 && inOrderArray[i] < lower){
				return "NO";
			}
			while(!s.isEmpty() && s.peek()<inOrderArray[i]){
				lower = s.pop();
			}
			s.push(inOrderArray[i]);
		}
		return "YES";
	}

}

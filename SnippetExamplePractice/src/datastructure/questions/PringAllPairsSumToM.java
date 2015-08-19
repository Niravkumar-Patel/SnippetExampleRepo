package datastructure.questions;
import java.util.ArrayList;

public class PringAllPairsSumToM {

	public static void printAllSum(ArrayList<Integer> sortedArray, int sum, int startIndex, int endIndex, ArrayList<Integer> newCurrentArray, Integer newNum ){
		ArrayList<Integer> currentArray = new ArrayList<Integer>(newCurrentArray);
		if(newNum!=null){
			currentArray.add(newNum);
		}
		
		for(int i=endIndex;i>=0;i--){
			int num = sortedArray.get(i);
			if(sum-num>0){
				printAllSum(sortedArray, sum-num, startIndex, i-1, currentArray, num);
				
			}else if(sum-num==0){
				ArrayList<Integer> finalArray = new ArrayList<Integer>(currentArray);
				finalArray.add(num);
				System.out.println(finalArray);
			}
		}
	}
	
	//given by author print only pairs of two
	public static void PrintAllPairs(int[] sorted, int M)
	{
		//as the key is to keep track of two indexes, left and right, we define the indexes
		int left = 0;//leftmost
		int right = sorted.length-1;//rightmost
		
		//now we start our loop, and only make sure left not meet right will we proceed
		while(left<right)
		{
			int tempSum = sorted[left] + sorted[right];//calculate the temp sum and use it to compare to M
			if(tempSum==M)//great we find one pair!
			{
				//format the output per line as "Sum{1,10}=11"
				System.out.println("Sum of {"+sorted[left]+", "+sorted[right]+"} = "+M);
				//do not forget the update both index values
				left++;
				right--;
			}
			else if(tempSum>M)//as the temp sum is bigger than M, 
								//we need more right focus left to make the future sum smaller
				right--;
			else//the only remaining case is temp sum smaller than M, so move left focus right 
				left++;
		}

	}

	public static void main(String[] args){
		
		int[] sorted = {1,3,4,5,5,6,7,8,11};
		PrintAllPairs(sorted, 11);

		
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		sortedArray.add(1);
		sortedArray.add(3);
		sortedArray.add(4);
		sortedArray.add(5);
		sortedArray.add(5);
		sortedArray.add(6);
		sortedArray.add(7);
		sortedArray.add(8);
		sortedArray.add(11);
		
		printAllSum(sortedArray, 11, 0, sortedArray.size()-1, new ArrayList<Integer>(),null);
	}
}

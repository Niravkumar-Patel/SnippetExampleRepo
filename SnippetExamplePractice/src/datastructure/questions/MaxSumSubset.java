package datastructure.questions;

public class MaxSumSubset {
	
	public static void printMaxSequeceSum(int[] inputArray){
		int currentStart = 0;
		int maxStart = 0;
		int maxEnd = 0;
		int max_sum = inputArray[currentStart];
		int curr_sum = max_sum;
		
		for(int i=1;i<inputArray.length;i++){
			curr_sum += inputArray[i];
			if(curr_sum<=0){
				currentStart=i+1;
				curr_sum = 0;
			}else if(curr_sum>max_sum){
				max_sum = curr_sum;
				maxStart = currentStart;
				maxEnd = i;
			}
		}
		
		System.out.println("Max Start:"+maxStart+": Max End:"+maxEnd);
		System.out.println("Max Sum:"+max_sum);
	}

	
	//Authors
	public static int MaxSubsetSum(int[] nums)
	{
		//we need define two key variables before loop
		//firstly we need a temp sum to keep track of the sum of numbers we processed so far
		//also we need a maxSum to keep track of the currently max sum so far for return purpose
		int tempSum = 0;
		int maxSum = 0;
		//we define the following three index variables to keep track of the sum's start and end indexes.
		int tempSumStartIndex = 0;
		int maxSumStart = 0;
		int maxSumEnd = 0;
		for(int i=0; i<nums.length;i++)
		{
			//as discussed in slides, the key is to decide if tempSum+nums[i]>0
			int futureSum = tempSum + nums[i];
			if(futureSum>0)//which means this can still be part of our final subset for max sum
			{
				tempSum = futureSum;
				//also check if the tempSum is larger than our maxSum recorded so far
				if(tempSum>maxSum)	
				{
					maxSum = tempSum;
					//whenver we update maxSum, we also update maxSum's indexes
					maxSumStart = tempSumStartIndex;
					maxSumEnd = i;//notice i in this closure is the end index
				}
			}
			else//which means the sum so far is negative or zero, which may not be a part of final subset for max sum
			{
				//thus we need reset tempSum
				tempSum = 0;
				//we made one error as we reset the sum that means we ignore the current index, so tempSum = i+1!
				tempSumStartIndex = i+1;//whenever we reset tempsum, we also reset tempSum's start index
			}
		}
		//finally return the maxSum
		//as we cannot return the index values to the method we print out before return in this method
		System.out.print("\nMax Start: "+maxSumStart+"\tEnd: "+maxSumEnd+"\n");

		return maxSum;
	}
	
	public static void main(String[] args){
		int[] inputArray = {1,2,3,-2,4,-1,8,1,1,-5};
		printMaxSequeceSum(inputArray);
		
		
		System.out.println(MaxSubsetSum(inputArray));
	}

}

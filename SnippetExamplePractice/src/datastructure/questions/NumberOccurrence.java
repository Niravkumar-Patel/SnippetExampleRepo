package datastructure.questions;

public class NumberOccurrence {
	
	public Integer[] inputArray = {1,2,3,3,3,4,5,6,7,7};
	
	public int countNumberOfOccurence(int startIndex, int endIndex, int number){
		
		if((inputArray[startIndex] == number) &&  (inputArray[endIndex] == number)){
			return endIndex - startIndex + 1;
		}
		
		int mid = (endIndex + startIndex)/2;
		
		if(inputArray[mid]>number){
			return countNumberOfOccurence(startIndex, mid-1, number);
		}else if(inputArray[mid]<number){
			return countNumberOfOccurence(mid+1, endIndex, number);
		}else{
			return countNumberOfOccurence(startIndex, mid, number) + countNumberOfOccurence(mid+1, endIndex, number);
		}
	}
	
	public static void main(String[] args){
		NumberOccurrence no = new NumberOccurrence();
		System.out.println(no.countNumberOfOccurence(0, no.inputArray.length-1, 7));
	}

}

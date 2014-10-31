package daa;

import java.util.ArrayList;

public class SelectionSort {
	
	private ArrayList<Integer> inputArray = new ArrayList<Integer>();
	
	//Just To fetch display purpose
	public ArrayList<Integer> getSortedArray() {
		return inputArray;
	}

	public SelectionSort(ArrayList<Integer> inputArray){
		this.inputArray = inputArray;
	}	
	
	public void sortGivenArray(){
		
		int smallInt = 0;
		int j=0;
		int smallIntIndex = 0;		
		
		for(int i=1;i<inputArray.size();i++){
			
			smallInt = inputArray.get(i-1);
			smallIntIndex = i-1;
			
			for(j=i;j<inputArray.size();j++){
				if(inputArray.get(j)<smallInt){
					smallInt = inputArray.get(j);
					smallIntIndex = j;
				}
			}
		
			//Swap the smallest element with the first element of unsorted subarray
			swap(i-1, smallIntIndex);			
		}
	}
	
	public void swap(int sourceIndex,int destIndex){		
		int temp = inputArray.get(destIndex);
		inputArray.set(destIndex, inputArray.get(sourceIndex));
		inputArray.set(sourceIndex, temp);
	}

}

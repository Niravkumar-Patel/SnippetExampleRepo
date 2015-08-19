package datastructure.questions;

import java.util.ArrayList;

public class PrintAllSubsets {
	
	public static void printSubsetOfArray(ArrayList<Integer> inputArray, String currentSet, int start,int end){
		
		for(int i=start;i<end;i++){
			String newSet = currentSet + inputArray.get(i);
			System.out.println(newSet);
			start++;
			printSubsetOfArray(inputArray, newSet, start, end);
		}
	}
	
	public static void main(String[] args){
		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		inputArray.add(1);
		inputArray.add(2);
		inputArray.add(3);
		inputArray.add(4);
		
		printSubsetOfArray(inputArray, "", 0, inputArray.size());
	}

}

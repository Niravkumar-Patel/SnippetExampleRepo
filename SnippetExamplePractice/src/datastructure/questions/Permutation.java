package datastructure.questions;

import java.util.ArrayList;

public class Permutation {
	
	public static void printAllPermutation(String currentString,String leftString){
		
		if(leftString.length()==0){
			System.out.println(currentString);
		}else{
			for(int i =0;i<leftString.length();i++){
				printAllPermutation(currentString+leftString.charAt(i), leftString.substring(0,i)+leftString.substring(i+1,leftString.length()));
			}
		}
	}
	
	public static void printAllPermutation1(String currentString,ArrayList<Character> leftArray){
		
		if(leftArray.size()==0){
			System.out.println(currentString);
		}else{
			for(int i=0;i<leftArray.size();i++){
				ArrayList<Character> newArray = new ArrayList<Character>(leftArray);
				newArray.remove(i);
				printAllPermutation1(currentString+leftArray.get(i), newArray);
			}
		}
		
		
	}
	
	public static void main(String[] args){
		ArrayList<Character> ac = new ArrayList<Character>();
		ac.add('a');
		ac.add('b');
		ac.add('c');
//		printAllPermutation1("", ac);
		
		
		String tempString = "abc";
		//System.out.println(tempString.substring(0,0));
		
		printAllPermutation("", "abc");
	}

}

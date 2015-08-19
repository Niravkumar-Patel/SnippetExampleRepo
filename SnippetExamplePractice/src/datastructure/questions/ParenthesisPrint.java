package datastructure.questions;

public class ParenthesisPrint {
	
	public static void printParenthesis(int leftParenthesis, int rightParenthesis, String currentString){
		
		if(leftParenthesis==0 && rightParenthesis==0){
			System.out.println(currentString);
		}else{
		
			if(leftParenthesis<=rightParenthesis){
				printParenthesis(leftParenthesis, rightParenthesis-1, currentString+")");
				
				if(leftParenthesis>0){
					printParenthesis(leftParenthesis-1, rightParenthesis, currentString+"(");
				}
			}
		}
	}

	public static void main(String args[]){
		printParenthesis(3, 3, "");
	}
}

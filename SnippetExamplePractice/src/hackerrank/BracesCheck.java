package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BracesCheck {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Please Enter Your String");
		String inputString = in.nextLine();
		System.out.println(checkBraces(inputString));
		in.close();
	}
	
	static String checkBraces(String value){
		Stack<Character> specialCharStack = new Stack<Character>();
		String response = "Fail";
	    char tempChar;
	    Character[] openingBraces = {'[','(','{'};
	    Character[] closingBraces = {']',')','}'};
	    List<Character> openingBracesList = Arrays.asList(openingBraces);
	    List<Character> closingBracesList = Arrays.asList(closingBraces);
	   
	    
	    
	    if(value == null){
	    	return response;
	    }else if(value.length()==0){
	    	response = "Pass";
	    }else{
	    
		    for(int i=0; i < value.length(); i++) {
		    	tempChar = value.charAt(i);
		    	
		    	if(openingBracesList.contains(tempChar)){
					specialCharStack.push(tempChar);
				}else if(closingBracesList.contains(tempChar)){
					if(!specialCharStack.isEmpty()){
						if(tempChar==')' && '(' != specialCharStack.pop()){
							return response;
						}else if(tempChar=='}' && '{' !=specialCharStack.pop()){
							return response;
						}else if(tempChar==']' && '[' != specialCharStack.pop()){
							return response;
						}
					}else{
						return response;
					}
				}else{
					return response;
				}
		    }
		    
	    }
		
		if( specialCharStack.isEmpty()){
			response = "Pass";
			return response;
		}else{
			return response;
		}
	}
}

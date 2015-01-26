package stringOperation;

public class StringOperation {

	// Reverse String using Iteration
	public String reverString(String str){
		StringBuilder reverseString = new StringBuilder();
		
		int i = str.length();
		while(i>0){
			i--;
			reverseString.append(str.charAt(i));
		}
		
		return reverseString.toString();
	}
		
	// Reverse String using Recursion
	public String reverseStringWithRecursion(String str) {

        //last element of string
        if (str.length() == 1) {
            return str;
        }

        return reverseStringWithRecursion(str.substring(1)) + str.charAt(0);
    }
	
	//Check whether given String is palindrom or not
	public boolean checkPalindrome(String str){
		int j = str.length();
		boolean flag = true;
		for(int i=0;i<j/2;i++){
			if(str.charAt(i) == str.charAt(j-1-i)){
				continue;
			}else{
				flag = false;
				break;
			}
		}
		return flag;
	}	
	
}

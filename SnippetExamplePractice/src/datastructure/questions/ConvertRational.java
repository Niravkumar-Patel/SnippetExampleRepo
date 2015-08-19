package datastructure.questions;

public class ConvertRational {
	
	public static void converttoRational(double inputDouble){
		String numberString = inputDouble+"";
		if(numberString.contains(".")){
			int precision = numberString.length() - numberString.indexOf(".")-1;
			int denom = Integer.parseInt(numberString.replace(".", ""));
			System.out.println(precision);
			int nomi = (int) Math.pow(10,precision);
			System.out.println(denom +":"+ nomi);
			int gcd = findGCD(denom, nomi);
			System.out.println((denom/gcd)+"/"+(nomi/gcd));
			
		}
		
	}
	
	public static int findGCD(int a, int b){
		if(a%b==0){
			return b;
		}else{
			return findGCD(b, (a%b));
		}
	}
	
	public static void main(String[] args){
		converttoRational(3.5);
	}

}

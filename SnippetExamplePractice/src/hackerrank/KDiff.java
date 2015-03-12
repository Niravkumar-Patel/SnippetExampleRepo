package hackerrank;

import java.util.HashSet;
import java.util.Iterator;

public class KDiff {
	
	public static void main(String args[]){

		int pairCount = 0;
		Integer elements[] = {1,3,4,5,8,8};
		int kDiff = 2;
		
		if(elements.length>1 && kDiff>=1 && elements.length == elements.length){
			
			HashSet<Integer> hSet = new HashSet<Integer>();
			
			for(int i=0;i<elements.length;i++){
				int inputElement = elements[i];
				if(!hSet.contains(inputElement)){
					hSet.add(inputElement);
				}
			}
		
			Iterator<Integer> itSet = hSet.iterator();
			
		    while (itSet.hasNext()) {
		    	
		    	Integer value = itSet.next();
		        Integer subtractValue =  value+kDiff;
		        
		        if(hSet.contains(subtractValue)){
		        	System.out.println("Pair Found:"+value+" & "+subtractValue);
		        	pairCount++;
		        }
		    }
		}else{
			pairCount=0;
		}
		
	    System.out.println("Total Pairs:"+pairCount);		
	}
}

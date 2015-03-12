package hackerrank;

import java.util.ArrayList;

public class EatenLeaves {
	
	public static void main(String args[]){
		int inputArray[] = {2,4,5,10,12};
		System.out.println("Survived Leaves Count:"+returnCountLeaves(10,inputArray));
	}

	static int returnCountLeaves(int N, int[] A ){
		
		ArrayList<Integer> reduceArrayList = new ArrayList<Integer>();
		reduceArrayList.add(A[0]);
		boolean reduceFlag = false;
		
		for(int i=1;i<A.length;i++){
			reduceFlag = false;
			for(int j=0;j<reduceArrayList.size();j++){
				if(A[i]%reduceArrayList.get(j)==0){
					reduceFlag = true;
					break;
				}
			}
			
			if(!reduceFlag){
				reduceArrayList.add(A[i]);
			}
		}
		
		System.out.println("Reduced Caterpillars:"+reduceArrayList);
		
		int survivedLeaves = 0;
		for(int m = 1;m<=N;m++){
			for(int j=0;j<reduceArrayList.size();j++){
				if(m%reduceArrayList.get(j) == 0){
					survivedLeaves++;
					break;
				}
			}
		}
		
		return N-survivedLeaves;		
	}
}

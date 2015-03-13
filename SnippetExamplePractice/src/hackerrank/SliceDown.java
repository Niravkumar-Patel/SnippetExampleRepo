package hackerrank;

public class SliceDown {

	public static void main(String args[]){
		SliceDown sd = new SliceDown();
		int a[] = {15,12,10,5,3};
		printArray(a, a.length);
		
		int smallestIndex = findSmallest(a);
		sd.sliceDown(a,a.length,smallestIndex);
	}
	
	/*
	 * recursively call this method by passing the index value of
	 * min number and the range that needs to be sliced down
	 */
	public void sliceDown(int a[],int range, int smallestIndex){

		int new_range = 0;
		int new_smallestIndex = -1;
		int smallNumber = a[smallestIndex];
		
		for(int i=0;i<range;i++){
			
			// To skip the number which is going to be slice down
			if(a[i]!=smallNumber){
				
				a[new_range] = a[i] - smallNumber;
				
				//To initialize & find the new minimum number for next iteration
				if(new_smallestIndex<0){
					new_smallestIndex = new_range;
				}else if(a[new_range] < a[new_smallestIndex]){
					new_smallestIndex = new_range;
				}
				
				new_range++;
			}
			
		}
		
		printArray(a,new_range);
		if(new_range>1){
			sliceDown(a, new_range,new_smallestIndex);
		}
	}
	
	//This method will be called only once for the first iteration
	private static int findSmallest(int a[]){
		int smallestIndex = 0;
		
		for(int i=1;i<a.length;i++){
			if(a[smallestIndex]>a[i]){
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
	
	public static void printArray(int a[],int range){
		for(int i=0;i<range;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("");
	}
	
	
}

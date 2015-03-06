package hackerrank;

public class SliceDown {

	public static void main(String args[]){
		SliceDown sd = new SliceDown();
		int a[] = {4,3,5,8,12};
		sd.sliceDown(a,a.length);
	}
	
	
	public void sliceDown(int a[],int range){

		int new_range = 0;
		if(range==1){
			
		}else{
			int smallestIndex = findSmallest(a,range);
			int smallNumber = a[smallestIndex];
			for(int i=0;i<range;i++){
				
				if(a[i]!=smallNumber){
					a[new_range] = a[i] - smallNumber;
					new_range++;
				}
				
			}
			printArray(a,new_range);
			if(new_range>1){
				sliceDown(a, new_range);
			}
		}
	}
	
	public int findSmallest(int a[],int range){
		int smallestIndex = 0;
		
		for(int i=1;i<range;i++){
			if(a[smallestIndex]>a[i]){
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
	
	public void printArray(int a[],int range){
		for(int i=0;i<range;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("");
	}
	
	
}

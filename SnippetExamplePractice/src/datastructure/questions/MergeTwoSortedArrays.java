package datastructure.questions;

public class MergeTwoSortedArrays {
	
	public static Integer[] mergeTwoSortedArray(Integer[] array1,Integer[] array2){
		  int newSize = array1.length + array2.length;
		  Integer[] mergedArray = new Integer[newSize];
		  
		  int pointer1 = 0;
		  int pointer2 = 0;
		  for(int i=0;i<newSize;i++){
			  if(pointer1 == array1.length && pointer2<array2.length){
				  mergedArray[i] = array2[pointer2];
				  pointer2++;
			  }else if(pointer2 == array2.length && pointer1<array1.length){
				  mergedArray[i] = array1[pointer1];
				  pointer1++;
			  }else{
				  if(array1[pointer1]<=array2[pointer2]){
					  mergedArray[i] = array1[pointer1];
					  pointer1++;
				  }else{
					  mergedArray[i] = array2[pointer2];
					  pointer2++;
				  }
			  }
		  }
		  return mergedArray;
	}
	
	public static void main(String[] args){
		Integer[] array1 = {1,3,5,7,9};
		Integer[] array2 = {2,3,6,8,10};
		
		Integer[] mergedArray = mergeTwoSortedArray(array1, array2);
		
		for(int i=0;i<mergedArray.length;i++){
			System.out.println(mergedArray[i]);
			
		}
	}

}

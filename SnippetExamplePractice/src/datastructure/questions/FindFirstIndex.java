package datastructure.questions;

public class FindFirstIndex {
	
	public static void findFirstIndexOfNo(int[] a,int start, int end, int n){
		
		int mid = (end+start)/2;
		if(a[mid]==n){
			if((end-start)==0){
				System.out.println(mid);
			}else{
				findFirstIndexOfNo(a, start, mid, n);
			}
		}else if(a[mid]<n){
			findFirstIndexOfNo(a, mid+1, end, n);
		}else{
			findFirstIndexOfNo(a, start, mid-1, n);
		}
	}
	
	public static void main(String[] args){
		int a[] = {1,1,2,2,2,3,3,4,5,5,5,5,6,7,8,9};
		findFirstIndexOfNo(a, 0, a.length-1, 5);
	}

}

package datastructure.questions;

public class PrintSpiral {
	
	public static void printSpiral(int[][] array2d,int xStart,int yStart,int xEnd, int yEnd){
			
		for(int j=yStart;j<yEnd;j++){
			System.out.println(array2d[xStart][j]);
		}
		
		for(int i=xStart+1;i<xEnd;i++){
			System.out.println(array2d[i][yEnd-1]);
		}
		
		for(int j=yEnd-2;j>=yStart;j--){
			System.out.println(array2d[xEnd-1][j]);
		}
		
		for(int i=xEnd-2;i>=xStart+1;i--){
			System.out.println(array2d[i][yStart]);
		}
		
		if((xStart+1<xEnd-1)||(yStart+1<yEnd-1)){
			printSpiral(array2d, xStart+1, yStart+1, xEnd-1, yEnd-1);
		}
		
	}
	
	public static void main(String[] args){
		int[][] nums = {{1, 2, 3, 10}, 
						{4, 5, 6, 20}, 
						{7, 8, 9, 30}};
		printSpiral(nums, 0, 0, 3, 4);
	}

}

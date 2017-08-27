package hackerrank;

public class WaterContainer {
	
	public static void main(String[] args){
		int heights[] = {4,2,6,1,8,1};
		System.out.println(calMaxArea(heights));
	}
	
	public static int calMaxArea(int[] heights){
		int maxArea = -1;
		int left = 0;
		int right = heights.length - 1;
		
		while(left<right){
			maxArea = Math.max (maxArea,((right - left - 1) * Math.min(heights[right], heights[left])));
			
			if(heights[left] < heights[right]){
				left++;
			}else{
				right--;
			}
		}
		return maxArea;
	}

}

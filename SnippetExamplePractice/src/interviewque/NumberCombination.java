package interviewque;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberCombination {

	public static int totalCombinationCountRecursive(int[] pointSet, int number) {
		int sum = 0;
		for (int i = 0; i < pointSet.length; i++) {
			if (number > pointSet[i]) {
				sum += totalCombinationCountRecursive(pointSet, number - pointSet[i]);
			} else if (number == pointSet[i]) {
				sum += 1;
			}
		}
		return sum;
	}

	public static int totalCombinationCountDynamic(int[] pointSet, int number, HashMap<Integer, Integer> resultMap) {
		int sum = 0;
		for (int i = 0; i < pointSet.length; i++) {
			if (number > pointSet[i]) {
				if (resultMap.containsKey(number - pointSet[i])) {
					sum += resultMap.get(number - pointSet[i]);
				} else {
					sum += totalCombinationCountDynamic(pointSet, number - pointSet[i], resultMap);
				}
			} else if (number == pointSet[i]) {
				sum += 1;
			}
		}
		resultMap.put(number, sum);
		return sum;
	}

	public static void printCombinationCount(int[] pointSet, int number, ArrayList<Integer> inputArray) {
		for (int i = 0; i < pointSet.length; i++) {
			if (number > pointSet[i]) {
				ArrayList<Integer> newInputArr = new ArrayList<>(inputArray);
				newInputArr.add(pointSet[i]);
				printCombinationCount(pointSet, number - pointSet[i], newInputArr);
			} else if (number == pointSet[i]) {
				for (Integer integer : inputArray) {
					System.out.print(integer + " ");
				}
				System.out.println(pointSet[i]);
			}
		}
	}

	public static void main(String[] args) {
		int[] pointSet = { 1, 2, 3 };
		int number = 5;
		
		/*
		 * For input 5
		 * Total combination count is : 13
		 * Combinations are as below:
		 * 1 1 1 1 1
		 * 1 1 1 2
		 * 1 1 2 1
		 * 1 1 3
		 * 1 2 1 1
		 * 1 2 2
		 * 1 3 1
		 * 2 1 1 1
		 * 2 1 2
		 * 2 2 1
		 * 2 3
		 * 3 1 1
		 * 3 2
		 */

		long startTime = System.nanoTime();
		System.out.println("Recursive Total combination count : " + totalCombinationCountRecursive(pointSet, number));
		long endTime = System.nanoTime();
		System.out.println("Recursive time : " + (endTime - startTime));


		HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		startTime = System.nanoTime();
		System.out.println(
				"Dynamic   Total combination count : " + totalCombinationCountDynamic(pointSet, number, resultMap));
		endTime = System.nanoTime();
		System.out.println("Dynamic time : " + (endTime - startTime));

		System.out.println("Total possible combinations are as below:");
		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		printCombinationCount(pointSet, number, inputArray);
	}

}

package interviewque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DepthSum {

	public static int caclulateDepthSumIterative(NestedList nestedList) {
		Queue<NestedList> queue = new LinkedList<NestedList>();
		queue.add(nestedList);
		Queue<Integer> depthQueue = new LinkedList<Integer>();
		int depth = 0;
		int sum = 0;

		depthQueue.add(depth);

		while (!queue.isEmpty()) {
			nestedList = queue.poll();
			depth = depthQueue.poll();

			if (nestedList.isList) {
				++depth;
				for (NestedList nL : nestedList.getNestedList()) {
					queue.add(nL);
					depthQueue.add(depth);
				}
			} else {
				sum += nestedList.getNumber() * depth;

			}
		}
		return sum;
	}

	public static int caclulateDepthSumRecursive(NestedList nestedList, int level) {
		int sum = 0;
		if (nestedList.isList) {
			for (NestedList nestedList2 : nestedList.getNestedList()) {
				sum += caclulateDepthSumRecursive(nestedList2, level + 1);
			}
		} else {
			sum = nestedList.number * level;
		}

		return sum;
	}

	public static void caclulateDepthSumRecursiveV1(NestedList nestedList, int level, List<Integer> results) {
		if (results.size() < level) {
			results.add(0);
		}

		if (nestedList.isList) {
			for (NestedList nestedList2 : nestedList.getNestedList()) {
				caclulateDepthSumRecursiveV1(nestedList2, level + 1, results);
			}
		} else {
			results.set(level - 1, results.get(level - 1) + nestedList.number);
		}
	}

	public static void main(String[] args) {
		NestedList n1Val = new NestedList(1);
		NestedList n2Val = new NestedList(1);
		NestedList n3Val = new NestedList(2);
		NestedList n4Val = new NestedList(1);
		NestedList n5Val = new NestedList(1);

		List<NestedList> nestedList1 = new ArrayList<NestedList>();
		nestedList1.add(n1Val);
		nestedList1.add(n2Val);

		List<NestedList> nestedList2 = new ArrayList<NestedList>();
		nestedList2.add(n4Val);
		nestedList2.add(n5Val);

		NestedList n1 = new NestedList(nestedList1);
		NestedList n2 = new NestedList(nestedList2);

		List<NestedList> nestedList3 = new ArrayList<NestedList>();
		nestedList3.add(n1);
		nestedList3.add(n3Val);
		nestedList3.add(n2);

		NestedList n3 = new NestedList(nestedList3);
		System.out.println("[[1,1], 2, [1,1]] Iterative depth sum: " + caclulateDepthSumIterative(n3));
		System.out.println("[[1,1], 2, [1,1]] Recursive depth sum: " + caclulateDepthSumRecursive(n3, 0));

		List<Integer> results = new ArrayList<Integer>();
		caclulateDepthSumRecursiveV1(n3, 0, results);

		System.out.println("\nVersion 1 : Depth is in increasing order");
		int depth = 1;
		int sum = 0;
		for (Integer i : results) {
			sum += i * depth;
			depth++;
		}
		System.out.println("[[1,1], 2, [1,1]] Recursive depth sum: " + sum);

		System.out.println("\nVersion 1 : Depth is in decresing order");
		depth = results.size();
		sum = 0;
		for (Integer i : results) {
			sum += i * depth;
			depth--;
		}
		System.out.println("[[1,1], 2, [1,1]] Recursive depth sum: " + sum);

		NestedList n6Val = new NestedList(6);
		NestedList n7Val = new NestedList(4);
		NestedList n8Val = new NestedList(1);

		List<NestedList> nestedList6 = new ArrayList<NestedList>();
		nestedList6.add(n6Val);

		NestedList n6 = new NestedList(nestedList6);

		List<NestedList> nestedList7 = new ArrayList<NestedList>();
		nestedList7.add(n7Val);
		nestedList7.add(n6);

		NestedList n7 = new NestedList(nestedList7);

		List<NestedList> nestedList8 = new ArrayList<NestedList>();
		nestedList8.add(n8Val);
		nestedList8.add(n7);

		NestedList n8 = new NestedList(nestedList8);

		System.out.println("\n[ 1 [ 4 [ 6 ] ] ] Iterative depth sum " + caclulateDepthSumIterative(n8));
		System.out.println("[ 1 [ 4 [ 6 ] ] ] Recursive depth sum " + caclulateDepthSumRecursive(n8, 0));

		results = new ArrayList<Integer>();
		caclulateDepthSumRecursiveV1(n8, 0, results);

		System.out.println("\nVersion 1 : Depth is in increasing order");
		depth = 1;
		sum = 0;
		for (Integer i : results) {
			sum += i * depth;
			depth++;
		}
		System.out.println("[ 1 [ 4 [ 6 ] ] ] Recursive depth sum: " + sum);

		System.out.println("\nVersion 1 : Depth is in decresing order");
		depth = results.size();
		sum = 0;
		for (Integer i : results) {
			sum += i * depth;
			depth--;
		}
		System.out.println("[ 1 [ 4 [ 6 ] ] ] Recursive depth sum: " + sum);
	}

}

class NestedList {
	int number;
	List<NestedList> nestedList;
	boolean isList = false;

	public NestedList(int number) {
		this.number = number;
		isList = false;
	}

	public NestedList(List<NestedList> nestedLists) {
		this.nestedList = nestedLists;
		isList = true;
	}

	public int getNumber() {
		return number;
	}

	public List<NestedList> getNestedList() {
		return nestedList;
	}
}
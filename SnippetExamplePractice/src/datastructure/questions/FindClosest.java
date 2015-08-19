package datastructure.questions;

public class FindClosest {
	
	public static void findCloset(Tree leftTree,Tree rightTree, int number){
		
		if((leftTree.value < number) && (number < rightTree.value)){
			Tree smallTree = leftTree;
			while(smallTree.right!=null && smallTree.right.value<number){
				smallTree = smallTree.right;
			}
			
			Tree greaterTree = rightTree;
			while(greaterTree.left!=null && greaterTree.left.value>number){
				greaterTree = greaterTree.left;
			}
			
			int greatDiff = Math.abs(greaterTree.value - number);
			int smallDiff = Math.abs(smallTree.value - number);
			
			if(smallDiff<greatDiff){
				System.out.println(smallTree.value);
			}else{
				System.out.println(greaterTree.value);
			}
		}else if(rightTree.value<number){
			if(rightTree.right!=null){
				findCloset(rightTree, rightTree.right, number);
			}else{
				System.out.println(rightTree.value);
			}
		}else if(leftTree.value>number){
			if(leftTree.left!=null){
				findCloset(leftTree.left, leftTree, number);
			}else{
				System.out.println(leftTree.value);
			}
			
		}else if(leftTree.value == number){
			System.out.println(leftTree.value);
		}else if(rightTree.value == number){
			System.out.println(rightTree.value );
		}
	}
	
	// Authors solution
	//final method to declare, after we find the 'min diff' we return diff+v as returned value
		public static int GetClosest(Tree t, int v)
		{
			int minDiff = Min_Diff(t, v);
			return minDiff+v;
		}

		//now come to define the key method
		public static int Min_Diff(Tree t, int v)
		{
			//as we discussed in slides, the key of finding 'closest value' is to find the minimal diff
			if(t == null)//make sure it is not an empty tree
				return Integer.MAX_VALUE;
			//now check the value to determine which sub-direction to search for the 'minimal diff'
			if(t.value<v)//which means the closest value can only exist in root or some value in its right sub-tree
				return smallDiff(t.value-v,Min_Diff(t.right, v)); //notice we recursively call the method 
			else//can only exist in either root or its left subtree
				return smallDiff(t.value-v,Min_Diff(t.left, v));
		}


		//firstly define a supportive method to determine the smaller difference
		private static int smallDiff(int a, int b)
		{
			if(Math.abs(a)>Math.abs(b))
				return b;
			return a;
		}
	
	
	
	public static void main(String[] args){
		//firstly create a test tree as
		//    100
		//  50   200
		// 10 60 150 300
		Tree myBST = new Tree(100);
		myBST.left = new Tree(50);	myBST.right = new Tree(200);
		myBST.left.left = new Tree(10);	myBST.left.right = new Tree(60);
		myBST.right.left = new Tree(150);
		
		findCloset(myBST, myBST, 120);
		findCloset(myBST, myBST, 80);
		findCloset(myBST, myBST, 1000);
		findCloset(myBST, myBST, 0);
		
		
		System.out.println("Closest value in BST to 120 is "+GetClosest(myBST, 120));
		System.out.println("Closest value in BST to 80 is "+GetClosest(myBST, 80));
		System.out.println("Closest value in BST to 1000 is "+GetClosest(myBST, 1000));
		System.out.println("Closest value in BST to 0 is "+GetClosest(myBST, 0));
		
	}
	

}

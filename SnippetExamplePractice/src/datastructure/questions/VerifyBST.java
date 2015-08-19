package datastructure.questions;

public class VerifyBST {

	public static boolean isBSTWithRecursion(Tree tree,int lowValue, int highValue){
		if(tree!=null){
			if(tree.value>lowValue && tree.value<highValue){
				return isBSTWithRecursion(tree.left, lowValue, tree.value) && isBSTWithRecursion(tree.right, tree.value, highValue);
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
	
	public static void main(String[] args){
		Tree myTree = new Tree(4);
		myTree.left = new Tree(2);
		myTree.right = new Tree(6);
		myTree.left.left = new Tree(1);
		myTree.left.right = new Tree(3);
		//myTree.right.left = new Tree(7);//now we test a false case
		myTree.right.right = new Tree(7);
		
		System.out.println(isBSTWithRecursion(myTree,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
}

class Tree {
	public int value;
	public Tree left;
	public Tree right;
	public Tree(int a)
	{
		value = a;
		left=right=null;
	}
}
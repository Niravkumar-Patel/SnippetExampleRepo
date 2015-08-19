package datastructure.questions;

import java.util.ArrayList;

public class PrintBinaryTreeLevel {
	public static int currentLevel = 0;
	
	public static void printAllBinaryTreeLevels(Tree tree){
		ArrayList<Tree> levelList = new ArrayList<Tree>();
		levelList.add(tree);
		printCurentLevels(levelList);
	}

	public static void printCurentLevels(ArrayList<Tree> levelList){
		if(levelList.size()==0){
			return;
		}
		
		ArrayList<Tree> newLevelList = new ArrayList<Tree>();
		System.out.println("\nLevel "+currentLevel);
		
		for(int i=0;i<levelList.size();i++){
			Tree tree = levelList.get(i);
			System.out.print(tree.value+" ");
			if(tree.left!=null)newLevelList.add(tree.left);
			if(tree.right!=null)newLevelList.add(tree.right);
		}
		currentLevel++;
		printCurentLevels(newLevelList);
	}
	
	public static void main(String[] args){
		Tree myTree = new Tree(4);
		myTree.left = new Tree(2);
		myTree.right = new Tree(6);
		myTree.left.left = new Tree(1);
		myTree.left.right = new Tree(3);
		//myTree.right.left = new Tree(7);//now we test a false case
		myTree.right.right = new Tree(7);
		
		printAllBinaryTreeLevels(myTree);
	}
}
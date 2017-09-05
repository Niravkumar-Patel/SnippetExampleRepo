package interviewque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindChildren {
	
	public static void main(String[] args){
		/*
		 1   2   4
		  \ / \ / \
		   3   5   8
		    \ / \   \
		     6   7   9
		*/
		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(new Node(-1, 1));
		nodeList.add(new Node(-1, 2));
		nodeList.add(new Node(-1, 4));
		nodeList.add(new Node(1, 3));
		nodeList.add(new Node(2, 3));
		nodeList.add(new Node(2, 5));
		nodeList.add(new Node(4, 5));
		nodeList.add(new Node(4, 8));
		nodeList.add(new Node(3, 6));
		nodeList.add(new Node(5, 6));
		nodeList.add(new Node(5, 7));
		nodeList.add(new Node(8, 9));
		
		printNodesByParent(nodeList, 2);
		printNodesByParent(nodeList, 1);
		printNodesByParent(nodeList, 0);
	}
	
	public static void printNodesByParent(List<Node> nodeList, int parent){
		Map<Integer, Integer> nodeIndexMap = scanNodes(nodeList);
		Map<Integer, Integer> indexNodeMap = inverseMap(nodeIndexMap);
		
		int[][] graph = new int[nodeIndexMap.size()+1][nodeIndexMap.size()+1];
		
		for(Node node : nodeList){
			if(node.getParent() != -1){
				graph[nodeIndexMap.get(node.getParent())][nodeIndexMap.get(node.getValue())] = 1;
			}
		}
		
		for(int j = 0; j < graph[0].length - 1; j++){
			int sum = 0;
			for(int i = 0; i < graph.length - 1; i ++){
				sum += graph[i][j];
			}
			graph[graph.length - 1][j] = sum;
		}
		
		/* Uncomment it to print matrix
		for(int i = 0;i < graph.length; i++){
			for(int j = 0; j < graph[0].length; j++){
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}*/
		
		System.out.println("Nodes with " + parent + " parent ");
		for(int i = graph.length - 1, j = 1; j < graph[0].length - 1 ; j++){
			if(graph[i][j] == parent){
				System.out.print(indexNodeMap.get(j) +" ");
			}
		}
		System.out.println();
	}
	
	public static Map<Integer, Integer> inverseMap(Map<Integer, Integer> inputMap){
		Map<Integer, Integer> indexNodeMap = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, Integer> entry : inputMap.entrySet()){
			indexNodeMap.put(entry.getValue(), entry.getKey());
		}
		return indexNodeMap;
	}
	
	public static Map<Integer, Integer> scanNodes(List<Node> nodeList){
		Map<Integer, Integer> nodeIndexMap = new HashMap<Integer, Integer>();
		nodeIndexMap.put(-1, 0);
		int index = 1;
		for(Node node: nodeList){
			if(!nodeIndexMap.containsKey(node.getValue())){
				nodeIndexMap.put(node.getValue(), index);
				index++;
			}
		}
		return nodeIndexMap;
	}
	
}

class Node {
	
	int parent = -1; // parent value with -1 is root
	int value = 0;
	
	public Node(int parent, int value){
		this.parent = parent;
		this.value = value;
	}
	
	public int getParent(){
		return parent;
	}
	
	public int getValue(){
		return value;
	}
}
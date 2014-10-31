package datastructure.tree;

public class Node {
	
	private Node leftNode;
	private Node rightNode;
	private int nodeValue;
	private String nodeInfo;
	
	public Node(String nodeInfo,int nodeValue){
		this.nodeInfo = nodeInfo;
		this.nodeValue = nodeValue;
	}
	
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public int getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}
	public String getNodeInfo() {
		return nodeInfo;
	}
	public void setNodeInfo(String nodeInfo) {
		this.nodeInfo = nodeInfo;
	}
}

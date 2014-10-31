package datastructure.tree;

public interface Tree {

	void insertNode(Node node);
	void deleteNode(Node node);
	Node searchNode(Node node);
	
	void inOrderTraversal(Node node);
	void preOrderTraversal(Node node);
	void postOrderTraversal(Node node);
}

package datastructure.tree;

public class TreeImpl implements Tree{

	int tree_node_count = 0;
	public Node rootNode = null;
	
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	public TreeImpl(Node rootNode){
		this.rootNode = rootNode;
		tree_node_count = 1;
	}

	@Override
	public void insertNode(Node node){
		Node treeNode = rootNode;
		
		while(true){
			if(node.getNodeValue()<treeNode.getNodeValue()){
				if(treeNode.getLeftNode()!=null){
					treeNode = treeNode.getLeftNode();
				}else{
					treeNode.setLeftNode(node);
					System.out.println("Node "+node.getNodeValue()+" saved at left child of node :"+treeNode.getNodeValue());
					break;
				}
			}else if(node.getNodeValue()>treeNode.getNodeValue()){
				if(treeNode.getRightNode()!=null){
					treeNode = treeNode.getRightNode();
				}else{
					treeNode.setRightNode(node);
					System.out.println("Node "+node.getNodeValue()+" saved at Right child of node :"+treeNode.getNodeValue());
					break;
				}
			}else{
				System.out.println("Duplicate Node can not be saved");
				break;
			}
		}
	}
	
	@Override
	public Node searchNode(Node node){
		Node currentNode = rootNode;
		while(currentNode!=null){
			if(currentNode.getNodeValue()==node.getNodeValue()){
				System.out.println("Node "+node.getNodeValue()+" Found");
				return currentNode;
			}else{
				if(node.getNodeValue()<currentNode.getNodeValue()){
					currentNode = currentNode.getLeftNode();
				}else{
					currentNode = currentNode.getRightNode();
				}
			}
		}
		System.out.println("Node "+node.getNodeValue()+" Not Found");
		return null;
	}


	@Override
	public void deleteNode(Node node) {
		Node previousNode =  null;
		Node currentNode = rootNode;
		
		if(node.getNodeValue()==currentNode.getNodeValue()){
			System.out.println("Your Tree is Vanished");			
		}else if(node.getNodeValue()<currentNode.getNodeValue()){
			previousNode = currentNode;
			currentNode = currentNode.getLeftNode();
		}else{
			previousNode = currentNode;
			currentNode = currentNode.getRightNode();
		}
		
		while(true){
			if(node.getNodeValue()==currentNode.getNodeValue()){
				
				
				if(currentNode.getRightNode()!=null){
					Node tempPreviousNode = currentNode;
					Node tempNode = currentNode.getRightNode();
					
					if(tempNode.getLeftNode()!=null){
						while(tempNode.getLeftNode()!=null){
							tempPreviousNode = tempNode;
							tempNode = tempNode.getLeftNode();
						}
						
						if(tempNode.getRightNode()!=null){
							tempPreviousNode.setLeftNode(tempNode.getRightNode());
							previousNode.setRightNode(tempNode);
							tempNode.setLeftNode(currentNode.getLeftNode());
							break;
						}else{
							tempNode.setLeftNode(currentNode.getLeftNode());
							tempNode.setRightNode(currentNode.getRightNode());
							previousNode.setRightNode(tempNode);
							tempPreviousNode.setLeftNode(null);
							break;
						}
					}else{
						tempNode.setLeftNode(currentNode.getLeftNode());
						previousNode.setRightNode(tempNode);
						break;
					}					
				}else if(currentNode.getLeftNode()!=null){
					previousNode.setLeftNode(currentNode.getLeftNode());
					currentNode = null;
					break;
				}else{
					currentNode = null;
					break;
				}				
			}else if(node.getNodeValue()<currentNode.getNodeValue()){
				previousNode = currentNode;
				currentNode = currentNode.getLeftNode();
			}else{
				previousNode = currentNode;
				currentNode = currentNode.getRightNode();
			}
		}
	}

	@Override
	public void inOrderTraversal(Node node) {
	
		if(node!=null){
			inOrderTraversal(node.getLeftNode());
			System.out.println("Node Value:"+node.getNodeValue());
			inOrderTraversal(node.getRightNode());
		}
	}

	@Override
	public void preOrderTraversal(Node node) {
		// TODO Auto-generated method stub
		if(node!=null){
			System.out.println("Node Value:"+node.getNodeValue());
			preOrderTraversal(node.getLeftNode());
			
			preOrderTraversal(node.getRightNode());
		}
	}

	@Override
	public void postOrderTraversal(Node node) {
		// TODO Auto-generated method stub
		if(node!=null){
			postOrderTraversal(node.getLeftNode());
			
			postOrderTraversal(node.getRightNode());
			System.out.println("Node Value:"+node.getNodeValue());
		}
	}
}

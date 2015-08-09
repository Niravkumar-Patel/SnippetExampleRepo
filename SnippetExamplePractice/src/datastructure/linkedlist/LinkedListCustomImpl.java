package datastructure.linkedlist;

public class LinkedListCustomImpl implements LinkedListCustom{
	
	private Node firstNode = null;
	private int size = 0;
	
	@Override
	public void add(Object object) {
		if(firstNode==null){
			Node tempNode = new Node();
			tempNode.setObject(object);
			firstNode = tempNode;
		}else{
			Node tempNode = firstNode;
			while(tempNode.getNextNode() !=null){
				tempNode = tempNode.getNextNode();
			}	
			
			Node newNode = new Node();
			newNode.setObject(object);
			
			tempNode.setNextNode(newNode);
		}
		size++;
	}

	@Override
	public Object get(int index) {
		Node tempNode = firstNode;
		
		for(int i=0;i<index;i++){
			if(tempNode.getNextNode()!=null){
				tempNode = tempNode.getNextNode();
			}else{
				System.out.println("Array Index Out Of Bound");
				return null;
			}
		}
		
		return tempNode.getObject();
	}

	@Override
	public Object remove(int index) {
		
		if(firstNode!=null){
			
			if(index==0){
				Node removedNode = firstNode;
				firstNode = firstNode.getNextNode();
				size--;
				return removedNode.getObject();
			}else{
				Node tempNode = firstNode;
				for(int i=0;i<index-1;i++){
					if(tempNode.getNextNode()!=null){
						tempNode = tempNode.getNextNode();
					}else{
						System.out.println("Array Index Out Of Bound");
						return null;
					}
				}
				
				if(tempNode.getNextNode()!=null){
					Node removedNode = tempNode.getNextNode();
					tempNode.setNextNode(tempNode.getNextNode().getNextNode());
					size--;
					return removedNode.getObject();
				}else{
					System.out.println("Array Index Out Of Bound");
					return null;
				}
			}
		}else{
			System.out.println("Array Index Out Of Bound");
			return null;
		}
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		Node tempNode = firstNode;
		if(firstNode==null){
			return sb.toString();
		}else{
			while(tempNode.getNextNode()!=null){
				sb.append(tempNode.getObject()+", ");
				tempNode = tempNode.getNextNode();
			}
			sb.append(tempNode.getObject());
			return sb.toString();
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmplty() {
		return size>0?false:true;
	}

	@Override
	public void addBefore(Object newObject, Object refObject) {
		if(firstNode!=null){
			if(firstNode.getObject().equals(refObject)){
				Node newNode = new Node();
				newNode.setObject(newObject);
				newNode.setNextNode(firstNode);
				firstNode = newNode;
				size++;
			}else{
				Node prevNode = firstNode;
				Node currNode = firstNode.getNextNode();
				
				boolean found = false;
				while(currNode!=null){
					if(currNode.getObject().equals(refObject)){
						Node newNode = new Node();
						newNode.setObject(newObject);
						newNode.setNextNode(currNode);
						prevNode.setNextNode(newNode);
						found = true;
						break;
					}else{
						prevNode = currNode;
						currNode = currNode.getNextNode();
					}
				}
				
				if(found){
					size++;
				}else{
					System.out.println("Element Not Found");
				}
			}
		}else{
			System.out.println("Element Not Found");
		}
	}

	@Override
	public void addAfter(Object newObject, Object refObject) {
		if(firstNode!=null){			
			Node currNode = firstNode;
			
			boolean found = false;
			while(currNode!=null){
				if(currNode.getObject().equals(refObject)){
					Node nextNode = currNode.getNextNode();
					Node newNode = new Node();
					newNode.setObject(newObject);
					newNode.setNextNode(nextNode);
					currNode.setNextNode(newNode);
					found = true;
					break;
				}else{
					currNode = currNode.getNextNode();
				}
			}
			
			if(found){
				size++;
			}else{
				System.out.println("Element Not Found");
			}
		}else{
			System.out.println("Element Not Found");
		}
	}

}

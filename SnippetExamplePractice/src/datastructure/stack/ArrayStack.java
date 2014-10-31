package datastructure.stack;

public class ArrayStack implements Stack {
	
	private Object stack[];
	private int capacity;
	private int currentPos=-1;
	
	public ArrayStack(int capacity){
		this.capacity = capacity;
		stack = new Object[capacity];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.capacity;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(currentPos<0){
			return true;
		}
		return false;
	}

	@Override
	public Object top() throws Exception {
		// TODO Auto-generated method stub	
		if(currentPos<0){
			throw new Exception("Stack is Empty");
		}
		return stack[currentPos];
	}

	@Override
	public void push(Object element) throws Exception {
		// TODO Auto-generated method stub
		if(currentPos==capacity){
			throw new Exception("Stack is Full");
		}
		stack[++currentPos] = element;
	}

	@Override
	public Object pop() throws Exception {
		// TODO Auto-generated method stub
		if(currentPos<0){
			throw new Exception("Stack is Empty");
		}
		return stack[currentPos--] = null;
	}

}

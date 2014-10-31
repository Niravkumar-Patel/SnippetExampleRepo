package datastructure.stack;

public interface Stack {

	//accessor method stack
	public int size();
	public boolean isEmpty();
	public Object top() throws Exception;
	
	//update method stack
	public void push(Object element) throws Exception;
	public Object pop() throws Exception;
}

package datastructure.queue;

import java.util.ArrayList;

public class QueueImpl implements Queue{

	private ArrayList<Object> al;
	private int rear=-1;
	private int front=-1;
	private int size;
	
	public QueueImpl(int size){
		
		al = new ArrayList<Object>();
		this.size = size;
		
		//System.out.println("Queue of size:"+size+" created");
	}
	
	@Override
	public void add(Object element) throws Exception{
		// TODO Auto-generated method stub
		
		if((rear-front+1)==0 || (rear-front+1==size)){
			throw new Exception("Queue is full");
		}
		
		if(rear==-1 && front ==-1){
			front = 0;
		}
		
		rear = (rear + 1)%size;		
		al.add(rear,element);	
	}

	@Override
	public void remove() throws Exception{
		// TODO Auto-generated method stub
		
		if(rear == front){
			throw new Exception("Que is Empty");
		}
		
		if(rear==0){
			rear = size-1;
		}else{
			rear--;
		}
	}

	@Override
	public Object front() throws Exception {
		// TODO Auto-generated method stub
		if(rear == front && front == -1){
			throw new Exception("Que is Empty");
		}		
		return al.get(front);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		//System.out.println("Rear"+rear+"Front:"+front);
		
		if(rear==front && rear==-1)return 0;
		
		int queSize = rear-front+1;
		if(queSize>0){
			return queSize; 
		}else{
			return size-queSize;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(front==rear){
			return true;
		}
		return false;
	}

}

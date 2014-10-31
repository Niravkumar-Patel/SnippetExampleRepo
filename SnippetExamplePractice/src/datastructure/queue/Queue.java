package datastructure.queue;

public interface Queue {
	
		public void add(Object element) throws Exception;
		public void remove() throws Exception;
		public Object front() throws Exception;
		public int size();
		public boolean isEmpty();
}

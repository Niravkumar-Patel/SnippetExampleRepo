package datastructure.linkedlist;

public interface LinkedListCustom {

	public void add(Object object);
	public void addBefore(Object newObject,Object refObject);
	public void addAfter(Object newObject,Object refObject);
	public Object get(int index);
	public Object remove(int index);
	public int getSize();
	public boolean isEmplty();
}

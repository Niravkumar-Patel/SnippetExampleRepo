package datastructure.questions;

//we firstly define our List class
public class ReverseList {
	
	public static List reveserList(List list){
		
		if(list.next!=null){
			List reversedList = reveserList(list.next);
			list.next.next = list;
			list.next = null;
			return reversedList;
		}else{
			return list;
		}
	}
	
	public static void main(String args[]){
		List l4 = new List(4);
		List l3 = new List(3);
		l3.next = l4;
		List l2 = new List(2);
		l2.next = l3;
		List l1 = new List(1);
		l1.next = l2;
		
		System.out.println(l1.tostring());
		List rList = reveserList(l1);
		System.out.println(rList.tostring());
		
	}
}

//we firstly define our List class
class List {
	int value;
	List next;
	//constructor
	public List(int k) {
		value = k;
	}
	//we also define a tostring method to easy output
	public String tostring() {
		List current = this;
		String output = "";
		while(current!=null) {
			output += current.value+"->";
			current = current.next;//do not forget to increment the pointer index current
		}
		return output+"NULL";
	}
}
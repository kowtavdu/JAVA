package dataStructure;

import java.util.HashMap;

class Node{
	
	int key;
	String value;
	Node next;
	Node prev;
	
	Node(int key, String value){
		this.key = key;
		this.value = value;
	}
	
}

class LRU{
	
	Node head;
	Node end;
	
	int capacity;
	
	LRU(int capacity){
		this.capacity = capacity;
	}
	
	HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
	public void setHead(Node n){
		n.next = head;
		n.next = null;
		
		if(head!=null){
			head.prev = n;
		}
		
		head = n;
		if(end==null){
			end=head;
		}
	}
	
	public void set(int key, String value){
		if(hm.containsKey(key)){
			Node n = hm.get(key);
			n.value = value;
			remove(n);
			setHead(n);
		}else{
			Node n = new Node(key, value);
			if(hm.size()>=capacity){
				hm.remove(end.key);
				remove(end);
				setHead(n);
			}else{
				setHead(n);
			}
			hm.put(key, n);
		}
	}
	
	public void remove(Node n){
		if(n.next!=null){
			n.next.prev = n.prev;
		}else{
			end = n.prev;
		}
		
		if(n.prev!=null){
			n.prev.next = n.next;
		}else{
			head = n.next;
		}
	}
	public String get(int key){
		if(hm.containsKey(key)){
			Node n = hm.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return "-1";
	}
	
	
}

public class LruDS {

	public static void main(String[] args) {
		System.out.println("Hi i am here.....");
		
		LRU ll = new LRU(2);
		ll.set(1, "saurabh");
		ll.set(2, "Gaurabh");
		ll.set(3, "Abhishec");
		System.out.println("@@@@@@@@@@@@@ "+ll.get(1));
	}
}

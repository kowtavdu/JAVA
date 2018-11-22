package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


class Node{
	int key;
	String value;
	Node pre;
	Node next;
	
	public Node(int key, String value){
		this.key = key;
		this.value = value;
	}
}
class LRUCache{
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
	}
	public String get(int key){
		if(map.containsKey(key)){
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return "-1";
	}
	public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, String value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
}

public class CustomLRU {

	
	
	public static void main(String[] args) {
		Map m = new HashMap<>();
		m.put(1, "saurabh");
		m.put(1, "Gaurabh");
		System.out.println(m);
		/*LRUCache ll = new LRUCache(4);
		ll.set(1, "saurabh");
		ll.set(2, "gaurabh");
		ll.set(1, "Aaurabh");
		System.out.println(ll.equals(3));*/
		
	}
}

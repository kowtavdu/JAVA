
public class MyLinkedList {
    Node head;
	class Node{
		Node next;
		int data;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	int size = 0;
	//insert at specific Node
	public void insertAtPoistion(int position, Node head, int data) throws Exception{
		if(position==1){
			push(data);
			return;
		}
		Node new_node = new Node(data);
		Node prev = findPrevNode(head, position);
		if(prev==null){
			new_node.next = head;
			head = new_node;
		}else{
			
			//if(prev!=null){
				new_node.next = prev.next;
				prev.next = new_node;
			//}
		}
		size++;
        //return head;
	}
	
	void deleteFirst(){
		if(head!=null){
			head = head.next;
		}
	}
	
	void deleteLast(){
		Node temp = head;
		Node prev = null;
		while(temp.next!=null){
			prev = temp;
			temp = temp.next;		
		}
		prev.next = temp.next;
		
	}
	
	public Node findPrevNode(Node head, int position) throws Exception{
		Node prev = null;
		int i=1;
		while(head !=null && i < position){
			prev = head;
			head = head.next;
			i++;
		}
		
		if(i<position){
			
			System.out.println("Inalid List");
			throw new Exception();
		}
		return prev;
		
	}
	
	public void deleteAtPoistion(int position, Node head) throws Exception{
		if(head==null) return;
		if(position==1){
			deleteFirst();
		}
		
		Node prev = findPrevNode(head, position);
		if(prev==null || prev.next==null) return;
		
		Node next = prev.next.next;
		prev.next = next;
		/*if(position==1){
			deleteFirst();
		}else{
			if(head.next.next!=null){
			   prev.next = head.next.next;
			   return;
			}
		}*/
	}
	
	//insert at start
	public void push(int d){
		Node new_node = new Node(d);
		new_node.next = head;
		head = new_node;
		size++;
	}
	
	//insert at last
	public void inserLast(int d){
		Node new_node = new Node(d);
		if(head==null){
			head = new_node;
		}else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = new_node;
			
		}
		size++;	
	}
	
	
	public void printLinkedList(){
		Node top_node = head;
		while(top_node!=null){
			System.out.print(" "+top_node.data);
			top_node = top_node.next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		MyLinkedList ll = new MyLinkedList();
		ll.push(2);
		ll.push(4);
		ll.push(3);
		ll.inserLast(5);
		ll.push(6);
		ll.push(7);
		try {
			ll.insertAtPoistion(1, ll.head, 11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ll.deleteFirst();
		ll.deleteLast();
		ll.deleteAtPoistion(9, ll.head);
		System.out.println("Final Size is "+ll.size);
		//ll.printLinkedList();
		/*try {
			ll.head = insertAtPoistion(9, ll.head, 11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println();
		ll.printLinkedList();
	}
}

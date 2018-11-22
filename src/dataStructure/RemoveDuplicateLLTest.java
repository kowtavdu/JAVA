package dataStructure;

class RemoveDuplicateLL{
	Node head;
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	void removeDuplicate(){
		Node ptr1, ptr2, dup =null;
		
		ptr1 = head;
		while(ptr1!=null && ptr1.next!=null){
			ptr2 = ptr1;
			//compare the picked element with restOf elements
			while(ptr2.next!=null){
				
				//if duplicate then delete it
				if(ptr1.data == ptr2.next.data){
					dup = ptr2.next;
					ptr2.next = ptr2.next.next; 
				}else{
					ptr2 = ptr2.next; 
				}
			}
			ptr1 = ptr1.next;
		}
	}
	void push(int data){
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	void printLL(){
		Node topNode = head;
		while(topNode!=null){
			System.out.print(topNode.data+" ");
			topNode = topNode.next;
		}
	}
}
public class RemoveDuplicateLLTest {

	public static void main(String[] args) {
		RemoveDuplicateLL ds = new RemoveDuplicateLL();
		ds.push(2);
		ds.push(5);
		ds.push(5);
		ds.push(3);
		ds.printLL();
		ds.removeDuplicate();
		System.out.println("remove duplicate element");
		ds.printLL();
	}
}

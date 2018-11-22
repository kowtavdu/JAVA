package dataStructure;

class DeleteNodeLL{
	Node head;
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	void push(int value){
		Node new_value = new Node(value);
		new_value.next = head;
		head = new_value;
	}
	
	void deleteNode(int key){
		// delete first occurence of key
		Node temp = head,prev = null;
		if(temp!=null && temp.data == key){
			head = temp.next;
			return;
		}
		
		//search key to be deleted 
		while(temp!=null && temp.data != key){
			prev = temp;
			temp = temp.next;
		}
		if(temp ==null) return;
		prev.next = temp.next;
	}
	void printLL(){
		Node topNode = head;
		while(topNode!=null){
			System.out.print(topNode.data+" ");
		 topNode = topNode.next;	
		}
	}
}
public class DeleteLLTest {

	public static void main(String[] args) {
		DeleteNodeLL ds = new DeleteNodeLL();
		ds.push(3);
		ds.push(5);
		ds.push(9);
		ds.push(4);
		ds.push(7);
		ds.printLL();
		ds.deleteNode(9);
		System.out.println("List after delete");
		ds.printLL();
	}
}

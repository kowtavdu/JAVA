package dataStructure;



class MergeSortLinkedListImpl{
	
	Node head;
	class Node{
		int data;
		Node next;
		
		Node(int d){
		this.data = d;
		next = null;
		}
	}
	
	void push(int n){
		Node new_node = new Node(n);
		new_node.next = head;
		head = new_node;
		
	}
	
	void printList(){
		Node top_node = head;
		while(top_node!=null){
			System.out.print(top_node.data+ " ");
			top_node = top_node.next;
		}
	}
	
	Node merge(Node left, Node right){
		if(left == null){
			return right;
		}
		if(right==null){
			return left;		
		}
		
		Node temp = null;
		if(left.data < right.data){
			temp = left;
			temp.next = merge(left.next, right);
		}
		else{
			temp = right;
			temp.next = merge(right.next, left);
		}
		return temp;
	}
	Node mergeSort(Node head){
		if(head ==null || head.next ==null){
			return head;
		}

		Node middle = middleElement(head);
		Node nextOfMiddle = middle.next;
	    middle.next = null;
	    
	    Node left = mergeSort(head);
	    Node right = mergeSort(nextOfMiddle);
		
	    Node sortdList = merge(left,right);
	    return sortdList;
	}
	
	
	Node middleElement(Node head){
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	
}


public class MergeSortLinkedList {

	public static void main(String[] args) {

		MergeSortLinkedListImpl ds = new MergeSortLinkedListImpl();
		ds.push(2);
		ds.push(9);
		ds.push(6);
		ds.push(8);
		ds.push(5);
		ds.push(3);
		ds.printList();
		ds.head = ds.mergeSort(ds.head);
		System.out.println();
		ds.printList();
	}
}

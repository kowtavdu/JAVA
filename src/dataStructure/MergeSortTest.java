package dataStructure;

class MSort{
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
	
	Node getMiddle(Node n){
		if(n == null) 
			return n;
		Node fastptr = n.next;
		Node slowptr = n;
		//fastptr move 2 and slowptr move 1
		while(fastptr!=null){
			
			fastptr = fastptr.next;
			if(fastptr!=null){
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}
	
	Node mergeSort(Node n){
		if(n==null || n.next==null){
			return n;
		}
		Node middle = getMiddle(n);
		Node nextTomiddle = middle.next;
		
		//set the next of middle node to null
		middle.next = null;
		
		//Apply merge short on left List
		Node left = mergeSort(n);
		
		//Apply merge short on right List
		Node right = mergeSort(nextTomiddle);
		
		//merge left and right List
		Node sortedList = sortedMerge(left, right);
		return sortedList;
	}
	
	Node sortedMerge(Node left, Node right){
		Node result = null;
		if(left ==null)
			return right;
		if(right == null)
			return left;
		if(left.data <= right.data){
			result = left;
			result.next = sortedMerge(left.next, right);
		}else{
			result = right;
			result.next = sortedMerge(right.next, left);
		}
		return result;
	}
}

public class MergeSortTest {

	public static void main(String[] args) {
		MSort ds = new MSort();
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

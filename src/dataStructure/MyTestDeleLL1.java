package dataStructure;

class MyTestDeleLL{
	
    Node head;
    class Node{
    	int data;
    	Node next;
    	Node(){}
    	Node(int data){
    		this.data = data;
    		this.next = null;
    	}
    }
    
    void insertData(int d){
    	Node new_node = new Node(d);
    	new_node.next = head;
    	head = new_node;
    }
    
    void printLL(){
    	Node topNode = head;
    	while(topNode!=null){
    		System.out.print(" "+topNode.data);
    		topNode = topNode.next;
    	}
    	System.out.println();
    }
    
    void deletNode(int d){
    	Node temp = head, prev = null;
    	if(temp!=null && temp.data==d){
    		head = temp.next;
    		return;
    	}
    	if(temp!=null && temp.data!=d){
    		prev = temp;
    		temp = temp.next;
    	}
    	
    	if(temp==null) return;
    	prev.next = temp.next;
    }
    
    
    Node reverseLinkedList(Node node){
    	Node prev = null;
    	Node current = node;
    	Node next = null;
    	while(current!=null){
    		next = current.next;
    		current.next = prev;
    		prev = current;
    		current = next;
    	}
    	node = prev;
    	return node;
    }
    
    Node findNTh(Node head, int position){
    	Node prev = null;
    	int i=0;
    	while(head!=null && i< position){
    		prev = head;
    		head = head.next;
    		i++;
    	}
    	
    	if(i<position){}
    	
    	return prev;
    }
    
    Node insertAtPosition(int data, Node head, int position){
    	Node new_node = new Node();
    	new_node.data = data;
    	Node prev = findNTh(head, position);
    	if(prev ==null){
    		new_node.next = head;
    		head = new_node;
    	}else{
    		new_node.next = prev.next;
    		prev.next = new_node;
    	}
    	
    	return head;
    	
    }
	
}


class MyConst{
	private MyConst(){
		
	}
}


public class MyTestDeleLL1 {

	private MyTestDeleLL1(){
		System.out.println("Called in private constructor");
	}
	public static void main(String[] args) {
		MyTestDeleLL1 tt = new MyTestDeleLL1();
		/*MyTestDeleLL ll = new MyTestDeleLL();
		ll.insertData(2);
		ll.insertData(5);
		ll.insertData(7);
		ll.insertData(9);*/
		//ll.printLL();
		//ll.deletNode(7);
		//ll.printLL();
		//ll.head = ll.reverseLinkedList(ll.head);
		//System.out.println("----REVERSE---");
		//ll.printLL();
		//(int data, Node head, int position)
		//ll.head = ll.insertAtPosition(6,ll.head,3);
		//ll.printLL();
		
		
	}
}

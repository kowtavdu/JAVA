package dataStructure;


public class InsertMiddleReverseLL {

	static Node head;
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
		public Node() {		
		}
		
	}
	
	
	Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
        	next = current.next;
            current.next = prev;
            prev = current;
            current = next; 
        }
        node = prev;
        return node;
    }
	void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
	
	void printLL(){
		Node topNode = head;
		while(topNode!=null){
			System.out.print(topNode.data+" ");
			topNode = topNode.next;
		}
		System.out.println();
	}
	
	Node FindNth(Node head, int position)
	{
	    Node prev = null;
	    int i = 0;

	    while (head !=null && i < position) {
	        prev = head;
	        head = head.next;
	        i++;
	    }

	    if (i < position) {
	        // List is too short. Throw an exception perhaps?
	    }

	    return prev;
	}

	Node InsertNth(Node head, int data, int position) {
	    Node newNode = new Node();
	    newNode.data = data;

	    Node prev = FindNth(head, position);

	    if (prev == null) {
	        newNode.next = head;
	        head = newNode;
	    } else {
	        newNode.next = prev.next;
	        prev.next = newNode;
	    }

	    return head;
	}
	public static void main(String[] args) {
		InsertMiddleReverseLL llist = new InsertMiddleReverseLL();
		llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(3);
 
        /*System.out.println("\nCreated Linked list is:");
        llist.printLL();
        llist.head = llist.reverse(llist.head);
        llist.printLL();*/
        llist.head = llist.InsertNth(llist.head, 23, 2);
        llist.printLL();
        
		
		
	}
}

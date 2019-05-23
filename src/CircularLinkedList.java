
public class CircularLinkedList {

	
	/*Node head;
	Node tail;
	int size = 0;
	class Node{
	    int data;
	    Node next;
	    public Node(int data){
	        this.data = data;
	    }
	}
	
	public void add_push(int data){
		Node new_node = new Node(data);
		if(size==0){
		 head = new_node;
         tail = new_node;
         new_node.next = head;
		}else{
			Node temp = head;
			new_node.next = temp;
			head =  new_node;
			tail.next = temp;
		}
		size ++;
	}
	
	void printLinkedList(){
		System.out.print("Circular Linked List:");
        Node topNode = head;
		do {
			System.out.println(" "+topNode.data);
			topNode = topNode.next;
		}
		while(topNode!=head);
		System.out.println();
	}*/
	
	class Node{
	    int data;
	    Node next;
	    public Node(int data){
	        this.data = data;
	    }
	}
	public int size =0;
    public Node head;
    public Node tail;

    //add a new node at the start of the linked list
    /*public void addNodeAtStart(int data){
        System.out.println("Adding node " + data + " at start");
        Node n = new Node(data);
        if(tail==null){
            head = n;
            tail = n;
            n.next = head;
        }else{
            Node temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }*/
    
    public void addAtStart(int data){
    	Node n = new Node(data);
        if(head==null){
        	head = n;
            tail = n;
            n.next = head;
        }else{
        	//System.out.println("sssssssss");
        	Node temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
    }

    public void addNode(int data){
    	Node n = new Node(data);
        if(head==null){
        	addAtStart(data);
        }else{
        	tail.next = n;
            tail=n;
            tail.next = head;
        }
        //System.out.println("\nNode " + data + " is added at the end of the list");
    }

    public void deleteEndNode(){
    	if(head==null){
    		System.out.println("List is Empty");
    		return; 
    	}else{
    		Node current;
    		if(head!=tail){
    		   current = head;
    		   while(current.next!=tail){
    			   current = current.next;
    		   }
    		   tail = current;
    		   tail.next = head;
    		}else{
    			head = tail;
    		}
    	}
    }
    public void deleteNodeFromStart(){
    	System.out.println("HI I AM HRTR..");
        if(head==null){
            System.out.println("\nList is Empty");
        }else{
            System.out.println("\ndeleting node " + head.data + " from start");
            head = head.next;
            tail.next=head;
            size--;
        }
    }

    //print the linked list
    public void print(){
        System.out.print("Circular Linked List:");
        Node temp = head;
        if(tail==null){
            System.out.print("List is empty");
        }else{
        	System.out.println(temp.data);
        	while(temp.next!=head){
        		temp = temp.next;
        		System.out.println(temp.data);
        	}
            /*do {
                System.out.print(" " + temp.data);
                temp = temp.next;
            }
            while(temp!=head);*/
        }
        System.out.println();
    }

    //get Size
    public int getSize(){
        return size;
    }
	
	public static void main(String[] args) {
		CircularLinkedList n = new CircularLinkedList();
		n.addNode(3);
		n.addNode(4);
		n.addNode(6);
		n.addAtStart(7);
		n.deleteEndNode();
		n.deleteNodeFromStart();
		n.print();
	}
}

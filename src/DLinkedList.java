
public class DLinkedList {

	Node head;
	class Node{
		int data;
		Node prev;
		Node next;
		
		Node(int d){
			data = d;
		}
	}
	
	void push(int d){
		Node new_node = new Node(d);
		new_node.next = head;
		new_node.prev = null;
		
		if(head!=null){
			head.prev = new_node;
		}
		head = new_node;
		
	}
	
    void printList(){
    	Node topNode = head;
    	while(topNode !=null){
    		System.out.println(" "+topNode.data);
    		topNode = topNode.next;
    	}
    	
    }
    
    void addLast(int data){
    	Node new_node = new Node(data);
    	
    	Node last = head;
    	new_node.next = null;
    	
    	//if list is empty make new node as head
    	if(head==null){
    		new_node.prev = null;
    		head = new_node;
    		return;
    		
    	}
    	
    	while(last.next!=null){
    		last = last.next;
    	}
    	
    	//change last to lastNode
    	last.next = new_node;
    	
    	//make last node as previous node
    	new_node.prev = last;
    }
    
    void insertAfter(Node prevNode, int data){
    	Node new_node = new Node(data);
    	
    	new_node.next = prevNode.next;
    	prevNode.next = new_node;
    	
    	new_node.prev = prevNode;
    	
    	if(new_node.next !=null){
    		new_node.next.prev = new_node;
    	}
    	
    }
	
    void deleteFirst(){
    	if(head!=null){
    		head = head.next; 
    	}
    }
    /*
     * TODO
     */
    void deleteAtNode(Node rootNode){
         //System.out.println(rootNode.data+"----------");
         if(rootNode.prev==null && rootNode.next==null){
        	 head=null;
         }
         //delete first/head
         else if(rootNode.prev==null && rootNode.next!=null){
        	 rootNode = head;
        	 rootNode = rootNode.next;
        	 rootNode.prev = null;
         }else{
        	 rootNode = rootNode.next;
        	 head = rootNode;
        	 
         }
         //prevNode.prev = prevNode.next.next;
    }
    
    void deleteLast(){
    	Node last = head;
    	while(last.next!=null){
    		last = last.next;
    	}
    	last = last.prev;
    	last.next = null;
    	//System.out.println("#######"+last.data+"----"+last.prev.data);
    	/*last.prev = head;
    	last.next = null;*/
    	
    }
    
	public static void main(String[] args) {
		DLinkedList ll = new DLinkedList();
		
		ll.push(3);
		/*ll.push(5);*/
		ll.deleteAtNode(ll.head);
		ll.addLast(6);
		/*ll.insertAfter(ll.head, 8);
		ll.push(7);*/
		
		//ll.deleteFirst();
		//ll.deleteLast();
		ll.printList();
	}

	
}

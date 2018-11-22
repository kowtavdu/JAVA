package dataStructure;

import java.util.Stack;

public class QueueWith2Stack {

	static class Queue{
		Stack<Integer> stack1;
		Stack<Integer> stack2;
	}
	
	static void push(Stack<Integer> top_ref, int new_data){
		top_ref.push(new_data);
	}
	
	static int pop(Stack<Integer> top_ref){
		if(top_ref.isEmpty()){
			System.out.println("Stack UnderFLow");
			System.exit(0);
		}
		return top_ref.pop();
	}
	
	// Function to enqueue an item to the queue
    static void enQueue(Queue q, int x)
    {
        push(q.stack1, x);
    }
    
    /* Function to deQueue an item from queue */
    static int deQueue(Queue q)
    {
        int x;
 
        /* If both stacks are empty then error */
        if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
            System.out.println("Q is empty");
            System.exit(0);
        }
 
        /* Move elements from stack1 to stack 2 only if
        stack2 is empty */
        if (q.stack2.isEmpty()) {
            while (!q.stack1.isEmpty()) {
                x = pop(q.stack1);
                push(q.stack2, x);
            }
        }
        x = pop(q.stack2);
        return x;
    }
	public static void main(String[] args) {
		/* Create a queue with items 1 2 3*/
        Queue q = new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);
 
        /* Dequeue items */
        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");
        System.out.println(deQueue(q) + " ");
	}
}

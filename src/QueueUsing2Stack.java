import java.util.Stack;


/*
 *enqueue(q, x)
 * 1. while s1 is  empty move every thing to s2
 * 2. put x to s1
 * 3. push everything back from s2 to s1
 * 
 * dequeue(q)
 * if stack s1 is empty then throw error
 * pop an item from s1 and return it
 */

public class QueueUsing2Stack {

	static class Queue {
		static Stack<Integer> s1 = new Stack<Integer>();
		static Stack<Integer> s2 = new Stack<Integer>();
		
		static void enqueue(int x){
			 while(!s1.isEmpty()){
				 s2.push(s1.pop());
			 }
			 
			 s1.push(x);
			 while(!s2.isEmpty()){
				 s1.push(s2.pop());
			 }
		}
		
		static int dequeue(){
			if(s1.isEmpty()){
				System.out.println("stack under flow");
				System.exit(0);
			}
			
			int x = s1.peek();
			s1.pop();
			return x;
		}
		
	}
	public static void main(String[] args) {
       Queue q = new Queue();
       q.enqueue(2);
       q.enqueue(4);
       q.enqueue(3);
       
       System.out.println(q.dequeue());
       System.out.println(q.dequeue());
       System.out.println(q.dequeue());
	}
}

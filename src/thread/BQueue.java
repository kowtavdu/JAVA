package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class ProThread implements Runnable{
	Queue sharedQueue;
	String name;
	int size;
	ProThread(Queue sharedQueue, int size, String name){
		this.sharedQueue = sharedQueue;
		this.size = size;
		this.name = name;
	}
	
	public void run(){
		while(true){
			synchronized (sharedQueue) {
		
				while(sharedQueue.size()==size){
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					Random random = new Random(); 
					int i = random.nextInt();
					System.out.println("Producing "+i);
					sharedQueue.add(i);
					sharedQueue.notifyAll();
				
				
			}
		}
	}
}

class ConsThread implements Runnable {
	Queue sharedQueue;
	String name;
	int size;
	ConsThread(Queue sharedQueue, int size, String name){
		this.sharedQueue = sharedQueue;
		this.size = size;
		this.name = name;
	}
	
	public void run(){
		while(true){
			synchronized (sharedQueue) {
			
				while(sharedQueue.isEmpty()){
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					System.out.println("Consuming "+sharedQueue.remove());
					sharedQueue.notifyAll();
				
			}
		}
	}
	
	
}


public class BQueue {

	public static void main(String[] args) {
		
		Queue<Integer> sharedQueue = new LinkedList<>();
		Thread pr = new Thread(new ProThread(sharedQueue,5,"PRODUCER"));
		Thread con = new Thread(new ConsThread(sharedQueue,5,"CONSUMER"));
		
		pr.start();
		con.start();
		
		
		
	}
}

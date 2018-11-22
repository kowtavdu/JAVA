package Concu;

import java.util.Vector;


class Producer implements Runnable{

	private final Vector sharedQueue;
	private final Integer size;
	
	Producer(Vector sharedQueue,Integer size){
		this.sharedQueue = sharedQueue;
		this.size = size;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<7;i++){
			System.out.println("Produced "+i);
			try {
				produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void produce(int i) throws InterruptedException{
		while(sharedQueue.size() == size){
			synchronized (sharedQueue) {
				System.out.println("Queue size is full "+Thread.currentThread().getName()+" is waiting, size "+sharedQueue.size());
				sharedQueue.wait();
			}
		}
		
		synchronized(sharedQueue){
		   sharedQueue.add(i);
		   sharedQueue.notifyAll();
		}
	}
	
	
	
}

class Consumer implements Runnable {
	private final Vector sharedQueue;
	private final int size;

	Consumer(Vector sharedQueue, int size) {
		this.sharedQueue = sharedQueue;
		this.size = size;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				System.out.println("Consumed " + consume());
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private int consume() throws InterruptedException{
		while(sharedQueue.isEmpty()){
			synchronized (sharedQueue) {
				System.out.println("Queue is Empty "+Thread.currentThread().getName()+ "is waiting, Size: "+sharedQueue.size());
				sharedQueue.wait();
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			return (int) sharedQueue.remove(0);
		}
	
	}
}

public class PCWaitNotify {

	public static void main(String args[]){
		System.out.println("HI I am here");
		Vector sharedQueue = new Vector();
		Integer size =4;
		Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer"); 
		Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
		prodThread.start();
		consThread.start();
	}
}
 
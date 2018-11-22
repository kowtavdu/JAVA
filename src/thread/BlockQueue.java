package thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class BQProducer implements Runnable{
	private final BlockingQueue queue;
	
	BQProducer(BlockingQueue queue){
		this.queue = queue;
		
	}
	
	public void run(){
		Random ran = new Random();
		while(true){
			int i = ran.nextInt();
			try {
				System.out.println("PRODUCER "+i);
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class BQConsumer implements Runnable{
	private final BlockingQueue queue;
	
	BQConsumer(BlockingQueue queue){
		this.queue = queue;
	}
	
    public void run(){
	 while(!queue.isEmpty()){
		 try {
			System.out.println("CONSUMER "+queue.take()); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }	
	}
}


public class BlockQueue {

	public static void main(String[] args) {
	
		BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<>(3);
		
		Thread BQConsumer = new Thread(new BQConsumer(bqueue));
		Thread BQProducer = new Thread(new BQProducer(bqueue));
		BQProducer.start();
		BQConsumer.start();
		
		
	}
}

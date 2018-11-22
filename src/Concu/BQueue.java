package Concu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BConsumer implements Runnable{
	BlockingQueue blockingQueue = null; 
	BConsumer(BlockingQueue blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	@Override
	public void run(){
		try {
			System.out.println("11 "+blockingQueue.take());
			System.out.println("22 "+blockingQueue.take());
			System.out.println("33 "+blockingQueue.take());
			System.out.println("44 "+blockingQueue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class BProducer implements Runnable{
	private BlockingQueue blockingQueue = null;
	BProducer(BlockingQueue blockingQueue){
		this.blockingQueue = blockingQueue;
	}
	
	public void run(){
		try{
			blockingQueue.put(1);
			Thread.sleep(500);
			blockingQueue.put(2);
			Thread.sleep(500);
			blockingQueue.put(3);
			Thread.sleep(500);
			blockingQueue.put(4);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
public class BQueue {

	public static void main(String args[]){
		System.out.println("HI I AM HERE>>>>");
		BlockingQueue blockingQueue = new ArrayBlockingQueue<>(1024);
		Thread PQueue = new Thread(new BProducer(blockingQueue),"Producer");
		Thread CQueue = new Thread(new BConsumer(blockingQueue),"Consumer");
		PQueue.start();
		CQueue.start();
	}
}

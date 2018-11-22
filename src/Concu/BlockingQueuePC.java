package Concu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class Message{
	private String msg;
	Message(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return msg;
	}
	
}

class PCConsumer implements Runnable{
	BlockingQueue<Message> queue = null;
	
	PCConsumer(BlockingQueue queue){
		this.queue = queue;
	}
	@Override
	public void run(){
		while(!queue.isEmpty()){
			try {
				System.out.println("Getting value from queue "+queue.take().getMsg());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
class PCProducer implements Runnable{
	BlockingQueue<Message> queue = null;
	PCProducer(BlockingQueue bq){
	  this.queue = bq;	
	}
	@Override
	public void run(){
		for (int i=0;i<10;i++){
			Message msg = new Message("Message "+i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced "+msg.getMsg());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		Message msg = new Message("Exit queue");
		try{
			queue.put(msg);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
public class BlockingQueuePC {

	public static void main(String args[]){
		System.out.println("Blocking Queue Producer Consumer Problem");
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(1024);
		Thread prodQueu = new Thread(new PCProducer(queue),"ProducerQueue");
		Thread consQueu = new Thread(new PCConsumer(queue),"ConsumerQueue");
		prodQueu.start();
		consQueu.start();
		System.out.println(" Producer Consumer Has been startred");
	}
}

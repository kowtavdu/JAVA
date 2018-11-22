package thread;

import java.util.concurrent.atomic.AtomicInteger;

class ProcessingThread implements Runnable{
	//private int count;
	AtomicInteger count = new AtomicInteger();
	public void run(){
		for(int i=0;i<5;i++){
			processSomething(i);
			//count ++;
			count.getAndIncrement();
		}
	}
	
	public int getCount(){
		return count.get();
	}
	
	public void processSomething(int i){
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class CheckWithAtomic {

	public static void main(String[] args) throws InterruptedException {
		ProcessingThread poc = new ProcessingThread();
		Thread t1 = new Thread(poc, "Thread t1");
		t1.start();
		Thread t2 = new Thread(poc, "Thread t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("AAAAAAAA  "+poc.getCount());
		
	}
}

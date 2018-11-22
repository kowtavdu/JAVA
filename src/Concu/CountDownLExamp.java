package Concu;

import java.util.concurrent.CountDownLatch;

class Service implements Runnable{
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;
	
	public Service(String name, int timeToStart, CountDownLatch latch){
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(timeToStart);
		} catch(InterruptedException e){
			System.out.println(""+Service.class.getName());
		} 
		System.out.println(name + " is UP");
		latch.countDown();
	}
	
}
public class CountDownLExamp {

	public static void main(String args[]){
		CountDownLatch countDwnLatch = new CountDownLatch(3);
		Thread t1 = new Thread(new Service("--one--- ",1000,countDwnLatch));
		Thread t2 = new Thread(new Service("--two--- ",1000,countDwnLatch));
		Thread t3 = new Thread(new Service("--three--- ",1000,countDwnLatch));
		t1.start();
		t2.start();
		t3.start();
		
		try{
			countDwnLatch.await();
			System.out.println("All services are up, Application is starting up");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

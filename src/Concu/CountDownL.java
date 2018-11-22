package Concu;
import java.util.concurrent.CountDownLatch;

class Waiter implements Runnable {

	CountDownLatch latch = null;
	public Waiter(CountDownLatch cl){
		this.latch = cl;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			latch.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Waiter released");
	}
	
}

class Decrementor implements Runnable {
	CountDownLatch latch = null;
    public Decrementor(CountDownLatch cl){
    	this.latch = cl;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(1000);
			this.latch.countDown();
			
			Thread.sleep(1000);
			this.latch.countDown();
			
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("Counting all Latch is complete");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
public class CountDownL {

	public static void main(String args[]) throws InterruptedException{
		CountDownLatch latch = new CountDownLatch(3);

		Waiter      waiter      = new Waiter(latch);
		Decrementor decrementer = new Decrementor(latch);

		new Thread(waiter)     .start();
		new Thread(decrementer).start();
		Thread.sleep(4000);
		System.out.println("CountDown Latch is complete");
	}
}

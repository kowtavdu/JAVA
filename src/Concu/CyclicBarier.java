package Concu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarier {

	public static class Task implements Runnable{
		
        private CyclicBarrier cycbar;
        Task(CyclicBarrier cycbar){
        	this.cycbar = cycbar;
        }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				System.out.println(Thread.currentThread().getName()+" is waiting on barier");
				cycbar.await();
				System.out.println(Thread.currentThread().getName()+" has crossed the barier");
				//cycbar.reset();
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch (BrokenBarrierException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
	}
	public static void main(String args[]){
		System.out.println("HI i am inside cyclic Barier");
		CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				System.out.println("All parties have arrived at barrer lets play");
			}
		});
		cb.reset();
		Thread t1 = new Thread(new Task(cb), "Thread1");
		Thread t2 = new Thread(new Task(cb), "Thread2");
		Thread t3 = new Thread(new Task(cb), "Thread3");
		Thread t4 = new Thread(new Task(cb), "Thread4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

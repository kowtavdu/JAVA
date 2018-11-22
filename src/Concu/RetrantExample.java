package Concu;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class RetrantExample<E> {

	private final Lock lock = new ReentrantLock();
	private final List<E> list = new ArrayList<E>();
	private static int i =0;
	
	public void set1(E o){
		lock.lock();
		try{
			i++;
			list.add(o);
			System.out.println("Adding Element by thread"+Thread.currentThread().getName());
		}finally{
			lock.unlock();
		}
	}
	public static void main(String args[]){
		System.out.println("HI i am here");
		final RetrantExample<String> lockExample = new RetrantExample<String>();
		Runnable syncThread= new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(i<6){
					lockExample.set1(String.valueOf(i));
					try{
						Thread.sleep(10);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable lockThread  = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(i<6){
					lockExample.set1(String.valueOf(i));
					try{
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t1 = new Thread(syncThread, "syncThread");
		Thread t2 = new Thread(lockThread, "lockThread");
		t1.start();
		t2.start();
		
	}
}

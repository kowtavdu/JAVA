package com.java.garbage;

class MyThread1 implements Runnable {
	Object obj1;
	Object obj2;
	MyThread1(Object t1,Object t2){
		this.obj1 =t1;
		this.obj2 =t2;
	}
    @Override
	public void run() {
		// TODO Auto-generated method stub
	   synchronized (obj1) {
		System.out.println("Thread is holding lock1 ");
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread is waiting lock2 ");
		synchronized (obj2) {
			System.out.println("Thread is holding lock1 and lock2 ");
		}
	}	
	}
	
}
class MyThread2 implements Runnable {
	Object obj1;
	Object obj2;
	MyThread2(Object t1,Object t2){
		this.obj1 =t1;
		this.obj2 =t2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	   synchronized (obj2) {
		System.out.println("Thread is holding lock2 ");
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread is waiting lock1 ");
		synchronized (obj1) {
			System.out.println("Thread is holding lock1 and lock2 ");
		}
	}	
	}
	
}

public class DeadLockExample {
	static Object obj1 = new Object();
	static Object obj2 = new Object();
	
	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new MyThread1(obj1, obj2),"S1");
		Thread t2 = new Thread(new MyThread2(obj1, obj2),"S2");
		t1.start();
		t2.start();
	}
	
	
	
	
}

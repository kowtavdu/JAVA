package com.java.garbage;

class ThreadTest1 implements Runnable{
	private Object obj1;
	private Object obj2;
	
	ThreadTest1(Object ob1, Object ob2 ){
		this.obj1 = ob1;
		this.obj2 = ob2;
	}
	
	public void test(){
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void method1(){
		synchronized (obj1) {
			System.out.println("Aqquired lock on integer class"+Thread.currentThread().getName());
			test();
			synchronized (obj2) {
				System.out.println("Aqquired lock on string class"+Thread.currentThread().getName());
			}
		}
	}
	
	public void method2(){
		synchronized (obj1) {
			System.out.println("Aqquired lock on string class"+Thread.currentThread().getName());
			test();
			synchronized (obj2) {
				System.out.println("Aqquired lock on integer class"+Thread.currentThread().getName());
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			method1();
			method2();
	}
}


public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		Object O1 = new Object();
		Object O2 = new Object();
		Thread t = new Thread(new ThreadTest1(O1,O2),"K1");
		t.start();
		Thread.sleep(5000);
		Thread t2 = new Thread(new ThreadTest1(O1,O2),"K2");
		t2.start();
		System.out.println("After Methid call");
	}
}

package com.java.garbage;

class syncThread implements Runnable{
    private Object obj1;
    private Object obj2;
    
    syncThread(Object obj1, Object obj2){
    	this.obj1 = obj1;
    	this.obj2 = obj2;
    }
    private void work(){
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.println(name+"aquirung lock on object"+obj1);
		synchronized (obj1) {
			System.out.println(name+"aquired lock on object"+obj1);
			work();
			System.out.println(name+"aquiring lock on object"+obj2);
			synchronized (obj2) {
				System.out.println(name+"aquired lock on object"+obj2);
				work();
			}
			System.out.println(name+" released lock on object2"+obj2);
		}
		System.out.println(name+" released lock on object1"+obj1);
		System.out.println(name +"Finished Execution");
		
	}
	
}
public class ThreadDeadLock {

	public static void main(String[] args) throws InterruptedException{
	 Object obj1 = new Object();
	 Object obj2 = new Object();
	 //Object obj3 = new Object();
	 
	 Thread t1 = new Thread(new syncThread(obj1, obj2),"k1");
	 Thread t2 = new Thread(new syncThread(obj2, obj1),"k2");
	 //Thread t3 = new Thread(new syncThread(obj3, obj1),"k3");
	 t1.start();
	 //Thread.sleep(5000);
	 t2.start();
	 //Thread.sleep(5000);
	 /*t3.start();
	 Thread.sleep(5000);*/
	}
}

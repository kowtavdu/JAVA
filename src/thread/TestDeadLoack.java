package thread;

public class TestDeadLoack implements Runnable {

	static Thread childthread;
	
	public void run(){
		try {
			System.out.println("Child Thread waiting for main thread to complete");
			childthread.join();
			System.out.println("Child Thread Execution Complete..");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestDeadLoack.childthread = Thread.currentThread();
		Thread t1 = new Thread(new TestDeadLoack());
		t1.start();
		System.out.println("Main Thread Waiting for child thread to complete");
		t1.join();
		System.out.println("Main Thread Execution Complete..");
	}
	
}

package thread;

public class G4GDeadLock extends Thread{

	static Thread mainThread;
	public void run(){
		System.out.println("Child Thread waiting for main thread to complete");
		
		try{
			mainThread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		G4GDeadLock.mainThread = Thread.currentThread();
		G4GDeadLock thread = new G4GDeadLock();
		thread.start();
		
		System.out.println("Main Thread Waiting for child thread to complete");
		thread.join();
		System.out.println("Main Thread Execution Complete..");
	}
}

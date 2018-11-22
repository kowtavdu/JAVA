package thread;

import java.lang.Thread.UncaughtExceptionHandler;



class Server implements Runnable{
	private volatile Boolean tStop = false; 
	@Override
	public void run(){
		while(tStop!=true){
			System.out.println("-----Start excuting thread");	
		}
		System.out.println("----Stopping thread------");
		throw new RuntimeException();
	}
	
	public void threadStop(){
		tStop = true;
	}

	
	
	
}

public class StopThread {
   public static void main(String[] args) throws InterruptedException {
	
	   Server s = new Server();
	   Thread t = new Thread(s);
	   //t.setUncaughtExceptionHandler(new Test());
	   t.start();
	   Thread.sleep(100);
	   s.threadStop();
	   System.out.println("FINALLY THREAD HAS STOPPED");
   }	
}

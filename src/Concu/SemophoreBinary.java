package Concu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


class Printer{
	private static final int MAX_PERMIT = 1;
	   private final Semaphore semaphore = new Semaphore(MAX_PERMIT, true);
	   public void print(String jobName) {
	          try {
			semaphore.acquire();
			System.out.println("Printing Job: "+ jobName);				
		        Thread.sleep(2000);
			System.out.println("Finished Job: "+ jobName);	
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }finally {
		        semaphore.release();
		  }
	   }
}
class Job implements Runnable {
    private Printer printer;
    private String jobName;

	@Override
	public void run(){
		System.out.println(" JOb Sent to Printer "+jobName);
		printer.print(jobName);
	}

	public Job(Printer printer, String jobName) {
		// TODO Auto-generated method stub
		this.printer = printer;
		this.jobName = jobName;
	}
	
}
public class SemophoreBinary {

	public static void main(String args[]){
		//System.out.println("HI I am here..");
		final int threadCount = 5;
		final ExecutorService ec = Executors.newFixedThreadPool(threadCount);
		final Printer printer = new Printer();
		for (int i=1; i<=threadCount;i++){
			ec.execute(new Job(printer, "Job-"+i));
		}
		ec.shutdown();
	}
}

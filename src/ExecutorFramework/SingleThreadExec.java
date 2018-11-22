package ExecutorFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	String taskName;
	public String getTaskName() {
		return taskName;
	}


	Task(String taskName){
		this.taskName = taskName;
	}
	
	
	public void run(){
		
		try {
			System.out.println("----Started----");
			System.out.println("Thread "+Thread.currentThread().getName() + " Name: "+taskName);
			System.out.println("----Ended----");
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class SingleThreadExec {

	public static void main(String[] args) {
		ExecutorService ec = Executors.newFixedThreadPool(5);
		for (int i=1; i<=15; i++){
			ec.execute(new Task("Name-"+i));
		}
		ec.shutdown();
	}
}

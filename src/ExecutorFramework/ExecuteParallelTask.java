package ExecutorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task1 implements Runnable{

	/*String threadName;
	
	public String getThreadName(){
		return threadName;
	}
	
	Task1(String task){
		this.threadName = task;
	}*/
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("called in task1 : "+Thread.currentThread().getName());
	}
	
}

class Task2 implements Runnable{
	/*String threadName;
	Task2(String task){
		this.threadName = task;
	}
	
	public String getThreadName(){
		return threadName;
	}*/
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("called in task2 : "+Thread.currentThread().getName());
	}
}

class Task3 implements Runnable{
	/*String threadName;
	
	public String getThreadName(){
		return threadName;
	}
	
	Task3(String task){
		this.threadName = task;
	}*/
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("called in task3 : "+Thread.currentThread().getName());
	}
}

class MultipleRunnable implements Runnable{
	private final List<Runnable> runnable;
	public MultipleRunnable(List<Runnable> runnables){
		this.runnable = runnables;
	}
	
	public void run(){
		int i=1;
		while(true){
			for(Runnable run: runnable){
				new Thread(run).start();
				i++;	
			}
			
			if (i==10)
				break;
		}
		
	}
}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.println(r.toString()+ " : I've been Rejected ! ");
	}
	
}

public class ExecuteParallelTask {

	public static void main(String[] args) {
	
		  BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
		  RejectedExecutionHandler rej = new RejectedExecutionHandlerImpl();
		  ThreadPoolExecutor exe = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, workQueue, rej);
		  exe.prestartAllCoreThreads();
		  List<Runnable> taskGroup = new ArrayList<Runnable>();
		  taskGroup.add(new Task1());
		  taskGroup.add(new Task2());
		  taskGroup.add(new Task3());
		  workQueue.add(new MultipleRunnable(taskGroup));	  
	}
}

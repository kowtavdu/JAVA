package ExecutorFramework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class DemoTask implements Runnable {
	String taskName;
	public String getTaskName() {
		return taskName;
	}
	DemoTask(String task){
		this.taskName = task;
	}
	
	@Override
	public void run(){
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executting task "+taskName);
	}
	
	
}


/*class CustomThreadPooolExecutor extends ThreadPoolExecutor{

	public CustomThreadPooolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		
	}
	
	@Override
	protected void beforeExecute(Thread t, Runnable r){
		super.beforeExecute(t, r);
	}
	
	protected void afterExecute(Runnable r, Throwable t){
		super.afterExecute(r, t);
	}
}*/


class BlockingThreadPoolExecutor extends ThreadPoolExecutor{

	private final Semaphore sem;
	
	public BlockingThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		sem = new Semaphore(corePoolSize+50);		
	}
	
	@Override
	public void beforeExecute(Thread t, Runnable r){
		super.beforeExecute(t, r);
	}
	
	public void afterExecute(Runnable r, Throwable t){
		super.afterExecute(r, t);
		if(t!=null){
			t.printStackTrace();
		}
		sem.release();
	}
	
	@Override
	public void execute(final Runnable task){
		
		boolean acquired = false;
		while(!acquired){
			try{
				sem.acquire();
				acquired = true;
			} catch(final InterruptedException e){
				e.printStackTrace();
			}
			} //while(!acquired);
			try{
				super.execute(task);
			} catch(RejectedExecutionException e){
				System.out.println("Task Rejected");
				sem.release();
				throw e;
			}
		
		
	}
}

public class ThreadPoolDemo {

	public static void main(String[] args) {
		/*ThreadPoolExecutor th = new ThreadPoolExecutor(10, //core Pool Size
														50, //maximumPoolSize 
														100, //keepAlivenTime 
														TimeUnit.MILLISECONDS, //unit 
														new LinkedBlockingQueue<Runnable>(), //working Queue 
														new ThreadPoolExecutor.CallerRunsPolicy());*/
		//Runnable [] list = {new Worker("One"), new Worker2("two"), new Worker3("three"), new Worker4("four"),new Worker5("five")};
		
		Integer threadCouInteger = 0;
		BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>(50);
		BlockingThreadPoolExecutor exec = new BlockingThreadPoolExecutor(10,//corePool Size
				                                                    20, //Maximum Pool Size
				                                                    5000, //KeepAliveTime
				                                                    TimeUnit.MILLISECONDS, //Unit
				                                                    blockingQueue //working Queue
				                                                       );
		exec.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
				System.out.println("Demo Task Rejected: "+((DemoTask)r).getTaskName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Lets Add another time "+((DemoTask)r).getTaskName());
				exec.execute(r);
			}
		});
		
		//lets start all core thread initially
		exec.prestartAllCoreThreads();
		while(true){
			threadCouInteger++;
			//Adding Thread one by One
			exec.execute(new DemoTask(String.valueOf(threadCouInteger)));
			if(threadCouInteger==1000)
				break;
		}
		
	}
}

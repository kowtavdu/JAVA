package Concu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

class BlockingQueue<Type>{
	private Queue<Type> queue= new LinkedList<Type>();
	private int EMPTY=0;
	private int MAX_TASK_IN_QUEUE = -1;
	
	public BlockingQueue(int size){
		this.MAX_TASK_IN_QUEUE = size;
	}
	
	public synchronized void enqueue(Type task) throws InterruptedException{
		while(this.queue.size() == this.MAX_TASK_IN_QUEUE){
			wait();
		}
		if(this.queue.size() == EMPTY){
			notifyAll();
		}
		this.queue.offer(task);
	}
	
	public synchronized Type dequeue() throws InterruptedException{
		while(this.queue.size() == EMPTY){
			wait();
		}
		while(this.queue.size() == this.MAX_TASK_IN_QUEUE){
			notifyAll();
		}
		return this.queue.poll();
	}
}

class TaskExecutor implements Runnable{
	BlockingQueue<Runnable> queue;
	public TaskExecutor(BlockingQueue<Runnable> queue){
		this.queue = queue;
	}
	@Override
	public void run(){
		try{
		while(true){
			String name = Thread.currentThread().getName();
			Runnable task  = queue.dequeue();
			System.out.println("Task Started By Thread"+name);
			task.run();
			System.out.println("Task Finished By Thread"+name);
		}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

/**
 * 
 * Threadpool class creates numbers of TaskExecutor instances.
	TaskExecutor class will be responsible for executing the tasks
	ThreadPool class exposes one method submitTask.
	submitTask method will be called by task generating program, to submit a task to threadPool.
 *
 */
class ThreadPool{
	BlockingQueue<Runnable> queue;
	public ThreadPool(int queueSize, int nThreads){
		queue = new BlockingQueue<>(queueSize);
        String threadName = null;
		TaskExecutor task = null;
		for (int i=0;i<nThreads;i++){
			threadName = "Thread "+i;
			task = new TaskExecutor(queue);
			Thread thd = new Thread(task,threadName);
			thd.start();
		}
	}
	public void submitTask(Runnable task) throws InterruptedException{
		System.out.println("INSIDE submitTask");
		queue.enqueue(task);
	}
}

class TestTask implements Runnable{
	private int number;
	public TestTask(int number){
		this.number = number;
	}
	@Override
	public void run(){
		System.out.println("Start Executing task number: "+number);
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Ending Executing task number: "+number);
	}
}
public class CustomThreadPool {

	public static void main(String args[]) throws InterruptedException{
		AtomicInteger atomicInteger = new AtomicInteger();
		System.out.println(atomicInteger.getAndAdd(10));
		System.out.println(atomicInteger.addAndGet(10));
		
		
		System.out.println("HI I AM HERE>>>>");
		ThreadPool thp = new ThreadPool(3, 4);
		for (int taskNumber=1; taskNumber<7;taskNumber++){
			System.out.println("INSIDE LOOP ---------"+taskNumber);
			TestTask task = new TestTask(taskNumber);
			task.run();
			thp.submitTask(task);
		}
	}
}

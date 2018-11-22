package ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTask implements Callable{
	String taskName;
	public String getTaskName() {
		return taskName;
	}

	MyTask(String taskName){
		this.taskName = taskName;
	}
	
	public Object call() throws InterruptedException{
     System.out.println("called inside Callable Method-----"+Thread.currentThread().getName()+"----"+taskName);
     pauseThread();
     return taskName;
	}
	public void pauseThread() throws InterruptedException{
		Thread.sleep(1000);
	}
}

public class SingleThreadExecSubmitCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		for(int i=1; i<10;i++){
		Future f = es.submit(new MyTask("MyTaskN"+i));
		System.out.println("Future Value "+f.get());
		}
		es.shutdown();
	}
}

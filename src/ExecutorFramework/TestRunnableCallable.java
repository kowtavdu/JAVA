package ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*class MyTask3 implements Runnable{
	String taskName;
	public String getTaskName() {
		return taskName;
	}

	MyTask3(String taskName){
		this.taskName = taskName;
	}
	
	
	public void run(){
		System.out.println(""+Thread.currentThread().getName()+"----"+taskName);
	}
}*/

interface Test{
	default String hello(){
		return "Chup be ";
	}
	
   public abstract String hello(String name);	
} 

public class TestRunnableCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*Thread t = new Thread(new MyTask3("Saurabh"));
		t.start();*/
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		for (int i=0; i<5;i++ ){
			Callable task = ()-> {
				System.out.println("@@@@@@@@@@@@ "+Thread.currentThread().getName()+"---");
				return "Hello";
			};
			Future f = es.submit(task);
			System.out.println(f.isDone()+"--------"+f.get());		
		}
		
		/*Test t = (name) -> {
			System.out.println("Hello Saurabh i am here");
			return name;
		};
		
		System.out.println("111111111111 "+t.hello());
		System.out.println("222222222222 "+t.hello("saurabh"));*/
	}
}

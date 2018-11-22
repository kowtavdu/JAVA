package ExecutorFramework;

import java.lang.Thread.UncaughtExceptionHandler;

class ExceptionHandler implements UncaughtExceptionHandler{
	public void uncaughtException(Thread t, Throwable e){
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread Status: %s\n", t.getState());
		new Thread(new MyTask1()).start();
	}
}

class MyTask1 implements Runnable{
	@Override
	public void run(){
		Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.parseInt("456"));
		System.out.println(Integer.parseInt("abc"));
		System.out.println(Integer.parseInt("789"));
	}
}

public class RestartThreadExecution {

	public static void main(String[] args) {
		Thread t = new Thread(new MyTask1());
		t.start();
	}
}

package thread;

import java.lang.Thread.UncaughtExceptionHandler;

class MyThreadException implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
	   System.out.println("Exception completed");
	   throw new RuntimeException();
	   
		
	}
	
	
}

class Test implements UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.println("Uncaught SAURABH exception e "+e);
	}
	
}


class ThreadExcep {

	public static void main(String[] args) {
		MyThreadException c = new MyThreadException();
		Thread t = new Thread(c);
		t.setUncaughtExceptionHandler(new Test());
		t.start();
		
	}
}

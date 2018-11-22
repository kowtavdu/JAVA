class Producer extends Thread{
	
	public void run(){
		for (int i=0;i<5;i++){
			System.out.println("I am producer: Produced "+i);
			Thread.yield();
		}
	}
}

class Consumer extends Thread{
	public void run(){
		for (int i=0;i<5;i++){
			System.out.println("I am consumer: Consumed "+i);
			Thread.yield();
		}
	}
}


class JoinExmple{
	
}


public class SampleThread1 {

	public static void main(String args[]) throws InterruptedException{
		System.out.println("HI i am here..");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
			  System.out.println("Thread 1 start working");
			  System.out.println("Thread 1 wait for 2 second");
			  try{
			  Thread.sleep(2000);
			  }catch(InterruptedException e){
				  e.printStackTrace();
			  }
			  System.out.println("Thread 1 task completed");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			  System.out.println("Thread 2 complete");	
			}
		});
		t.start();
		t.join();
		t2.start();
	}
}

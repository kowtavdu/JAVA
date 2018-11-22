package thread;

class Tlocal implements Runnable{

	private ThreadLocal<Integer> tlocal = new ThreadLocal<>();
	@Override
	public void run() {
	
		tlocal.set((int)(Math.random() * 100D));
		try{
			Thread.sleep(2000);
			
		} catch(InterruptedException e){
			
		}
		System.out.println(tlocal.get());
	}
	
}

public class TestThreadLocal {

	public static void main(String[] args) throws InterruptedException {
	    Runnable t = new Tlocal();	
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t1.start();
		t2.start();
		
		/*t1.join();
		t2.join();*/
	}
}

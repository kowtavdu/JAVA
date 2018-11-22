package Concu;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
class Service1 implements Runnable{
	private String name;
	private CyclicBarrier cb;
	Service1(String name, CyclicBarrier cb){
		this.name = name;
		this.cb = cb;
	}
	@Override
	public void run(){
		try {
			System.out.println(Thread.currentThread().getName()+ "is waiting on barrier");
			cb.await();
			System.out.println(Thread.currentThread().getName()+ "is crossed on barrier");	
		} catch(InterruptedException e){
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
       cb.reset();
		
	}
}
public class CyclicBarierExamp {

	public static void main(String args[]){
		System.out.println();
		CyclicBarrier cb = new CyclicBarrier(3 , new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("All parties are arrived barrier lets play");		
			}
		});
		Thread t1 = new Thread(new Service1("--one--",cb));
		Thread t2 = new Thread(new Service1("--two--",cb));
		Thread t3 = new Thread(new Service1("--three--",cb));
		
		t1.start();
		t2.start();
		t3.start();
	} 
}

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class WorkerThread implements Runnable{
	public void run(){
		
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class TestNG {

	private static final Object Object = null;
	public void testHH(int a, int b){
		System.out.println("@@@@@@INTEGER "+a+" ########## "+b);
	}
	/*public void testHH(Integer d, Integer e){
		System.out.println("@@@@@@LONG111 "+d+" ########## "+e);
	}*/
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newFixedThreadPool(10);
		/*IntStream.range(1, 6).forEach(
				i -> System.out.println(i)
				);*/
		for(int i=0;i<20;i++){
			Runnable r  = new WorkerThread();
			exec.execute(r);
		}
		exec.shutdown();
		while(!exec.isTerminated()){}
		System.out.println("Finished AllThread");
		/*//int a = null;
		Map m = new HashMap<Integer,Integer>();
		m.put(1, 2);
		m.put(m.put(1, 3), 4);
		Integer a1 = null;
		System.out.println("Hello i am fine...."+m);
		
		TestNG yy = new TestNG();*/
		//yy.testHH(null, null);
	}
}

package ExecutorFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*class CallableTask implements Callable<String>{

	

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return message;
	}
	
}*/

public class TestInvokeAll {
	
	/*Callable<String> str = (s) -> System.out.println(s);
	
	str.method1("abc");*/

	/*public void getQueryData(List<String> tabesNames){
		Set<Callable<String>> callable = new HashSet<Callable<String>>();
		for(String tbl:tabesNames){
			Callable r1 = (tbl) -> {
				System.out.println("My Runnable");
				return name;
			};
		}
		
		
	}*/
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService es = Executors.newFixedThreadPool(3);
		List<String> tables = Arrays.asList("tbl1","tbl2","tbl3");
		Set<Callable<String>> callable = new HashSet<Callable<String>>();
		for(String table : tables){
			Callable<String> obj = () -> {
				Thread.sleep(100);
				return "sss"+table;
						};
						callable.add(obj);			
		}
		
		/*List<Future<String>> futures = es.invokeAll(callable);
		List<String> tt = futures.stream(tt -> tt.get());
		for(Future<String> fs: futures){
			System.out.println("Furture Object "+fs.get());
		}*/
		es.shutdown();
		
		
		
		/*callable.add(new CallableTask("Hello 1"));
		callable.add(new CallableTask("Hello 2"));
		callable.add(new CallableTask("Hello 3"));
		
		List<Future<String>> futures = es.invokeAll(callable);
		for(Future<String> fs: futures){
			System.out.println("Furture Object "+fs.get());
		}
		es.shutdown();*/
	}
}

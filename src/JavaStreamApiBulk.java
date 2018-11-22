import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class JavaStreamApiBulk {

	public static void main(String args[]){
		System.out.println("Hello");
		
		List<Integer> lst = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> tr = lst.stream();
		tr.forEach(p -> System.out.println(p));
		
	}
}

package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForeachApp {

	public static void main(String[] args) {
	System.out.println("Called in foreach ---------");
	
	/*List<String> ll = new ArrayList();
	ll.add("aa");
	ll.add("bb");
	ll.add("cc");
	//System.out.println("@@@@@@@@@@@ "+ll);
	for (String value : ll) {
		System.out.println("ll -> "+value);
	}
	
	Consumer<Integer> additionOfTwo = (number) -> {
		number = number+2;
	};
	
	List<Integer> number = new ArrayList();
	number.add(1);number.add(2);number.add(3);number.add(4);number.add(5);
	number.forEach(additionOfTwo);
	System.out.println("@@@@@Number@@@@ "+number);
	
	Map<Integer,String> mp = new HashMap<>();
	mp.put(1, "saurabh");
	mp.put(2, "Gaurabh");
	mp.put(3, "Abhishek");
	mp.put(4, "Mohan");
	
	mp.forEach((k,v) -> System.out.println(k+"@@@@@"+v));
	Consumer<String> consName = (name) -> {
		System.out.println("KKKKK"+name);
	};
	
	ll.forEach(consName);
	
	System.out.println("@@@@@@@@@@@111 "+ll);
	ll.stream().filter(name -> name.startsWith("aa")).forEach(
			name -> System.out.println("KKKKKKK"+name)
			);
	
	System.out.println("@@@@@@@@@@@111 "+ll);*/
	List<Integer> number = new ArrayList();
	number.add(1);number.add(2);number.add(3);number.add(4);number.add(5);
	number.stream().reduce((x,y)-> x+y);
	System.out.println("@@@@@@@@@@@111 "+number.stream().reduce((x,y)-> x+y));
	System.out.println("@@@@@@@@@@@222 "+number.stream().reduce(Integer::sum));
	System.out.println("@@@@@@@@@@@222 "+number.stream().reduce(5,(x,y)->x+y));
	}
}

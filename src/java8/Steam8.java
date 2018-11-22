package java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Steam8 {

	public static void main(String[] args) {
		
		int [] array = {1,2,3};
		System.out.println(array[2]);
		
	   Arrays.stream(array).map(a -> a*2+1);
	   Arrays.stream(array).map(a -> a*2+1).average().ifPresent(System.out::println);
	   
	  /*////1 
	   Arrays.asList("a1","a2","a3")
	   .stream()
	   .findFirst()
	   .ifPresent(System.out::println);
	   
	 /////2
	   Stream.of("a1","a2","a3")
	   .findFirst()
	   .ifPresent(System.out::println);
	   
	   IntStream.range(1, 10)
	   .map(n -> n * 2)
	   .forEach(System.out::println);
	   
	   ////3
       Stream.of("a1","a2","a3")
       .map(a -> a.substring(1))
       .mapToInt(Integer::parseInt)
       .max()
       .ifPresent(System.out::println);
       
       ////4
	   IntStream.range(1, 4)
	   .mapToObj(i -> "a"+i)
	   .forEach(System.out::println);*/
	   
	   ////5
	   Stream.of("d2","a2","b1","b3","c")
	   .filter(s -> {System.out.println("filter :"+s);
	   return true;
	   });
	   
	////6
	   Stream.of("d2","a2","b1","b3","c")
	   .filter(s -> {System.out.println("filter :"+s);
	   return true;
	   }).forEach(s -> System.out.println(" for each "+s));
	}
}

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

class CheckPrime{
	protected static boolean isPrime(int number) {		
		/*if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;*/
		
		/*return number > 1
				&& IntStream.range(2, number).noneMatch(
						index -> number % index == 0);*/
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1
				&& IntStream.range(2, number).noneMatch(
						isDivisible);
	}
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
	public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
				.filter(i -> i%2!=0) 		//Predicate is functional interface and
				.filter(i -> i>3)	// we are using lambdas to initialize it
				.filter(i-> i<11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}
	
}

interface FuncExpre{
 int hello();	
}
interface FuncExpreStr{
	 String hello(Integer i);	
	}
interface FuncExpreStrVoid{
	 void hello();	
	}
public class FunctionalAndLambda {
	
	public static void main(String args[]){
		Runnable r = () -> {};                     // No parameters; void result

		FuncExpre h = () -> {
			  if (true) return 10;
			  else {
			    int result = 15;
			    for (int i = 1; i < 10; i++)
			      result *= i;
			    return result;
			  }
			};           
		FuncExpre h2 = () -> { return 42; };         // No parameters, block body with return
		
		/*Runnable r = () -> System.out.println("Hello Moto ");
		System.out.println(IntStream.range(2, 3).noneMatch(isDivisible));*/
		//System.out.println("RRRRRRRRR "+CheckPrime.isPrime(4));
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 7,8);  
		System.out.println("RRRRRRRRR "+CheckPrime.sumWithCondition(numbers, i -> i>5 && i%2==0));
		   
	}
}

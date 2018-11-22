package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericUpperBound {

	public static Double sum(List<? extends Number> list){
		double sum = 0;
		for(Number n :list){
			sum+= n.doubleValue();
		}
		return sum;
		
	}
	public static void main(String[] args) {
		
		List<Long> intList = new ArrayList<>();
		intList.add(1L);
		intList.add(2L);
		intList.add(3L);
		intList.add(4L);
		
		System.out.println("Result of Sum : "+sum(intList));
	}
}

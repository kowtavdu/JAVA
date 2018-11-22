package Feb7;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

interface TestInterface {
	
	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}
}

class HelloInterface implements TestInterface {	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
}

interface TestN {
	void method1(String str);

	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}

	static void print(String str) {
		System.out.println("Printing " + str);
	}
}


public class FunctionInt {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
			   System.out.println("KKKKKKKKKKKk "+t);	
			}
		});
		
	}
}

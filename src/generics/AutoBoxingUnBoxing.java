package generics;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingUnBoxing {

	public static void myMethod(Integer num){
		System.out.println(num);
	}
	public static void main(String[] args) {
		//Autoboxing converting primitive type to Object of wrapper class is called AutoBoxing		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		myMethod(2);
		myMethod(new Integer(2));
		
		Integer myInt = (int)2;
		int myInt1 = 2;
		int myInt2 = new Integer(2);
		System.out.println(myInt+"----"+myInt1+"---------"+myInt2);
		
		//--------Example AutoBoxing----------
		
		Integer int3 = 23;
		Long int4 = 2L;
		
		List<Integer> int5 = new ArrayList<Integer>();
		List int6 = new ArrayList<Integer>();
		int5.add(22);
		
		
		//--------Example UnBoxing----------
		
		Integer int7 = new Integer(5);
		int num8 = int7;
		
		ArrayList int8 = new ArrayList();
		//int num9 = int8.get(0);
	}
}

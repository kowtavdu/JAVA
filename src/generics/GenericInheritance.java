package generics;

public class GenericInheritance {

	public static class MyClass<T>{}
	public static void main(String[] args) {
		
		String str = "ABC";
		Object obj = new Object();
		obj = str;
		
		MyClass<String> myClass1 = new MyClass<>();
		MyClass<Object> myClass2 = new MyClass<>();
		//myClass2 = myClass1; //complilation error
		obj = myClass2;
	}
}

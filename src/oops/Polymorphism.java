package oops;

class Animal{
	void getname(){
	System.out.println("JANWAR");	
	}
	public String getObject(){
		System.out.println("called in Animal getObject");
		return "Animal Object";
	}
	protected String getAge(int age){
		return "Age of animal "+age;
	}
	
	public static String getAge(int age, float age1){
		return "Age of animal 22 "+age;
	}
	 
}
//byte -> sort -> int -> long -> float -> double
class Dog extends Animal{
	public String getAge(int age){
		return "Age of Dog "+age;
	}
	public String getObject(){
		System.out.println("called in DOg getObject");
		return "Dog Object";
	}
	void hello(){
		System.out.println("Called in Animal Hello");
	}
}
public class Polymorphism {

	public static void main(String[] args) {
		/*Animal m = new Dog();
		System.out.println("aaaaaa "+m.getAge(5));*/
		
		Animal m1 = new Animal();
		//System.out.println("aaaaaa "+m1.getAge(5));
		System.out.println("aaaaaa "+m1.getAge(5,3.5f));
		/*m.getObject();
		m.getname();*/
		
		
		//m.getObject();
		
	}
}

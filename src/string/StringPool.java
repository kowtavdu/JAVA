package string;

import java.util.ArrayList;
import java.util.List;
class Hero{}
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
public class StringPool {

	public static void printData(List<?> list){
		for(Object obj:list){
			System.out.println("--------"+obj);
		}
	}
	public static void printAnimal(List <? super Animal> list){
		/*for (Animal a:list){
			System.out.println("---"+a);
		}*/
	} 
	public static <T> T sum(List<T> list){
		T sum = null;
		for(T obj: list){
			sum = obj;
		}
		return sum;
	}
	public static void main(String args[]){
		/*String s1 = "saurabh";
		String s2 = new String("saurabh").intern();
		System.out.println(s2 == s1);*/
		List l1 = new ArrayList();
		l1.add(new Dog());l1.add(new Hero());
		printAnimal(l1);
	}
}

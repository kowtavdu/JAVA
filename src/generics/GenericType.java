package generics;
public class GenericType<T> {

	private T t;

	public T getT() {
		return this.t;
	}

	public void setT(T t1) {
		this.t = t1;
	}
	public static void main(String[] args) {

		GenericType<String> t = new GenericType<>();
		t.setT("A");
		t.setT("B");
		t.setT("C");
		
		//GenericType t2 = new GenericType();
		GenericType type1 = new GenericType(); //raw type
		type1.setT("Pankaj");
		type1.setT(2);
		
		System.out.println(t.t);
	}
}

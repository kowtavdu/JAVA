package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class Test {
	
}
class Dummy extends Test{
	private int i = new Integer(10);
	private void foo(){
		System.out.println("Called in private method" +i);
	}
	public void foo1(){
		System.out.println("Called in publicss method" +i);
	}
}
public class AccessPrivateMethod {

	public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException, SecurityException{
		System.out.println("HI I M HERE..");
		Dummy obj = new Dummy();
		Class c = obj.getClass();
		int modifiers = c.getModifiers();
		Method  f1 = Dummy.class.getDeclaredMethod("foo");
		//Modifier.isPrivate(modifiers)
		System.out.println("HI I M HERESSSS.."+Dummy.class.getSuperclass());
		//obj.foo1();
		try {
			Method m = Dummy.class.getDeclaredMethod("foo");
			m.setAccessible(true);
			m.invoke(obj);
			Field f = Dummy.class.getDeclaredField("i");
			f.setAccessible(true);
			f.set(obj, 5);
			System.out.println("@@@@@@@@@@@ "+f.get(obj));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package reflection;


import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.print.attribute.HashAttributeSet;

import com.mysql.jdbc.*;

public class TestConcrete {

	public static void main(String args[]) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException{
      //get cannonical class Name		
	  System.out.println("CC");
      Class<?> con = Driver.class; //load jdbc connection driver class
      System.out.println("CCSSSSS"+ con.getCanonicalName());
      Class<?> booleanClass = boolean.class;
      System.out.println("CCSSSSS"+ booleanClass.getCanonicalName());
      Class<?> cDouble = Double.class;
      System.out.println("Double Class name"+ cDouble.getCanonicalName());
      Class<?> cDoubleArray = Class.forName("[D");    		  
      System.out.println("Double Class name "+ cDoubleArray.getCanonicalName());
      Class<?> twoDimmStringArra = String[][].class;
      System.out.println("Two Dimm String Arr "+ twoDimmStringArra.getCanonicalName());
      
      System.out.println("*****************GET SUPER CLASS************");
      Class<?> DriversuperClass = Class.forName("com.mysql.jdbc.Driver").getSuperclass();
      System.out.println("DriversuperClass  " +DriversuperClass);
      
      Class<?>  concreteSuperClass = Class.forName("reflection.Concerete").getSuperclass();
      System.out.println("concreteSuperClass  "+concreteSuperClass);
      
      System.out.println("ObjectSuperClass  "+Object.class.getSuperclass());
      
      System.out.println("IntegerSuperClass  "+Integer.class.getSuperclass());
      
      System.out.println("String [][] SuperClass  "+String[][].class.getSuperclass());
      
      System.out.println("************GET PUBLIC MEMBER CLASS***************");
      
      Class<?>[] clases = Class.forName("reflection.Concerete").getClasses();
      //Class<?>[] clases = Concerete.class.getClasses();
      System.out.println("  classes: "+Arrays.toString(clases));
      
      System.out.println("************GET DECLARED CLASS***************");
      
      Class<?> [] decCLass = Class.forName("reflection.Concerete").getDeclaredClasses();
      System.out.println("decCLass :" +decCLass);
      System.out.println("decCLass :" +Arrays.toString(decCLass));
      
      System.out.println("************GET type Parameters***************");
      
      TypeVariable<?>[] typeParams = Class.forName("reflection.Concerete").getTypeParameters();
      System.out.println("type Variable "+Arrays.toString(typeParams));
      for(TypeVariable<?> t : typeParams)
    	  System.out.print(t.getName()+",");
      
      System.out.println("************GET type Interface***************");
      System.out.println(Arrays.toString(Class.forName("reflection.Concerete").getGenericInterfaces()));
      System.out.println(Arrays.toString(Class.forName("reflection.Concerete").getInterfaces()));
      
      System.out.println("************GET All Public Methods***************");
      System.out.println(Arrays.toString(Class.forName("reflection.Concerete").getMethods()));
      
      System.out.println("************GET All Public Fields***************");
      System.out.println(Arrays.toString(Class.forName("reflection.Concerete").getFields()));
      
      //System.out.println(Class.forName("reflection.Concerete").getField(Concerete.baseIntface));
      System.out.println("Methods : "+Arrays.toString(Class.forName("reflection.Concerete").getMethods()));
      
      System.out.println("Constructors : "+Arrays.toString(Class.forName("reflection.Concerete").getConstructors()));
      
      System.out.println("************GET Field in Class***************");
      java.lang.reflect.Field field = Class.forName("reflection.Concerete").getField("baseIntface");
      Class<?> cla = field.getDeclaringClass(); 
      System.out.println("******GET FIELD*********"+cla.getCanonicalName());
      
      System.out.println("************GET Field Type***************");
      
      java.lang.reflect.Field f = Class.forName("reflection.Concerete").getField("baseIntface");
      Class<?> fieldType = f.getType();
      System.out.println("Field Type CLass "+fieldType.getCanonicalName());
      
      System.out.println("************GET/SET Public Field Value***************");
      
      java.lang.reflect.Field f2 = Class.forName("reflection.Concerete").getField("publicInt");
      Concerete obj = new Concerete(5);
      System.out.println("Field Value : "+f2.get(obj));
      f2.setInt(obj, 9);
      System.out.println("Updated Field Value : "+f2.get(obj));
      
      System.out.println("*********GET/SET Private Field Value************");
      java.lang.reflect.Field f3 = Class.forName("reflection.Concerete").getDeclaredField("privateString");
      f3.setAccessible(true);
      System.out.println("Private Field Value "+f3.get(obj));
      f3.set(obj, "JAI MATA DI");//updated provate Field value
      System.out.println("Get Private Field Value : "+f3.get(obj));
      
      System.out.println("*********GET PUBLIC METHOD************");
      Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
      System.out.println("Method Parameter Type "+Arrays.toString(method.getParameterTypes()));
      System.out.println("GET RETURN Type "+method.getReturnType());
      System.out.println("GET METHOD MODIFIER "+Modifier.toString(method.getModifiers()));
      
      System.out.println("*********INVOKING PUBLIC METHOD************");
      Method method2 = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
      Map<String, String> hm = new HashMap<>(); 
      method2.invoke(hm, "Saurabh","Gwalior");
      System.out.println("Updated HashMap : "+hm);
      
      System.out.println("***********Invoking Private Method*************");
      Method method3 = Class.forName("reflection.BaseClass").getDeclaredMethod("method3", null);
      method3.setAccessible(true);
      method3.invoke(null, null);
      
      System.out.println("***********Initiate Object Using constructor*************");
      Constructor<?> cons = Class.forName("reflection.Concerete").getConstructor(int.class);
      System.out.println("Contrutor Type "+Arrays.toString(cons.getParameterTypes()));
      Object myObj = cons.newInstance(10);
      Method me4 = myObj.getClass().getMethod("method1", null);
      me4.invoke(myObj, null);
      
      Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap").getConstructor(null);
      System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes())); // prints "[]"
      HashMap<String,String> myMap = (HashMap<String,String>) hashMapConstructor.newInstance(null);
      
	}
}

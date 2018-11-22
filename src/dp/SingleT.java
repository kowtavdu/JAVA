package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


//Serializable
/*class MySingleton implements Serializable{
	private MySingleton(){
		if(instance!=null){
		 throw new RuntimeException("create instance with getInstance methd()");
		}
	}
	public static volatile MySingleton instance;
	
	public static MySingleton getInstance(){
		if(instance ==null){
		synchronized (MySingleton.class) {
			if(instance == null){
				instance = new MySingleton();	
			}
		}	
		}
		return instance;
	}
	
	protected Object readResolve(){
		return getInstance();
	}
}*/


//Clonnable
/*class MySingleton implements Cloneable{
	private MySingleton(){}
	public static MySingleton instance;
	
	public static MySingleton getInstance(){
		if(instance ==null){
		synchronized (MySingleton.class) {
			if(instance == null){
				instance = new MySingleton();	
			}
		}	
		}
		return instance;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
		//return super.clone();
	}
}*/


/*class MySingleton implements Cloneable{
	private MySingleton(){}
	public static MySingleton instance;
	
	public static MySingleton getInstance(){
		if(instance ==null){
		synchronized (MySingleton.class) {
			if(instance == null){
				instance = new MySingleton();	
			}
		}	
		}
		return instance;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
		//return super.clone();
	}
}*/


class Singleton{
	private Singleton(){}
	public static Singleton getObject(){
		return new Singleton();
	}
}

enum MySingleton
{
    INSTANCE;

    private final Singleton single;

    MySingleton()
    {
    	System.out.println("KKKKKKKKKKKKKKK");
        // Initialize the connection
    	single = Singleton.getObject();
    }

    // Static getter
    public static MySingleton getInstance()
    {
        return INSTANCE;
    }
    public Singleton getConnection()
    {
        return single;
    }
    
}
//Reflection


public class SingleT {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Hello I am Here");
		
		System.out.println("Hello I am Here-----"+MySingleton.INSTANCE.getConnection().hashCode());
		//System.out.println("Hello I am Here-----"+MySingleton.INSTANCE.getConnection().hashCode());
		
		/*//serialize
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.ser"));
		out.writeObject(MySingleton.getInstance());
		out.close();
		
		//deserialize 1
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
		MySingleton obj = (MySingleton) ois.readObject(); 
		System.out.println("Second Instance : "+obj.hashCode());
		
		//deserialize 2
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("test.ser"));
		MySingleton obj1 = (MySingleton) ois1.readObject(); 
		System.out.println("Second Instance : "+obj1.hashCode());*/
		
		
		/*MySingleton secondObject = (MySingleton) MySingleton.getInstance().clone();
		System.out.println("Second Instance : "+secondObject.hashCode());*/
		
		Constructor[] constructors = MySingleton.class.getDeclaredConstructors();
		MySingleton instanceTwo = null;
		for(Constructor con:constructors){
			con.setAccessible(true);
			instanceTwo = (MySingleton)con.newInstance();
			break;
		}
		
		System.out.println("@@@@@@@@@@@@@ "+instanceTwo.getInstance().hashCode());
	}
	
}

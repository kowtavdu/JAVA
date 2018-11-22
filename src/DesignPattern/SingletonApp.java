package DesignPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/*
 * This approach has one drawback. Here instance is created even though 
 * client application might not be using it. This might be a considerable issue 
 * if your singleton class in creating a database connection or creating a socket. 
 * This may cause the memory leak problem. The solution is to create the new instance of the class, 
 * when needed. This can be achieved by Lazy Initialization method.
 */
//Eager initialization
class Singleton {
	private static volatile Singleton getInstance = new Singleton();
	private Singleton(){}
	private static Singleton getInstance(){
		return getInstance;
	}
}

//Lazy initialization
class Singleton2{
	private static Singleton2 instance = null;
	private Singleton2(){}
	public static Singleton2 getInstance(){
		if(instance==null){
			instance =  new Singleton2();
		}
		return instance;
	}	
}

//prevent from refection
class Singleton3{
	
	private Singleton3(){
		if(instance!=null){
			try {
				throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static Singleton3 instance = null;
	
	public static Singleton3 getInstance(){
		if(instance == null){
			instance = new Singleton3();
		}
		return instance;
	}
}

//to Make SIngleton Thread Safe make it synchronized or Double Chedked it
//-: Doouble Check Example
class Singleton4{

	private Singleton4(){
		if (instance !=null){
			throw new  RuntimeException("Instance already exists in JVM");
		   
		}
	}

	private static volatile Singleton4 instance = null;
	public static Singleton4 getInstance(){
		if(instance==null){
			synchronized (Singleton4.class) {
				if(instance == null){
					instance = new Singleton4();
				}	
			}
		}
		return instance;
	}
}

//Making Singleton Safe from Serialization
class Singleton5 implements Serializable{
	private Singleton5(){
		if (instance !=null){
			throw new RuntimeException("Singleton Instance already Exists");
		}
	}
	private static volatile Singleton5 instance = null;
	public static Singleton5 getInstance(){
		if(instance ==null)
		synchronized (Singleton5.class) {
			if(instance == null){
				instance = new Singleton5();
			}	
		}
		return instance;
	}
	
	public Object readResolve(){
		return instance;
	}
}
//Implement using Enum

class Connection{}
class Db{
	public static Connection T1(){
		return new Connection();
	};
}
enum Singleton6
{
    INSTANCE;

    // instance vars, constructor
    private final Connection connection;

    Singleton6()
    {
        // Initialize the connection
        connection = Db.T1();
    }

    // Static getter
    public static Singleton6 getInstance()
    { 
    	return INSTANCE;
    }

    public Connection getConnection()
    {
        return connection;
    }
}
public class SingletonApp {

	public static void main(String[] args) {
		System.out.println("@@@@@@@@@@@ "+Singleton6.INSTANCE.hashCode());
		System.out.println("@@@@@@@@@@@ "+Singleton6.INSTANCE.hashCode());
		
// 1. Check with reflcection
		/*Singleton3 instance1 = Singleton3.getInstance();
        //Create 2nd instance using Java Reflection API.
		Singleton3 instance2 = null;
        try {
         Class<Singleton3>	tt = Singleton3.class;
         Constructor<Singleton3> con= tt.getDeclaredConstructor();
         con.setAccessible(true);
         instance2 = con.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());*/
        
        
 //check Singleton ThreadSafe or Not
        
          /*Thread t1 = new Thread(new Runnable(){
        	@Override
        	public void run(){
        		Singleton4 instance3 = Singleton4.getInstance();
        		System.out.println("instance 3 hascode "+instance3.hashCode());
        	}
        });
		
        Thread t2 = new Thread(new Runnable(){
        	@Override
        	public void run(){
        		Singleton4 instance4 = Singleton4.getInstance();
        		System.out.println("Instance 4 value "+instance4.hashCode());
        	}
        });        
        t1.start();
        t2.start();*/
        
//Serialization call		
		 try {
			 Singleton5 instance1 = Singleton5.getInstance();
	            ObjectOutput out = null;

	            out = new ObjectOutputStream(new FileOutputStream("filename1.ser"));
	            out.writeObject(instance1);
	            out.close();

	            //deserialize from file to object
	            ObjectInput in = new ObjectInputStream(new FileInputStream("filename1.ser"));
	            Singleton5 instance2 = (Singleton5) in.readObject();
	            in.close();

	            System.out.println("instance1 hashCode=" + instance1.hashCode());
	            System.out.println("instance2 hashCode=" + instance2.hashCode());

	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			
			
		
		
	}
}

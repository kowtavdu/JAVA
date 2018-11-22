package thread;


class Connection{
	
}

class DB{
	public static Connection getConnection(){
		return new Connection();
	}
}
enum Singleton{
	  
	  INSTANCE;

	  private final Connection conn; 
	  
	  Singleton(){
		  System.out.println("1111111111111111");
		  conn = DB.getConnection();
	  }
	  
	  public static Singleton getInstance(){
		  return INSTANCE;
	  } 
	  
	  public Connection getConnection(){
		  return conn;
	  }
} 
  


public class SingletonEnum {

	public static void main(String[] args) {
		System.out.println(Singleton.INSTANCE);
		System.out.println(Singleton.INSTANCE);
		System.out.println(Singleton.INSTANCE);
		System.out.println(Singleton.INSTANCE);
		/*final Singleton s = Singleton.getInstance();
		System.out.println(s.hashCode());
		System.out.println(s.hashCode());
		System.out.println(Singleton.INSTANCE.hashCode());
		System.out.println(Singleton.INSTANCE.getConnection().hashCode());
		System.out.println(DB.getConnection().hashCode());*/
		
		/*if(Singleton.INSTANCE.getConnection().hashCode()==DB.getConnection().hashCode()){
			
		}else{
			System.out.println("NT ER");
		}*/
	}
}

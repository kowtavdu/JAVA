package ClassLoader;


public class CCLoader {

	public static void main(String args[]) throws ClassNotFoundException{
		
		//System.out.println("Map Class Loader "+java.util.Map.class.getClassLoader());
		//System.out.println("class loader for DNSNameService: "+ Concerete.class.getClassLoader());
		//System.out.println("class loader for DNSNameService: "+ Class.forName("sun.net.spi.nameservice.dns.DNSNameService").getClassLoader());
	    System.out.println("Driver class Loader: "+Class.forName("com.mysql.jdbc.Driver").getClassLoader());	
		
	}
}

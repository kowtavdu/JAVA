package reflection;

interface baseInterface{
	public String baseIntface = "SA";
	void method1();
	int method2(String str);
}

class PrivateObject {

	  private String privateString = null;

	  public PrivateObject(String privateString) {
	    this.privateString = privateString;
	  }
	}

class BaseClass {
	public int baseInt;
	private static void method3(){
		System.out.println("called in static method 3");
	}
	public int method4(){
		System.out.println("called in int method4");
		return 0;
	}
	
	public static int method5(){
		System.out.println("Called in static int method5");
		return 0;
	}
	void method6(){
		System.out.println("called in void method6");
	}
	public class BaseInnerClass{}
	public enum BaseClassMemberEnum{}
}


public class Concerete extends BaseClass implements baseInterface  {
	public int publicInt;
	private String privateString = "private string";
	protected boolean protectedBoolean;
	Object defaultObject;
	
	public Concerete(int i){
		this.publicInt = i;
	}
	// inner classes
		public class ConcreteClassPublicClass{}
		private class ConcreteClassPrivateClass{}
		protected class ConcreteClassProtectedClass{}
		class ConcreteClassDefaultClass{}
		
		//member enum
		enum ConcreteClassDefaultEnum{}
		public enum ConcreteClassPublicEnum{}
		
		//member interface
		public interface ConcreteClassPublicInterface{}

	
	@Override
    public void method1(){
    	System.out.println("called void method1");
    }
    @Override
    public int method2(String str){
    	
    	return 0;
    }
    @Override
    public int method4(){
     return 1;	
    }
    
    public int method5(int i){
    	return 0;
    }
    /*public static void main(String args[]){
		System.out.println("Hello i am here");
		
	}
	public void main(String args[]){
		System.out.println("Hello i am here");
		method1();
	}*/
}

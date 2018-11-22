class Hello {
	
	public void test(int i){
		if (i==0){
			return;
		}else{
			System.out.println("SSSSSSS");
		}
	}
}
public class Sample {

	public static void main(String[] args) {
	
		Hello h = null;
		System.out.println(h);
		Hello h2 = new Hello();
		h2.test(0);
	}
}

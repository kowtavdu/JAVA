@FunctionalInterface
interface interface7 {

	void test1(String S);
	public static String test(String a, String b){
		System.out.println("I am here");
		return "Name "+a+" AND "+b;
	}
}
interface Int1 {
	default void checkCandidate(Integer i){
		if(isEligibleToVote(i)){
			System.out.println("Yes is eligble to VOTE "+i);
		}else{
			System.out.println("Not eligble to VOTE "+i);
		}
		
	}
	
	static boolean isEligibleToVote(Integer i){
		System.out.println("CALLED FROM STATIC");
	  return i>18 ? true:false;	
	}
}
class Test implements Int1{
	
}
public class DefaultStaticInterface {
    public static void main(String args[]){
		/*Test obj = new Test();
		obj.checkCandidate(19);
		obj.isEligibleToVote(3);*/
    	System.out.println("@@@@@@@@ "+interface7.test("saurabh", "Singh"));
	}
}

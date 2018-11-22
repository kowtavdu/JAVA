package string;

public class Paridrome {

	public static boolean isPardrome(String str){
		if(str ==null)
		  return false;
		int length = str.length();
		System.out.println("STRING LENGTH "+length/2);
		System.out.println("STRING LENGTH ONLY "+length);
		for (int i=0;i<length/2;i++){
			System.out.println("STRING LENGTH ONLY "+str.charAt(i)+"SSSSSSSSS"+str.charAt(length-i-1));
			if(str.charAt(i)!=str.charAt(length-i-1)){
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]){
		System.out.println("Hello I am here"+isPardrome("ABA"));
	}
}

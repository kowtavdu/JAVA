import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Java8Comp {

	public static void main(String args[]){
		System.out.println("Hi i am here..");
		
		List<String> name1 = new ArrayList<String>();
		name1.add("Mahesh");
		name1.add("Rakesh2");
		name1.add("Hariom3");
		name1.add("Abhinav4");
		name1.add("Deep");
		
		List<Integer> number = new ArrayList<Integer>();
		
		List<String> name2 = new ArrayList<String>();
		name2.add("Taj");
		name2.add("Oberoi");
		name2.add("Fort");
		name2.add("Shara");
		name2.add("Kerala");
		
		number.add(1);
		number.add(9);
		number.add(7);
		number.add(2);
		number.add(6);
		/*System.out.println("Name11 ===.."+name1);
		System.out.println("Name22 ===.."+name2);*/
		
		Java8Comp tt = new Java8Comp();
		System.out.println("NameOO ===.."+name1);
		tt.Java8Compare(name1);
		System.out.println("Name11 ===.."+name1);
	
	}
	public void Java8Compare(List<String> names){
		Collections.sort(names, (s1, s2)-> s1.compareTo(s2) );
	}
	public void Java7Compare(List<String> name){ 
		Collections.sort(name, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2){
				return s1.compareTo(s2);
			}
		});
		}
}

package dataStructure;

public class ArraySort2 {

	public static void main(String[] args) {
		//int [] array = {45,12,85,32,89,39,69,44,42,1,6,8};
		//insertion sort Algo
		int [] array = {45,12,85,43};
		   System.out.println("@@@@@@@@@@@ "+array.length);
		   int temp;
		   for (int i = 1; i < array.length; i++) {
			   System.out.println("i ===="+i);
		    for (int j = i; j > 0; j--) {
		    	System.out.println("J ===="+j);
		     if (array[j] < array [j - 1]) {
		      temp = array[j];
		      array[j] = array[j - 1];
		      array[j - 1] = temp;
		     }
		    }
		   }
		   for (int i = 0; i < array.length; i++) {
		     System.out.println(array[i]);
		   }

	}
}

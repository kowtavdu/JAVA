package dataStructure;

class MyInsertionSort{
	
	public int[] insertSort(int[] arr){
		int temp;
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr.length;j++){
			//for(int j = i ; j > 0 ; j--){
				if(arr[j]<arr[j-1]){
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}
}

class BubbleSortAlgoImpl{

	public void bubble_sort(int[] arr){
		int n = arr.length;
		for(int m=0;m<=n;m++){
			for(int i=0;i<n-1;i++){
				if(arr[i]> arr[i+1]){
					int temp;
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			printNumber(arr);
		}
	}
	public void printNumber(int [] arr){
		for(int i=0; i<arr.length;i++){
			System.out.print(arr[i]+", ");
		}
		System.out.println("\n");
	}
		
}

public class ArraySortAlgo {

	public static void main(String[] args) {
		 
		 int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		 //BubbleSortAlgoImpl bs = new BubbleSortAlgoImpl();
		 //bs.bubble_sort(input);
	  
		 MyInsertionSort ms = new MyInsertionSort();
		 int[] arr2 = ms.insertSort(input);
		 for(int i:arr2){
	            System.out.print(i);
	            System.out.print(", ");
	        }
	}
}

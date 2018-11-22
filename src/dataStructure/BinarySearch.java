package dataStructure;

class BinarySearchImpl{
	
	public int binarySearchRecursive(int key, int start, int end, int[] arr){
		
		if(start<end){
			//int mid = start + (end - start)/2;
			int mid = (start + end)/2;
			if(key < arr[mid]){
				return binarySearchRecursive(key, start, mid, arr);
			}else if(key > arr[mid]){
				return binarySearchRecursive(key, mid+1, end, arr);
			}else{
				return mid;
			}
			
		}
		return -(start +1);
	}
	public int binarySearch(int key, int[] arr){
		int start =0;
		int end = arr.length-1;
		while(start <=end){
			int mid = (start + end)/2;
			if(key == arr[mid]){
				return mid;
			}
			if(key < arr[mid]){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		return -1;
	}
	
}
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
		BinarySearchImpl bs = new BinarySearchImpl();
		//System.out.println("Key 14 position = "+bs.binarySearch(14, arr));
		System.out.println("Key 14 position = "+bs.binarySearchRecursive(14, 0, arr.length, arr));
		
	}
}

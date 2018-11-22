package dataStructure;

public class ShortArray {

	public static void sortArray(int [] val){
		int j=0;
		boolean swapped = true;
		int tmp;
		while(swapped){
			swapped = false;
			j++;
			int size = val.length-j;
			//System.out.println("JJJJJJJJ "+j);
			//System.out.println("Vall "+val.length);
			System.out.println("JJJJJJJJ "+size);	
		   for(int i=0;i<size;i++){
			if(val[i]>val[i+1]){
				System.out.println(val[i]+"--------"+val[i+1]);
				//System.out.println("Value to swap "+val[i]);
				tmp = val[i];
				val[i] = val[i+1];
				val[i+1] = tmp;
				swapped = true;
			}
		   }
		}
	}
	
	
	public static void main(String[] args) {
		int [] arr = {1,9,3,6,8,4}; 
		
		for(int i=0; i < arr.length; i++){  
            System.out.print(arr[i] + " ");  
       }
		System.out.println("Hello i am here");
	 ShortArray.sortArray(arr);
	 for(int i=0; i < arr.length; i++){  
         System.out.print(arr[i] + " ");  
    }
	}
}

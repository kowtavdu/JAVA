package collection;

import java.util.Iterator;

class SortList<Type> implements Iterable<Type>{

	private Type[] arrayList;
	private int currentSize;
	
	SortList(Type[] newArray){
		this.arrayList = newArray;
		this.currentSize = arrayList.length;
	}
	
	@Override
	public Iterator<Type> iterator() {
		// TODO Auto-generated method stub
		Iterator<Type> it = new Iterator<Type>() {

			private int currentIndex = 0;
			@Override
			public boolean hasNext() {
				System.out.println("Inside hasNext");
				// TODO Auto-generated method stub
				return currentIndex < currentSize && arrayList[currentIndex]!=null;
			}

			@Override
			public Type next() {
				System.out.println("*****NEXT******");
				// TODO Auto-generated method stub
				return arrayList[currentIndex++];
			}
		};
		return it;
	}
	
}

public class CustomIterator {

	public static void main(String[] args) {
		System.out.println("Hello i am here");
		Integer[] numbers = new Integer[]{1,2,3,4,5};
		SortList<Integer> stList = new SortList(numbers);
		for(Integer num: stList){
			System.out.println("---------" +num);
		}
	}
}

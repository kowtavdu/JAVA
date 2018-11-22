package Concu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
class Reader implements Runnable{
	Library lib; 
	Reader(Library lib){
		this.lib = lib;
	}
	@Override
	public void run(){
		try {
		Book book = (Book) lib.issueBook();
		book.read();
		lib.returnBook(book);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
class Book {
	private String bookName;
	public Book(String bookName){
		this.bookName = bookName;
	}
	public void read(){
		System.out.println(bookName+" is being READ...");
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	public String getBookName(){
		return bookName;
	}
}
class Library{
	private static final int MAX_PERMINT = 3;
	private final Semaphore availableBook = new Semaphore(MAX_PERMINT, true);
	private Book[] books = {new Book("AAA"), new Book("BBBB"), new Book("CCCC"), new Book("DDDD")};
	private boolean[] beingRead  = new boolean[MAX_PERMINT];
	
	public Object issueBook() throws InterruptedException{
		availableBook.acquire();
		return getNextAvailableBook();
	}
	
	private synchronized Book getNextAvailableBook(){
		Book book = null;
		for (int i=0; i<MAX_PERMINT;i++){
			if(!beingRead[i]){
				beingRead[i] = true;
				book = books[i];
				System.out.println(book.getBookName()+" Has been issued");
				break;
			}
		}
		return book;
	}
	private synchronized boolean markAsAvailableBook(Book book){
		boolean flag = false;
		for (int i=0;i<MAX_PERMINT; i++){
			if(book == books[i]){
				if(beingRead[i]){
					beingRead[i] = false;
					flag = true;
					System.out.println(book.getBookName()+" Has been returned");
				}
				break;
			}
		}
		return flag;
	}
	public void returnBook(Book book){
		if(markAsAvailableBook(book))
			availableBook.release();
	}
	
}
public class CountingSemaphore {

	public static void main(String args[]){
		final int threadCount = 6;
		final ExecutorService ec = Executors.newFixedThreadPool(threadCount);
		Library lib = new Library();
		for (int i=1; i<=threadCount;i++){
			ec.execute(new Reader(lib));
		}
		ec.shutdown();
	}
}

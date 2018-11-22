package DesignPattern;

class Course{
	
	String subject1;
	String subject2;
	String subject3;
	
	Course(String subject1, String subject2, String subject3){
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}
}

class Student1 implements Cloneable{
	Course course;
	int id;
	String name;
	
	Student1(Course course, int id, String name){
		this.course = course;
		this.id = id;
		this.name = name;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	} 
	
}
public class ShallowCopy {
/*
 * In the above example, ‘student1‘ is an object of ‘Student‘ class which has three fields 
 * – id, name and course. ‘course‘ is a reference variable pointing to a ‘Course‘ type object. 
 * Clone of ‘student1‘ is created by calling clone method on it and assigned it to ‘student2‘.
 *  As default version of clone method creates the shallow copy, the ‘course‘ field of both ‘student1‘ 
 *  and ‘student2‘ will be pointing to same ‘Course‘ object. So, any changes made to this object 
 *  through ‘student2‘ will be reflected in ‘student1‘ or vice-versa.
 */
	public static void main(String[] args) {
		Course cr = new Course("maths", "science", "english");
		Student1 std1 = new Student1(cr, 12 ,"saurabh");
		try{
		Student1 std2 = (Student1) std1.clone();
		System.out.println("@@@@@@@@@@@@@ {} "+std1.course.subject2);
		std2.course.subject2 = "bIO";
		System.out.println("@@@@@@@@@@@@@ {} "+std1.course.subject2);
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		
		
	}
}

package DesignPattern;

import java.util.Arrays;

class Student{
	
	int student_id;
	String email_id;
	String f_name;
	String l_name;
	String mobile_number;
	
	public Student(StudentBuilder studentBuilder) {
		this.student_id = studentBuilder.student_id;
		this.email_id = studentBuilder.email_id;
		this.f_name = studentBuilder.f_name;
		this.l_name = studentBuilder.l_name;
		this.mobile_number = studentBuilder.mobile_number;
	}

	public int getStudent_id() {
		return student_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public String getF_name() {
		return f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public static class StudentBuilder{
	
		int student_id;
		String email_id;
		String f_name;
		String l_name;
		String mobile_number;
		
		StudentBuilder(int student_id, String email_id){
			this.student_id = student_id;
			this.email_id = email_id;
		}
		
		public StudentBuilder setF_name(String f_name) {
			this.f_name = f_name;
			return this;
		}
		
		public StudentBuilder setL_name(String l_name) {
			this.l_name = l_name;
			return this;
		}
		
		public StudentBuilder setMobile_number(String mobile_number) {
			this.mobile_number = mobile_number;
			return this;
		}
		
		public Student build(){
			return new Student(this);
		}
	}
	
}

public class BuilderPattern {

	public static void main(String[] args) {
		
		Student obj = new Student.StudentBuilder(38967, "saurabh@gmail.com").build();
	
	}
}

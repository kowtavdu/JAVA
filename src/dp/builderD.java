package dp;

class Student {
	
	private Student(StudentBuilder sb){
		this.fname = sb.fname;
		this.lname = sb.lname;
		this.mobile = sb.mobile;
		this.add1 = sb.add1;
		this.add2 = sb.add2;
				
	}
	
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getMobile() {
		return mobile;
	}
	public String getAdd1() {
		return add1;
	}
	public String getAdd2() {
		return add2;
	}
	String fname;
	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	String lname;
	String mobile;
	String add1;
	String add2;
	
	
	public static class StudentBuilder {
		
		String fname;
		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getAdd1() {
			return add1;
		}

		public void setAdd1(String add1) {
			this.add1 = add1;
		}

		public String getAdd2() {
			return add2;
		}

		public void setAdd2(String add2) {
			this.add2 = add2;
		}

		String lname;
		String mobile;
		String add1;
		String add2;
		public StudentBuilder setMobileNo(String mobile) {
			System.out.println("KKKKKKKKKKK");
			this.mobile = mobile;
			return this;
		}

		public StudentBuilder setAddress1(String add1) {
			this.add1 = add1;
			return this;
		}

		public StudentBuilder setAddress2(String add2) {
			this.add2 = add2;
			return this;
		}

		
		
		StudentBuilder(String fname, String lname){
			this.fname = fname;
			this.lname = lname;
		}
		
		public Student build(){
			return new Student(this);
		}
		
		
	}
}


public class builderD {

	public static void main(String[] args) {
		Student st = new Student.StudentBuilder("saurabh", "Singh").build();
		System.out.println(st.getFname()+"--------"+st.getLname());
		
		Student st1 = new Student.StudentBuilder("saurabh", "Singh").setMobileNo("9540052570").build();
		System.out.println(st.getFname()+"--------"+st.getLname()+"-----"+st.getMobile());
	}
}

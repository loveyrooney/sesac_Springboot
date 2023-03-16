package test;

public class Student extends Person {
	private String studentID;
	
	public Student() {
		//요 자리에서 내가 상속받은 Person 클래스의 기본 생성자 함수(매개변수 없는)를 실행시킨다. 
		//즉 Person의 첫번째 생성자 함수를 실행시킴
		//super("noname",10);//매개변수 있는 생성자 함수를 실행시키고 싶을 때
		this.name = "jessy";
		System.out.println("student 생성자 실행");
	}
	
	
	
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}



	public void study() {
		System.out.println("study");
	}
	
	//오버라이딩은 함수 원형 틀이 완전 똑같고 내용만 달라져야 함. 부모 클래스에서 상속받은 메소드를 덮어쓰기 하기 위함
	//이거 내가 변수가 다른 똑같은 구조의 함수 쓰고자 하는 그거 적용할수 있을듯
	public void test() {
		System.out.print("overiding student");
	}
	
}

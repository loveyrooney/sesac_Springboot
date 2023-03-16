package Abstract;

public class Kim extends Student {
	public Kim() {
		this.name = "kim";
		this.school = "sesac";
		this.age = 20;
		this.studentID = 12345678;
		System.out.println(name +"/"+ school +"/" + age +"/"+ studentID);
	}
	
	public void todo() {
		System.out.println("점심은 김가네 김밥");
	}

}

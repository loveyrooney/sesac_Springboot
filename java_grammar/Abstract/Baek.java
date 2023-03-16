package Abstract;

public class Baek extends Student {
	public Baek() {
		this.name = "beak";
		this.school = "yongsan";
		this.age = 22;
		this.studentID = 23456789;
		System.out.println(name +"/"+ school +"/" + age +"/"+ studentID);
	}
	
	public void todo() {
		System.out.println("점심은 백종원 피자");
	}
}

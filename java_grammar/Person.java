
public class Person {
	
	//필드
	public String name;
	public int age;
	
	//생성자
//	public Person(String name, int age) {
//		System.out.println("welcome");
//		this.name = name;
//		this.age = age;
//	}
	
	//getter & setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getage() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//method
	public void myname() {
		System.out.println("my name is " + name);
	}
}

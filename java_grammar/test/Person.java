package test;

public class Person {
	protected String name;
	private int age;
	
	
	//생성자는 같은 이름, 다른 인자를 설정해 복수개로 설정할 수 있다
	public Person() {
		System.out.println("person 클래스의 기본생성자");
	}
	
	public Person(String name, int age) {
		System.out.println("person 클래스의 매개변수 있는 생성자");
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//메소드도 같은 이름, 다른 인자를 설정할 수 있음
	public void sleep() {
		System.out.println("zzz");
	}
	
	//메소드 오버라이딩 테스트
	public void test() {
		System.out.print("overiding person");
	}

}

//같은이름, 다른인자로 함수를 설정가능한 것이 함수 오버로딩이란 개념임 

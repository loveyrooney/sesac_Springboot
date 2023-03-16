package test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person(); //이거는 첫번째 생성자 실행
		Person p2 = new Person("john",10); //이거는 두번째 생성자 실행
		Student s = new Student();
		System.out.println(s.getName()); //이 시점의 이름과
		s.setName("amy");
		System.out.println(s.getName());//이 시점의 이름이 다른것임. 
		
	}

}

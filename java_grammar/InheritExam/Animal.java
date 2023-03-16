package InheritExam;

public class Animal {
	
	protected String species;
	private String name;
	private int age;
	
	public Animal() {
		this.species = species;
		this.name = name;
		this.age = age;
	}
	
	public Animal(String name, int age) {
	  this.species = species;
	  this.name = name;
	  this.age = age;
	}

	public void makeSound() {
		System.out.println("동물은 소리를 낸다");
	}
	

}

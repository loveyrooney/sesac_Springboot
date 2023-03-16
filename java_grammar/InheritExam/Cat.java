package InheritExam;

public class Cat extends Animal {
	
	public Cat(String name, int age) {
		this.species = "cat";
		System.out.println(name + age + species);
	}

	public void makeSound() {
		System.out.println("야옹");
	}
}

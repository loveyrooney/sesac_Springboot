package InheritExam;

public class Dog extends Animal {
	
	public Dog(String name, int age) {
		this.species = "dog";
		System.out.println(name + age + species);
	}

	public void makeSound() {
		System.out.println("멍멍");
	}
}

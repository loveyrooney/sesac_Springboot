package InheritExam;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat a = new Cat("nabi",3);
		Dog b = new Dog("puppy",5);
		a.makeSound();
		b.makeSound();
		
		Bus bus = new Bus("tayo");
		Car car = new Car("mycar");
		Bicycle bicycle = new Bicycle("sweety");
		bus.whenUse();
		car.whenUse();
		bicycle.whenUse();
	}

}

package InheritExam;

public class Car extends Vehicle {
	
	public Car(String name) {
		this.wheelCount = 4;
		this.CarOnlyRoad = true;
		System.out.println(name + wheelCount + CarOnlyRoad);
	}
	
	public void whenUse() {
		System.out.println("자가용 이용할때");
	}
}

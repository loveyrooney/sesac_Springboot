package InheritExam;

public class Bicycle extends Vehicle {
	
	public Bicycle(String name) {
		this.wheelCount = 2;
		this.CarOnlyRoad = false;
		System.out.println(name + wheelCount + CarOnlyRoad);
	}
	
	public void whenUse() {
		System.out.println("가까운 거리 갈때");
	}
}

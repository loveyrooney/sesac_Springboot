package InheritExam;

public class Bus extends Vehicle {
	
	public Bus(String name) {
		this.wheelCount = 4;
		this.CarOnlyRoad = true;
		System.out.println(name + wheelCount + CarOnlyRoad);
	}
	
	public void whenUse() {
		System.out.println("대중교통 이용할때");
	}

}

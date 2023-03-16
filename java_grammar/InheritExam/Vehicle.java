package InheritExam;

public class Vehicle {
	protected String name;
	protected int wheelCount;
	protected boolean CarOnlyRoad;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String name) {
		this.name = name;
		this.wheelCount = wheelCount;
		this.CarOnlyRoad = CarOnlyRoad;
	}
	
	public void whenUse() {
		System.out.println("default");
	}

}

package ch08.ex08_10;

public class TrafficLightTest {

	public static void main(String[] args) {
		System.out.println("Traffic Light:");
		
		for (TrafficLight light : TrafficLight.values()) {
			System.out.printf("%-6s %d%n", light, light.getDuration());
		}
	}

}

package ch08.ex08_10;

public enum TrafficLight {
	RED(2), GREEN(3), YELLOW(1);

	private int duration;

	TrafficLight(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}
}

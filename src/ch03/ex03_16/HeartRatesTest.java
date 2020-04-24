package ch03.ex03_16;

public class HeartRatesTest {

	public static void main(String[] args) {
		HeartRates heartRates = new HeartRates("Gustavo", "Alves", 3, 27, 2000);

		System.out.printf("Maximum heart rate: %s bpm%n", heartRates.getMaximumHeartRate());
		System.out.printf("Targe heart rate: %s bpm%n", heartRates.getTargetHeartRate());
	}

}

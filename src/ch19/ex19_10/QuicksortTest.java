package ch19.ex19_10;

import java.util.Arrays;

public class QuicksortTest {

	public static void quickSortHelper(int[] data, int initialIndex, int finalIndex) {
		if (initialIndex < finalIndex) {
			int partitionIndex = partition(data, initialIndex, finalIndex);

			quickSortHelper(data, initialIndex, partitionIndex - 1);
			quickSortHelper(data, partitionIndex + 1, finalIndex);
		}
	}

	private static int partition(int data[], int begin, int end) {
		int pivot = data[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (data[j] <= pivot) {
				i++;

				swap(data, i, j);
			}
		}

		swap(data, i + 1, end);

		return i + 1;
	}

	private static void swap(int[] data, int first, int second) {
		int temporary = data[first];
		data[first] = data[second];
		data[second] = temporary;
	}

	public static void main(String[] args) {
		int[] data = { 37, 2, 6, 4, 89, 8, 10, 12, 68, 45 };

		System.out.println(Arrays.toString(data));

		quickSortHelper(data, 0, data.length - 1);

		System.out.println(Arrays.toString(data));
	}
}

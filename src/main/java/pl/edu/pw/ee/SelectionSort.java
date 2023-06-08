package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class SelectionSort implements Sorting {

	@Override
	public void sort(double[] nums) {
		if (nums == null) {
			throw new IllegalArgumentException("Nums array cannot be null");
		}

		int minValidId;

		for (int i = 0; i < nums.length - 1; i++) {
			minValidId = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minValidId]) {
					minValidId = j;
				}
			}
			swap(nums, i, minValidId);
		}
	}

	private void swap(double[] nums, int firstId, int secondId) {
		if (firstId != secondId) {
			double firstVal = nums[firstId];
			nums[firstId] = nums[secondId];
			nums[secondId] = firstVal;
		}
	}

}

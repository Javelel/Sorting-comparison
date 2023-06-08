package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class InsertionSort implements Sorting {

	@Override
	public void sort(double[] nums) {
		if (nums == null) {
			throw new IllegalArgumentException("Nums array cannot be null");
		}

		inSort(nums);
	}

	private void inSort(double[] nums) {
		for (int i = 1; i < nums.length; i++) {
			double current = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > current) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = current;
		}
	}

}

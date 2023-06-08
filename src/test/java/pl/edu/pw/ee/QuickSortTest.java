package pl.edu.pw.ee;

import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

public class QuickSortTest {

	private Sorting sorter;
	private Random rnd;

	@Before
	public void setUp() {
		sorter = new QuickSort();
		rnd = new Random(0);
	}

	@Test(expected = IllegalArgumentException.class)

	public void numsSchouldNotBeNull() {
		//given
		double[] nums = null;
		//when
		sorter.sort(nums);
		//then
		assert false;
	}

	@Test
	public void schouldPassArrayWithOneElement() {
		//given
		double[] nums = {6};
		//when
		sorter.sort(nums);
		double[] expected = {6};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void shouldSortReversedArray() {
		//given
		double[] nums = {9, 8, 7, 6, 5, 2, 1, 0};
		//when
		sorter.sort(nums);
		double[] expected = {0, 1, 2, 5, 6, 7, 8, 9};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void shouldSortUnsortedArray() {
		//given
		double[] nums = {5, 2, 7, 10, -5};
		//when
		sorter.sort(nums);
		double[] expected = {-5, 2, 5, 7, 10};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void shouldPassSortedArray() {
		//given
		double[] nums = {-2, 3, 5, 6, 10};
		//when
		sorter.sort(nums);
		double[] expected = {-2, 3, 5, 6, 10};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void shouldPassArrayWithZeroElements() {
		//given
		double[] nums = {};
		//when
		sorter.sort(nums);
		double[] expected = {};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void shouldSortArrayWithTwoElement() {
		//given
		double[] nums = {8, 6};
		//when
		sorter.sort(nums);
		double[] expected = {6, 8};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void shouldSortArrayWhenTwoElementsAreEqual() {
		//given
		double[] nums = {5, 2, 7, 10, -5, 2};
		//when
		sorter.sort(nums);
		double[] expected = {-5, 2, 2, 5, 7, 10};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void shouldPassArrayWhenAllElementsAreTheSame() {
		//given
		double[] nums = {0, 0, 0, 0, 0, 0};
		//when
		sorter.sort(nums);
		double[] expected = {0, 0, 0, 0, 0, 0};
		//then
		Assert.assertArrayEquals(nums, expected, 0);
	}

	@Test
	public void timeTestForBigArrays() {
		//given
		double[] nums = new double[100000000];
		fillWithRandomData(nums);
		//when
		sorter.sort(nums);
		//then
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				assert false;
			}
		}
		assert true;
	}

	private void fillWithRandomData(double[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			nums[i] = rnd.nextDouble();
		}
	}
}

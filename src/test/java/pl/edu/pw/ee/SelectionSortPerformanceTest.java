package pl.edu.pw.ee;

import org.junit.Before;
import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortPerformanceTest {

	private Sorting sorter;
	private Random rnd;

	@Before
	public void setUp() {
		sorter = new SelectionSort();
		rnd = new Random(0);
	}

	@Test
	public void optimisticData() {
		long[] timeElapsed = new long[10];
		int numOfElements = 0;
		for (int i = 0; i < 100; i++) {
			numOfElements += 500;
			for (int j = 0; j < 10; j++) {
				double[] nums = new double[numOfElements];
				for (int k = 0; k < nums.length; k++) {
					nums[k] = k;
				}
				long start = System.currentTimeMillis();
				sorter.sort(nums);
				long finish = System.currentTimeMillis();
				timeElapsed[j] = finish - start;
			}
			Arrays.sort(timeElapsed);
			System.out.println(numOfElements + " " + (timeElapsed[4] + timeElapsed[5]) / 2);
		}
	}

	@Test
	public void randomData() {
		long[] timeElapsed = new long[10];
		int numOfElements = 0;
		for (int i = 0; i < 100; i++) {
			numOfElements += 500;
			for (int j = 0; j < 10; j++) {
				double[] nums = new double[numOfElements];
				for (int k = 0; k < nums.length; k++) {
					nums[k] = rnd.nextDouble();
				}
				long start = System.currentTimeMillis();
				sorter.sort(nums);
				long finish = System.currentTimeMillis();
				timeElapsed[j] = finish - start;
			}
			Arrays.sort(timeElapsed);
			System.out.println(numOfElements + " " + (timeElapsed[4] + timeElapsed[5]) / 2);
		}
	}

	@Test
	public void pessimisticData() {
		long[] timeElapsed = new long[10];
		int numOfElements = 0;
		for (int i = 0; i < 100; i++) {
			numOfElements += 200;
			for (int j = 0; j < 10; j++) {
				double[] nums = new double[numOfElements];
				for (int k = 0; k < nums.length; k++) {
					nums[k] = -k;
				}
				long start = System.currentTimeMillis();
				sorter.sort(nums);
				long finish = System.currentTimeMillis();
				timeElapsed[j] = finish - start;
			}
			Arrays.sort(timeElapsed);
			System.out.println(numOfElements + " " + (timeElapsed[4] + timeElapsed[5]) / 2);
		}
	}
}

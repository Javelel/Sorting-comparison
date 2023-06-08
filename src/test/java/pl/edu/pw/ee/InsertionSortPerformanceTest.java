package pl.edu.pw.ee;

import org.junit.Before;
import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortPerformanceTest {

	private Sorting sorter;
	private Random rnd;

	@Before
	public void setUp() {
		sorter = new InsertionSort();
		rnd = new Random(0);
	}

	@Test
	public void optimisticData() {
		long[] timeElapsed = new long[10];
		int numOfElements = 0;
		for (int i = 0; i < 100; i++) {
			numOfElements += 20000;
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
		System.out.println();
		System.out.println();
		System.out.println();
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
			numOfElements += 500;
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

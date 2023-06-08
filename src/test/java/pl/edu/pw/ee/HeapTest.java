package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.Before;

public class HeapTest {

	private Heap<Double> heap;
	private List<Double> data;
	Random rnd;

	@Before
	public void setUp() {
		rnd = new Random(0);
	}

	@Test
	public void buildShouldBuildHeap() {
		//given
		data = new ArrayList<>(Arrays.asList(4.0, 2.0, 8.0, 1.0, 5.0, 3.0, 15.0, 4.6));
		heap = new Heap<>(data);
		//when
		heap.build();
		//then
		int n = data.size();

		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test
	public void buildShouldBuildHeapWhenTwoElementsAreTheSame() {
		//given
		data = new ArrayList<>(Arrays.asList(4.0, 4.0, 2.0, 8.0, 1.0, 5.0, 3.0, 15.0, 4.6));
		heap = new Heap<>(data);

		//when
		heap.build();
		//then
		int n = data.size();

		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test
	public void buildShouldPassDataWhenSortedInDecreasingOrder() {
		//given
		List<Double> expected = new ArrayList<>(Arrays.asList(10.0, 8.0, 6.0, 3.0, 1.0, 0.0, -2.0, -4.0));
		data = new ArrayList<>(Arrays.asList(10.0, 8.0, 6.0, 3.0, 1.0, 0.0, -2.0, -4.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		//then
		Assert.assertEquals(expected, data);
	}

	@Test
	public void buildShouldPassDataWhenAllValuesAreTheSame() {
		//given
		List<Double> expected = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0));
		data = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		//then
		Assert.assertEquals(expected, data);
	}

	@Test
	public void buildShouldPassDataWithOneElement() {
		//given
		List<Double> expected = new ArrayList<>(Arrays.asList(1.0));
		data = new ArrayList<>(Arrays.asList(1.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		//then
		Assert.assertEquals(expected, data);
	}

	@Test
	public void buildShouldPassDataWithNoElements() {
		//given
		List<Double> expected = new ArrayList<>(Arrays.<Double>asList());
		data = new ArrayList<>(Arrays.<Double>asList());
		heap = new Heap<>(data);
		//when
		heap.build();
		//then
		Assert.assertEquals(expected, data);
	}

	@Test(expected = IllegalArgumentException.class)
	public void dataCannotBeNull() {
		//given
		data = null;
		//when
		heap = new Heap<>(data);
		//then
		assert false;
	}

	@Test
	public void popShouldMaintainHeapStructure() {
		//given
		data = new ArrayList<>(Arrays.asList(-1.0, 4.0, 2.0, 8.0, 1.0, 0.0, 8.0, 5.0, 3.0, 3.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		heap.pop();
		heap.pop();
		heap.pop();
		//then
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test
	public void popShouldReturnTheGreatestValueFromHeap() {
		//given
		data = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			data.add(rnd.nextDouble());
		}
		heap = new Heap<>(data);
		heap.build();
		Double expected = Double.MIN_VALUE;
		for (Double item : data) {
			if (expected < item) {
				expected = item;
			}
		}
		//when
		Double result = heap.pop();
		//then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void popShouldWorkWhenDataContainsOneElement() {
		//given
		data = new ArrayList<>(Arrays.asList(0.0));
		List<Double> expected = new ArrayList<>(Arrays.<Double>asList());
		heap = new Heap<>(data);
		heap.build();
		//when
		heap.pop();
		//then
		Assert.assertEquals(expected, data);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void popCannotBeUsedWhenHeapIsEmpty() {
		//given
		data = new ArrayList<>();
		heap = new Heap<>(data);
		heap.build();
		//when
		heap.pop();
		//then
		assert false;
	}

	@Test
	public void popShouldStillWorkWhenBuildIsNotCalled() {
		//given
		data = new ArrayList<>(Arrays.asList(-1.0, 4.0, 2.0, 8.0, 1.0, 0.0, 8.0, 5.0, 3.0, 3.0));
		heap = new Heap<>(data);
		Double expected = 8.0;
		//when
		Double result = heap.pop();
		//then
		Assert.assertEquals(expected, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void putItemCannotBeNull() {
		//given
		data = new ArrayList<>(Arrays.asList(4.0, 2.0, 8.0, 1.0, 8.0, 5.0, 3.0, 3.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		heap.put(null);
		//then
		assert false;
	}

	@Test
	public void putShouldMaintainHeapStructure() {
		//given
		data = new ArrayList<>(Arrays.asList(4.0, 2.0, 8.0, 1.0, 8.0, 5.0, 3.0, 3.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		heap.put(-6.0);
		heap.put(7.0);
		heap.put(5.5);
		//then
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test
	public void putShouldWorkWhenDataContainsNoElement() {
		//given
		data = new ArrayList<>(Arrays.<Double>asList());
		List<Double> expected = new ArrayList<>(Arrays.asList(0.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		heap.put(0.0);
		//then
		Assert.assertEquals(expected, data);
	}

	@Test
	public void putShouldWorkWhenAddedItemIsGreaterThanTheRest() {
		//given
		data = new ArrayList<>(Arrays.asList(4.0, 2.0, 8.0, 1.0, 8.0, 5.0, 3.0, 3.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		heap.put(10000.0);
		//then
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test
	public void putShouldWorkWhenAddedItemIsSmallerThanTheRest() {
		//given
		data = new ArrayList<>(Arrays.asList(4.0, 2.0, 8.0, 1.0, 8.0, 5.0, 3.0, 3.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		heap.put(-100.0);
		//then
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test
	public void putPerformanceTest() {
		//given
		data = new ArrayList<>();
		heap = new Heap<>(data);
		heap.build();
		//when
		for (int i = 0; i < 50000000; i++) {
			heap.put(rnd.nextDouble());
		}
		//then
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test
	public void buildPerformanceTest() {
		//given
		data = new ArrayList<>();
		for (int i = 0; i < 50000000; i++) {
			data.add(rnd.nextDouble());
		}
		heap = new Heap<>(data);
		//when
		heap.build();
		//then
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
		assert true;
	}

	@Test(expected = IllegalArgumentException.class)
	public void dataCannotContainNullElements() {
		//given
		data = new ArrayList<>(Arrays.asList(4.0, 2.0, 8.0, 1.0, null, 8.0, 5.0, 3.0, 3.0));
		heap = new Heap<>(data);
		//when
		heap.build();
		//then
		assert true;
	}

	@Test
	public void heapShouldWorkWithStrings() {
		//given
		List<String> data = new ArrayList<>(Arrays.asList("fg", "aa", "a", "bbs", "z"));
		Heap<String> heap = new Heap<>(data);
		//when
		heap.build();
		//then
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			assert data.get(i).compareTo(data.get((i - 1) / 2)) <= 0;
		}
	}

}

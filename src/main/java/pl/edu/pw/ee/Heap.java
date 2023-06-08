package pl.edu.pw.ee;

import java.util.List;
import pl.edu.pw.ee.services.HeapExtension;
import pl.edu.pw.ee.services.HeapInterface;

public class Heap<T extends Comparable<T>> implements HeapInterface<T>, HeapExtension {

	private List<T> data;
	boolean isHeap;

	public Heap(List<T> data) {
		if (data == null) {
			throw new IllegalArgumentException("data cannot be null");
		}
		this.data = data;
		isHeap = checkIfDataIsHeap();
	}

	@Override
	public void put(T item) {
		if (item == null) {
			throw new IllegalArgumentException("put item cannot be null");
		}
		if (!isHeap) {
			build();
		}
		data.add(item);
		heapUp();
	}

	@Override
	public T pop() {
		if (data.size() < 1) {
			throw new ArrayIndexOutOfBoundsException("cannot pop when size of data is = 0");
		}
		if (data.size() == 1) {
			return data.remove(0);
		}
		if (!isHeap) {
			build();
		}
		T tmp = data.get(0);
		data.set(0, data.remove(data.size() - 1));
		heapify(0, data.size());
		return tmp;
	}

	@Override
	public void build() {
		if (data.contains(null)) {
			throw new IllegalArgumentException("data cannot contain null elements");
		}
		if (isHeap) {
			return;
		}
		int n = data.size();

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(i, n);
		}
		isHeap = true;
	}

	@Override
	public void heapify(int startId, int endId) {
		while (startId < endId) {
			if (getRightChildId(startId) < endId && (data.get(startId).compareTo(data.get(getLeftChildId(startId))) < 0 || data.get(startId).compareTo(data.get(getRightChildId(startId))) < 0)) {
				if (data.get(getLeftChildId(startId)).compareTo(data.get(getRightChildId(startId))) > 0) {
					swap(startId, getLeftChildId(startId));
					startId = getLeftChildId(startId);
				} else {
					swap(startId, getRightChildId(startId));
					startId = getRightChildId(startId);
				}
			} else if (getLeftChildId(startId) < endId && data.get(getLeftChildId(startId)).compareTo(data.get(startId)) > 0) {
				swap(startId, getLeftChildId(startId));
				startId = getLeftChildId(startId);
			} else {
				break;
			}
		}
	}

	private void heapUp() {
		int i = data.size() - 1;
		while (i > 0) {
			if ((data.get(i).compareTo(data.get(getParentId(i))) > 0)) {
				swap(getParentId(i), i);
				i = getParentId(i);
			} else {
				break;
			}
		}
	}

	private boolean checkIfDataIsHeap() {
		int n = data.size();
		for (int i = n - 1; i >= 0; i--) {
			if (data.get(i).compareTo(data.get((i - 1) / 2)) <= 0) {
				return false;
			}
		}
		return true;
	}

	private int getParentId(int id) {
		return (id - 1) / 2;
	}

	private int getLeftChildId(int id) {
		return id * 2 + 1;
	}

	private int getRightChildId(int id) {
		return id * 2 + 2;
	}

	private void swap(int parentId, int childId) {
		T tmp = data.get(parentId);
		data.set(parentId, data.get(childId));
		data.set(childId, tmp);
	}

}

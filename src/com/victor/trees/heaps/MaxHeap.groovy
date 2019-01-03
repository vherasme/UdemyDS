package com.victor.trees.heaps

class MaxHeap<T extends Comparable<T>> extends Heap<T>  {

	public MaxHeap(int size) {
		super(size);
	}

	@Override
	public void add(T item) {
		if (count < MAX_SIZE) {
			arrayOfNodes[count] = item
			count ++
			if (count >= 2) {
				checkValidHeap(count -1)
			}
		} else {
			throw new RuntimeException("Heap is full")
		}
	}

	@Override
	public void heapSort() {
		int size = size()
		T[] arrayNew = (T[]) new Comparable[size]
		for (int i = 0; i < size; ++i) {
			int max = poll()
			arrayNew[i] = max
			println "$max"
		}
		arrayOfNodes = arrayNew
	}

	private void checkValidHeap(int index) {
		if (index > 0) {
			T lastitem = arrayOfNodes[index]
			int parentIndex = (index -1).intdiv(2)
			T parentNode = arrayOfNodes[parentIndex]
			if (lastitem.compareTo(parentNode) > 0) {
				swap(index, parentIndex)
				checkValidHeap(parentIndex)
			}
		}
	}

	@Override
	public T remove() {
		return null;
	}

	@Override
	public void traversal() {
		int all = arrayOfNodes.length - 1
		0.upto(all) { i ->
			T currentElem = arrayOfNodes[i]
			println currentElem.toString()
		}
	}
}
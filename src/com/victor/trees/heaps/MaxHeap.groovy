package com.victor.trees.heaps

import groovy.transform.Canonical

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
		0.upto(count - 1) { i ->
			T currentElem = arrayOfNodes[i]
			println currentElem.toString()
		}
	}
}
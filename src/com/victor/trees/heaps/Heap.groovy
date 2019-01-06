package com.victor.trees.heaps

abstract class Heap<T extends Comparable<T>> {

	static MAX_SIZE = 40
	T[] arrayOfNodes
	int count
	HeapTypes heapType

	static final Map<Enum, Closure> heapify = new HashMap<>()
	static {
		heapify.put(HeapTypes.MAX, { int i, int j ->
			return arrayOfNodes[i] > arrayOfNodes[j]
		})

		heapify.put(HeapTypes.MIN, { int i, int j ->
			return arrayOfNodes[i] < arrayOfNodes[j]
		})
	}

	Heap(int size, HeapTypes type){
		arrayOfNodes = (T[]) new Comparable[size]
		heapType = type
	}

	abstract void add(T item)

	abstract T remove()

	abstract void traversal()

	abstract void heapSort()

	boolean isEmpty() {
		return count == 0
	}

	/**
	 * This method returns the first member of the arrayOfNodes
	 * 
	 * */
	T peek() {
		return arrayOfNodes[0]
	}

	T poll() {
		int heapPeak = peek()
		swap(0, count - 1)
		count--
		fixHeap(0)

		return heapPeak
	}

	void fixHeap(int index) {
		int left = getLeftChildIndex(index)
		int right = getRightChildIndex(index)
		int indexLargest = index

		//if left is greater than its parent...
		if (left < count && arrayOfNodes[left] > arrayOfNodes[index])
			indexLargest = left
		//But then right is even greater than left...
		if (right < count && arrayOfNodes[right] > arrayOfNodes[indexLargest])
			indexLargest = right

		//Swap element with the largest found, unless they have the same index
		if (index != indexLargest) {
			swap(index, indexLargest)
			fixHeap(indexLargest)
		}
	}

	int size() {
		return count
	}

	protected void swap(int indexOne, int indexTwo) {
		T tempNode = arrayOfNodes[indexOne]
		arrayOfNodes[indexOne] = arrayOfNodes[indexTwo]
		arrayOfNodes[indexTwo] = tempNode
	}

	int getLeftChildIndex(int index) {
		int leftChildIndex = 2 * index + 1
		if (leftChildIndex > count) {
			return -1
		}
		return leftChildIndex
	}

	int getRightChildIndex(int index) {
		int rightChildIndex = 2 * index + 2
		if (rightChildIndex > count) {
			return -1
		}
		return rightChildIndex
	}
}

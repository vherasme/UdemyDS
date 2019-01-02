package com.victor.trees.heaps

abstract class Heap<T extends Comparable<T>> {

	static MAX_SIZE = 40
	T[] arrayOfNodes
	int count

	Heap(int size){
		arrayOfNodes = (T[]) new Comparable[size]
	}

	abstract void add(T item)

	abstract T remove()

	abstract void traversal()
	
	abstract void heapSort()

	boolean isEmpty() {
		return count == 0
	}

	T peek() {
		return arrayOfNodes[0]
	}

	T poll() {
		int max = peek()
		swap(0, count - 1)
		count--
		fixDown(0)

		return max
	}

	void fixDown(int index) {
		int left = getLeftChildIndex(index)
		int right = getRightChildIndex(index)
		int indexLargest = index
		
		//if left is greater than its parent...
		if (left < count && arrayOfNodes[left] > arrayOfNodes[index])
			indexLargest = left
		//But then right is even greater than left...
		if (right < count && arrayOfNodes[right] > arrayOfNodes[indexLargest])
			indexLargest = right

		//Swap element with the largest found
		if (index != indexLargest) {
			swap(index, indexLargest)
			fixDown(indexLargest)
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

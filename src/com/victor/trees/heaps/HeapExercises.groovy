package com.victor.trees.heaps

class HeapExercises<T> {

	static final Map<Enum, Closure> checkHeapMap = new HashMap<>()
	static {

		checkHeapMap.put(HeapTypes.MIN, {Comparable[] heap, lastNode ->
			for (int i = 0; i < lastNode; i++) {
				if ((heap[i] > heap[2*i + 1] || heap[i] > heap[2*i + 2]))
					return false
			}
			return true
		})

		checkHeapMap.put(HeapTypes.MAX, {Comparable[] heap, lastNode ->

			for (int i = 0; i < lastNode; i++) {
				if ((heap[i] < heap[2*i + 1] || heap[i] < heap[2*i + 2]))
					return false
			}
			return true
		})
	}

	/**
	 * Function to check if heap is either a valid max or min heap
	 * @param heap This is the heap to examine
	 * @param type This value should be either "min" or max
	 * @return whether the heap is valid or not 
	 *
	 * */
	static <T> boolean checkHeap(Comparable<T>[] heap, Enum type) {
		int lastNode = (heap.length - 2).intdiv(2)
		return checkHeapMap[type].call(heap, lastNode)
	}
}


package com.victor.trees.heaps

class HeapExercises<T> {

	static final Map<String, Closure> checkHeapMap = new HashMap<>()
	static {

		checkHeapMap.put("min", {Comparable[] heap, lastNode ->
			for (int i = 0; i < lastNode;i++) {
				if ((heap[i] > heap[2*i - 1] || heap[i] > heap[2*i + 2]))
					return false
			}
			return true
		})

		checkHeapMap.put("max", {Comparable[] heap, lastNode ->

			for (int i = 0; i < lastNode;i++) {
				if ((heap[i] < heap[2*i - 1] || heap[i] < heap[2*i + 2]))
					return false
			}
			return true
		})
	}

	/*
	 * Function to check if heap is either a valid max or min heap
	 * @param heap This is the heap to examine
	 * @param type This value should be either "min" or max
	 * @return boolean 
	 * */
	static boolean checkHeap(Comparable[] heap, String type) {
		int lastNode = (heap.length - 2).intdiv(2)
		return checkHeapMap[type].call(heap, lastNode)
	}
}


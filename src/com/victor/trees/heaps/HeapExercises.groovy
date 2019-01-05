package com.victor.trees.heaps

class HeapExercises<T> {

	static final Map<String, Closure> functionsMap = new HashMap<>()
	static {

		functionsMap.put("min", {Comparable[] heap, i ->
			println "Min heap checking $i"
			return !(heap[i] > heap[2*i - 1] || heap[i] > heap[2*i + 2])
		})

		functionsMap.put("max", {Comparable[] heap, i ->
			println "Max heap checking $i"
			return !(heap[i] < heap[2*i - 1] || heap[i] < heap[2*i + 2])
		})
	}

	static boolean checkHeap(Comparable[] heap, String type) {
		int lastNode = (heap.length - 2).intdiv(2)
		def isValidHeap = true
		for (int i = 0; i < lastNode;i++) {
			isValidHeap = functionsMap[type].call(heap, i)
		}
		return isValidHeap
	}
}


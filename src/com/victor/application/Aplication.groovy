package com.victor.application

import com.victor.trees.heaps.Heap
import com.victor.trees.heaps.MaxHeap

class Aplication<T> {

	static main(args) {
		MaxHeap<Integer> mh = new MaxHeap<>(10)
		mh.add(10)
		mh.add(8)
		mh.add(12)
		mh.add(20)
		mh.add(-2)
		mh.add(0)
		mh.add(1)
		mh.add(321)

		mh.heapSort()
	}
}

package com.victor.application

import com.victor.trees.heaps.MaxHeap

class Aplication<T> {

	static main(args) {
		MaxHeap<Integer> mh = new MaxHeap<>(10)
		mh.add(10)
		mh.add(8)
		mh.add(45)
		mh.add(20)
		mh.add(33)
		mh.add(0)
		mh.add(13)
		mh.add(321)
		println "Sorting:"
		mh.heapSort()
		println "Traversal:"
		mh.traversal()
	}
}

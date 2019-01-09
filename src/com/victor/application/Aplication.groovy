package com.victor.application

import com.victor.trees.heaps.HeapImpl
import com.victor.trees.heaps.HeapTypes

class Aplication<T> {

	static main(args) {
		HeapImpl<Integer> mh = new HeapImpl<>(20, HeapTypes.MIN)
		mh.add(1000000)
		mh.add(10)
		mh.add(100)
		mh.add(1)
		mh.add(1000)
		mh.add(100000)
		mh.add(10000)
		println "Traversal:"
		mh.traversal()

		println "\nAfter sorting"
		mh.heapSort()
		println "\nSecond traversal:"
		mh.traversal()
	}
}

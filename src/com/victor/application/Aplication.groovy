package com.victor.application

import com.victor.trees.heaps.HeapImpl
import com.victor.trees.heaps.HeapTypes

class Aplication<T> {

	static main(args) {
		HeapImpl<Integer> mh = new HeapImpl<>(11, HeapTypes.MIN)

		mh.add(318986)
		mh.add(8)
		mh.add(682)
		mh.add(71)
		mh.add(2684197)
		mh.add(41495)
		mh.add(5864)
		mh.add(14295178)
		println "Traversal:"
		mh.traversal()

		println "\nAfter sorting"
		mh.heapSort()

		println "\nSecond traversal:"
		mh.traversal()
	}
}

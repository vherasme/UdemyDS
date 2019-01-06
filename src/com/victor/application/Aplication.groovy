package com.victor.application

import com.victor.trees.heaps.HeapExercises
import com.victor.trees.heaps.HeapTypes
import com.victor.trees.heaps.HeapImpl

class Aplication<T> {

	static main(args) {
		HeapImpl<Integer> mh = new HeapImpl<>(9, HeapTypes.MIN)
		mh.add(10)
		mh.add(888)
		mh.add(45)
		mh.add(20)
		mh.add(33)
		mh.add(0)
		mh.add(13)
		mh.add(321)
		println "Traversal:"
		mh.traversal()
		
		println HeapExercises.checkHeap(mh.arrayOfNodes, HeapTypes.MIN)
	}
}

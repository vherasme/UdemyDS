package com.victor.application

import com.victor.trees.heaps.Heap
import com.victor.trees.heaps.MaxHeap

class Aplication<T> {

	static main(args) {
		MaxHeap<Integer> mh = new MaxHeap<>(10)
		mh.add(5)
		mh.add(8)
		mh.add(3)
		mh.add(27)
		mh.add(7)
		mh.add(50)
		mh.add(1)
		
		mh.poll(27)
		
		mh.traversal()
	}
}
/*50
8
27
5
7
3
1*/

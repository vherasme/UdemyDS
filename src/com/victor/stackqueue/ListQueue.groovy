package com.victor.stackqueue

import com.victor.common.Nodo

class ListQueue<T> {
	Nodo root
	int size

	void enQueue(T data) {
		size++
		if (root == null)
			root = new Nodo(data: data)
		else {
			Nodo test = root
			while (test.hasNext()) {
				test = test.nextNode
			}
			test.nextNode = new Nodo(data: data)
		}
	}

	T deQueue() {
		if (size > 0) {
			size--
			Nodo nodeToReturn = root
			root = root.nextNode
			return nodeToReturn
		}
		return null
	}

	T peek() {
		if(size > 0)
			return root
	}
}

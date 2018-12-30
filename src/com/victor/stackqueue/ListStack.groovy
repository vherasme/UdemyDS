package com.victor.stackqueue

import com.victor.common.Nodo

import groovy.transform.Canonical

@Canonical
class ListStack<T extends Comparable<T>> implements Pila<T>{

	Nodo top = null
	int size = 0

	@Override
	public void push(T element) {
		size++
		if (top == null) {
			top = new Nodo(data: element)
		} else {
			Nodo topLast = top
			top = new Nodo(data: element)
			top.previousNode = topLast
		}
	}

	@Override
	public Nodo pop() {
		Nodo elemToDelete = null
		if (size >= 1) {
			elemToDelete = top
			top = top.previousNode
			size--
		} else {
			println "ListStack is empty"
		}
		return elemToDelete;
	}

	@Override
	public int size() {
		return size
	}

	@Override
	public void traverseStack() {
		if (size > 0) {
			Nodo nodeToShow = top
			while (nodeToShow.hasPrevious()) {
				println nodeToShow.toString()
				nodeToShow = nodeToShow.previousNode
			}
			println(nodeToShow?.toString())
		} else {
			print("The stack is empty")
		}
	}

	@Override
	public void peek() {
		if (size > 0)
			println top.toString()
	}
}

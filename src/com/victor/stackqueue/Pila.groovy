package com.victor.stackqueue

import com.victor.common.Nodo

interface Pila<T> {

	void push(T element)

	Nodo pop()

	int size()

	void traverseStack()
	
	void peek()
}

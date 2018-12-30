package com.victor.linkedlists

import com.victor.common.Nodo

interface Lista<T> {

	Nodo lastNode()

	void insert(T data)

	void remove(T data)

	void traverseList()
	
	int size()
	
	Nodo getRoot()
	
}

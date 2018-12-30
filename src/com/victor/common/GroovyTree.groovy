package com.victor.common

interface GroovyTree<T> {

	void traversal()

	void insert(T data)

	void delete(T data)

	T getMax()

	T getMin()
}

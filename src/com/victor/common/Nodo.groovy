package com.victor.common;

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
public class Nodo<T extends Comparable<T>> {

	Nodo<T> nextNode;
	Nodo<T> previousNode
	T data;

	public boolean hasNext() {
		return nextNode != null
	}
	
	boolean hasPrevious() {
		return previousNode != null
	}

	@Override
	public String toString() {
		return "Nodo [data=" + data + "]";
	}
}

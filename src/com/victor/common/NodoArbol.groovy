package com.victor.common

import groovy.transform.Canonical

@Canonical
class NodoArbol<T extends Comparable<T>>{
	NodoArbol<T> rightChild
	NodoArbol<T> leftChild
	T data
}

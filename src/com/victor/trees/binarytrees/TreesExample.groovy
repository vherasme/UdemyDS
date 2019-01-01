package com.victor.trees.binarytrees

import com.victor.common.NodoArbol

class TreesExample<T extends Comparable<T>> {

	public TreesExample() {
	}

	void compareTrees(ArbolBinario<T> firstTree, ArbolBinario<T> secondTree) {
	}

	private compareNodes(NodoArbol<T> firstNode, NodoArbol<T> secondNode) {
		return firstNode != null && secondNode != null && firstNode.equals(secondNode)
	}
}

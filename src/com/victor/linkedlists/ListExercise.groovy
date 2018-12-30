package com.victor.linkedlists


import com.victor.common.Nodo

class ListExercise<T> {
	Nodo findMiddleNode(Lista lista){
		try {
			int nodeIndex = 0
			if (lista.size() % 2 == 0)
				nodeIndex = lista.size() / 2
			else
				nodeIndex = 1 + (int)(lista.size()/2)
			if (nodeIndex >= 2) {
				Nodo start = lista.root
				int counter = 1
				while (counter < nodeIndex) {
					start = start.nextNode
					counter++
				}
				println "The middle Node of $lista is $start.data"
				return start
			} else {
				if (lista.getRoot() == null)
					println "There is no node in the list"
				println "Returning: $lista.root"
				return lista.getRoot()
			}
		} catch(RuntimeException e) {
			println "Cannot find node"
			e.printStackTrace()
		}
	}

	Lista reverseList(Lista lista) {
		Lista reversedList = null
		if (lista.size() > 1) {
			reversedList = new ListaEnlazada()
			Nodo first = lista.lastNode()
			reversedList.insert(first.data)
			while (first.previousNode != null) {
				first = first.previousNode
				reversedList.insert(first.data)
			}
			return reversedList
		}
	}
}

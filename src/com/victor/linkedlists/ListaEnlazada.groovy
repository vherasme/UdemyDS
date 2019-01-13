package com.victor.linkedlists

import com.victor.common.Nodo
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class ListaEnlazada<T extends Comparable<T>> implements Lista<T> {

    Nodo<T> root
    private int sizeOfList = 0

    @Override
    Nodo<T> lastNode() {
        if (root == null) {
            return null
        } else {
            Nodo<T> test = root
            while (test.hasNext()) {
                if (test.nextNode == null) {
                    return test
                } else {
                    test = test.nextNode
                }
            }
            return test
        }
    }

    @Override
    void insert(T data) {
        sizeOfList++
        if (root == null) {
            root = new Nodo<T>(data: data)
        } else {
            lastNode().nextNode = new Nodo<T>(data: data)
        }
    }

    @Override
    void remove(T data) {
        if (root == null)
            return
        sizeOfList--
        if (root.data.compareTo(data) == 0) {
            Nodo<T> temp = root
            root = temp.nextNode
        } else {
            Nodo<T> next = root.nextNode
            deleteNode(root, next, data)
        }
    }

    private deleteNode(Nodo<T> previous, Nodo<T> current, T data) {
        while (current != null) {
            if (current.data.compareTo(data) == 0) {
                previous.nextNode = current.nextNode
                current = null
                return
            }
            previous = current
            current = current.nextNode
        }
    }

    @Override
    void traverseList() {
        if (root == null) {
            println "The list is empty"
            return
        }
        println "Traversing $this"
        Nodo<T> current = root
        while (current != null) {
            println "Nodo: " + current.data
            println "Previous: " + (current.previousNode?.data) + "\n"
            current = current.nextNode
        }
    }

    @Override
    int size() {
        return sizeOfList
    }

    @Override
    Nodo getRoot() {
        return root
    }

    @Override
    String toString() {
        return "ListaEnlazada [Root Node: " + root + ", Size =" + sizeOfList + "]"
    }
}

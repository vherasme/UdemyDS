package com.victor.linkedlists

import com.victor.common.Nodo
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class ListaDobleEnlazada<T extends Comparable<T>> implements Lista<T> {
    int sizeOfList
    Nodo root

    @Override
    void insert(T data) {
        if (root == null) {
            sizeOfList++
            root = new Nodo(data: data)
        } else {
            Nodo formerLast = lastNode()
            Nodo currentLast = new Nodo(data: data)
            formerLast.nextNode = currentLast
            currentLast.previousNode = formerLast
            sizeOfList++
        }
    }

    @Override
    void remove(T data) {
        if (root == null)
            return
        sizeOfList--
        if (root.data.compareTo(data) == 0) {
            Nodo temp = root
            setPrevious(temp)
        } else {
            Nodo next = root.nextNode
            deleteNode(root, next, data)
        }
    }

    private setPrevious(Nodo temp) {
        Nodo tempNext = temp.nextNode
        if (tempNext != null) {
            root = tempNext
            tempNext.previousNode = temp
        }
    }

    private deleteNode(Nodo previous, Nodo current, T data) {
        while (current != null) {
            if (current.data.compareTo(data) == 0) {
                Nodo next = current.nextNode
                previous.nextNode = next
                if (next != null)
                    next.previousNode = previous
                current = null
                return
            }
            previous = current
            current = current.nextNode
        }
    }

    @Override
    Nodo lastNode() {
        if (!root)
            return null
        else {
            Nodo test = root
            while (test.hasNext()) {
                test = test.nextNode
            }
            return test
        }
    }


    @Override
    void traverseList() {
        if (root == null) {
            println "The list is empty"
            return
        }
        println "Traversing $this"
        Nodo current = root
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
        return root;
    }
}

package com.victor.common

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Nodo<T extends Comparable<T>> {

    Nodo<T> nextNode
    Nodo<T> previousNode
    T data

    boolean hasNext() {
        return nextNode != null
    }

    boolean hasPrevious() {
        return previousNode != null
    }

    @Override
    String toString() {
        return "Nodo [data=" + data + "]"
    }
}

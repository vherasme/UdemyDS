package com.victor.trees.binarytrees

import com.victor.common.GroovyTree
import com.victor.common.NodoArbol

import groovy.transform.Canonical

@Canonical
class ArbolBinario<T extends Comparable<T>> implements GroovyTree<T> {

    NodoArbol root

    @Override
    void traversal() {
        if (root != null) {
            inOrderTraversal(root)
        }
    }

    private void inOrderTraversal(NodoArbol nodo) {
        if (nodo.leftChild != null) {
            inOrderTraversal(nodo.leftChild)
        }
        println "Nodo: $nodo?.data"

        if (nodo.rightChild != null) {
            inOrderTraversal(nodo.rightChild)
        }
    }

    @Override
    void insert(T data) {
        if (root == null) {
            root = new NodoArbol(data: data)
        } else {
            insertNodo(data, root)
        }
    }

    private void insertNodo(T dataNew, NodoArbol<T> fromNode) {
        if (dataNew.compareTo(fromNode.data) < 0) {
            if (fromNode.getLeftChild() != null) {
                insertNodo(dataNew, fromNode.getLeftChild())
            } else {
                fromNode.leftChild = new NodoArbol(data: dataNew)
            }
        } else if (dataNew.compareTo(fromNode.data) > 0) {
            if (fromNode.getRightChild() != null) {
                insertNodo(dataNew, fromNode.getRightChild())
            } else {
                fromNode.rightChild = new NodoArbol(data: dataNew)
            }
        }
    }

    @Override
    void delete(T data) {
        if (root != null) {
            root = deleteNode(root, data)
        }
    }

    private NodoArbol<T> deleteNode(NodoArbol<T> referenceNode, T data) {
        if (referenceNode == null)
            return referenceNode
        if (data.compareTo(referenceNode.data) < 0) {
            referenceNode.leftChild = deleteNode(referenceNode.leftChild, data)
        } else if (data.compareTo(referenceNode.data) > 0) {
            referenceNode.rightChild = deleteNode(referenceNode.rightChild, data)
        } else {
            // We have found the node we want to remove
            //1. The node is a leaf node:
            if (referenceNode.leftChild == null && referenceNode.rightChild == null) {
                return null
            }
            //2. refNode has a right child or a left child:
            if (referenceNode.leftChild == null) {
                NodoArbol<T> tempNode = referenceNode.rightChild
                referenceNode = null
                return tempNode
            } else if (referenceNode.rightChild == null) {
                NodoArbol<T> tempNode = referenceNode.leftChild
                referenceNode = null
                return tempNode
            }
            //3. The node has two children nodes:
            NodoArbol<T> tempNode = getPredecessor(referenceNode.leftChild)
            referenceNode.setData(tempNode.data)
            referenceNode.leftChild = deleteNode(referenceNode.leftChild, tempNode.data)
        }
        return referenceNode
    }

    private NodoArbol<T> getPredecessor(NodoArbol<T> nodo) {
        if (nodo.rightChild != null)
            return getPredecessor(nodo.rightChild)
        else
            return nodo
    }

    @Override
    T getMax() {
        if (root == null) {
            return null
        } else {
            return getMaxValue(root)
        }
    }

    private T getMaxValue(NodoArbol nodeToCheck) {
        if (nodeToCheck.rightChild != null) {
            getMaxValue(nodeToCheck.rightChild)
        } else {
            return nodeToCheck.getData()
        }
    }

    @Override
    T getMin() {
        if (root == null) {
            return null
        } else {
            return getMinValue(root)
        }
    }

    private T getMinValue(NodoArbol nodeToCheck) {
        if (nodeToCheck.leftChild != null) {
            getMinValue(nodeToCheck.leftChild)
        } else {
            return nodeToCheck.getData()
        }
    }
}

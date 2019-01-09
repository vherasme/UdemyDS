package com.victor.trees.heaps

class HeapImpl<T extends Comparable<T>> extends Heap<T> {

    HeapImpl(int size, HeapTypes type) {
        super(size, type)
    }

    static final Map<Enum, Closure> checkValid = new HashMap<>()
    static {
        checkValid.put(HeapTypes.MAX, { Comparable item, Comparable parentNode ->
            return item.compareTo(parentNode) > 0
        })

        checkValid.put(HeapTypes.MIN, { Comparable item, Comparable parentNode ->
            return item.compareTo(parentNode) < 0
        })
    }

    @Override
    void add(T item) {
        if (count < MAX_SIZE) {
            arrayOfNodes[count] = item
            count++
            if (count >= 2) {
                checkValidHeap(count - 1)
            }
        } else {
            throw new RuntimeException("Heap is full")
        }
    }

    @Override
    void heapSort() {
        int size = size()
        int indexToCheck = (int) count
        T[] arrayNew = (T[]) new Comparable[size]
        for (int i = 0; i < size; ++i) {
            int max = poll(indexToCheck)
            arrayNew[i] = max
            println "$max"
            indexToCheck--
        }
        arrayOfNodes = arrayNew
    }

    private void checkValidHeap(int index) {
        if (index > 0) {
            T lastitem = arrayOfNodes[index]
            int parentIndex = (index - 1).intdiv(2)
            T parentNode = arrayOfNodes[parentIndex]
            if (checkValid[heapType].call(lastitem, parentNode)) {
                swap(index, parentIndex)
                checkValidHeap(parentIndex)
            }
        }
    }

    @Override
    T remove() {
        return null
    }

    @Override
    void traversal() {
        for (int i = 0; i < arrayOfNodes.length; i++) {
            T elem = arrayOfNodes[i]
            if (elem == null)
                break
            println elem.toString()
        }
    }
}
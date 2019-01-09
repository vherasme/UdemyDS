package com.victor.stackqueue

import com.victor.common.Nodo

import groovy.transform.Canonical

@Canonical
class QSExample<T> {
    Stack<T> operations
    Stack<T> values

    QSExample() {
        operations = new Stack<>()
        values = new Stack<>()
    }

    Nodo getMaxValue(ListStack testStack) {
        if (testStack.size > 1) {
            Nodo first = testStack.top
            Nodo max = new Nodo(data: first.data)
            while (first.hasPrevious()) {
                if (first.data.compareTo(max.data) > 0) {
                    max = new Nodo(data: first.data)
                }
                first = first.previousNode
            }
            return max
        } else if (testStack.size() == 1) {
            return testStack.top
        } else {
            return null
        }
    }

    void dijkstraExample(String expression) {
        String[] expressionArray = expression.split("\\s+")
        for (x in expressionArray) {
            if (x.equals("("))
                continue
            else if (x.equals("+"))
                operations.push(x)
            else if (x.equals("*"))
                operations.push(x)
            else if (x.equals(")")) {
                String operation = operations.pop()
                if (operation.equals("+")) {
                    values.push(values.pop() + values.pop())
                } else if (operation.equals("*")) {
                    values.push(values.pop() * values.pop())
                }
            } else {
                values.push(Double.parseDouble(x))
            }
        }
    }
}

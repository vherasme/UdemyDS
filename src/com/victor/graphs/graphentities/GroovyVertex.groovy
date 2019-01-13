package com.victor.graphs.graphentities

class GroovyVertex<T> {
    T xValue
    T yValue
    List<GroovyVertex> adjacencyList

    GroovyVertex(T x, T y) {
        xValue = x
        yValue = y
    }

    GroovyVertex() {

    }
}

package com.victor.graphs.graphentities

class GroovyEdge<T> {
    GroovyVertex beginning
    GroovyVertex end

    GroovyEdge(GroovyVertex b, GroovyVertex e) {
        beginning = b
        end = e
    }
}

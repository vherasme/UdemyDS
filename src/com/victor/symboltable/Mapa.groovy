package com.victor.symboltable

interface Mapa<T, R> {

    void put(T key, R value)

    R get(T key)

    boolean contains(T key)
}
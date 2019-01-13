package com.victor.common

import groovy.transform.Canonical
import groovy.transform.TupleConstructor

@Canonical
@TupleConstructor
class Person implements Comparable<Person> {

    int age
    String firstName
    String lastName


    Person() {
    }

    @Override
    int compareTo(Person o) {
        return age.compareTo(o.age)
    }

    @Override
    String toString() {
        return "Person [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]"
    }
}

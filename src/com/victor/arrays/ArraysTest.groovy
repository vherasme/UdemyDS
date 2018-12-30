package com.victor.arrays

import groovy.transform.Canonical

@Canonical
class ArraysTest<T> {

	List<T> reverseArray(List<T> inputArray) {
		int j = inputArray.size() - 1
		def outPutArray = new T[j+1]
		for (int i =0; i < j; i++) {
			int temp = inputArray.get(i)
			outPutArray[i] = inputArray.get(j)
			outPutArray[j] = temp
			j--
		}
		return Arrays.asList(outPutArray)
	}

	boolean testAnagram(List<Character> word, List<Character> anagram) {
		def orderedWord = word.sort()
		def orderedAnagram = anagram.sort()
		return orderedWord.equals(orderedAnagram)
	}

	void duplicateFind(List<T> evaluateArray) {
		def arrayDuplicates = [:]
		for (int i =0; i < evaluateArray.size(); i++) {
			def test = evaluateArray.get(i)
			if (arrayDuplicates[test]) {
				def duplicate = arrayDuplicates[test]
				println "$test is found both at $duplicate and at $i"
				return
			} else {
				arrayDuplicates.put(test, i)
			}
		}
		println "Found no duplicates"
	}
}

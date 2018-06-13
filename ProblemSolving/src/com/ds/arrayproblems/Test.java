package com.ds.arrayproblems;

import java.util.HashSet;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {

		int arr[] = { 5, 22, 5, 1, 22, 34, 16, 16, 36, 2 };
		HashSet<Integer> hasSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			hasSet.add(arr[i]);
		}
		Iterator<Integer> itr=hasSet.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+ " ");
		}
	}
}

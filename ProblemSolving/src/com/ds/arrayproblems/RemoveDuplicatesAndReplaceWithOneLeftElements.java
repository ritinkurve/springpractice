package com.ds.arrayproblems;

/* Remove Duplicates and Replace them with 1 and shift all 1's to left side of array 
 *  input =[5,22,5,1,22,34,16]
 *  output=[1,1,1,1,1,34,16]
 * */

public class RemoveDuplicatesAndReplaceWithOneLeftElements {

	public static void main(String[] args) {

		int arr[] = { 5, 22, 5, 1, 22, 34, 16 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i]==1) {
					continue;
				}
				if (arr[i] == arr[j]) {
					arr[i] = 1;
					arr[j] = 1;
				}
			}
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int temp = 1;
			if (arr[i] != 1 && arr[i + 1] == 1) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

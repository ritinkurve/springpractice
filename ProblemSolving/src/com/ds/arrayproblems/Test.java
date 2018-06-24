package com.ds.arrayproblems;

public class Test {
	public static void main(String[] args) {
		int a = 12;
		int b = 4;
		System.out.println(a);
		if (a % b == 0) {
			while (a % b == 0) {
				a = a / b;
			}
				b = b / b;
			
		}else {
			while (a % 2 == 0) {
				a = a / 2;
			}
			while (b % 2 == 0) {
				b = b / 2;
			}
		}
		System.out.println(a);
		System.out.println(b);
	}
}

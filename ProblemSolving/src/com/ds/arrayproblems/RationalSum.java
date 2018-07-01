package com.ds.arrayproblems;
import java.util.*;
public class RationalSum {
	public String[] convertToMinimum(String[] arr) {
		String newarr[]=new String[arr.length];
		for(int i=0;i<arr.length;i++) {
			String splited[]=arr[i].split(" ");
			int a=Integer.parseInt(splited[0]);
			int b=Integer.parseInt(splited[1]);
			if(a>b && a%b==0) {
				a=a/b;
				b=b/b;
			}else if(a<b && b%a==0){
				b=b/a;
				a=a/a;
			}
			else{
				while(a%2==0) {
					while (a % 2 == 0) {
						a = a / 2;
					}
					while (b % 2 == 0) {
						b = b / 2;
					}
				}
			}
			newarr[i]=a+" "+b;
			System.out.println(a+" "+b);
		}
		return newarr;
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		RationalSum r=new RationalSum();
		int input=scan.nextInt();
		scan.nextLine();
		String array[]=new String[input]; 
		for(int i=0;i<input;i++) {
			array[i]=scan.nextLine();
		}
		r.convertToMinimum(array);
	}

}

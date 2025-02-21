package com.vn.utils;

public class FibonacciSeries {

	public static void main(String[] args) {		
		int fs[] = new FibonacciSeries().printFibonacciSeries(5);		
		
		for (int t : fs) System.out.println(t);
		System.out.println(fs[4]);
	}
	
	private int[] printFibonacciSeries( int n ) {
		int fs[] = new int[n];
		if (n==0) return fs;
		fs[0] = 0; 
		if (n==1) return fs;
		
		fs[1] = 1;
		
		for (int i=2;i<=n-1;i++) {
			fs[i] = fs[i-1] + fs[i-2];
			
		}
		return fs;
	}

}

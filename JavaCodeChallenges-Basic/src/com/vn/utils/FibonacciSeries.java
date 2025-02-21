package com.vn.utils;

public class FibonacciSeries {

	public static void main(String[] args) {
		long fs[] = new FibonacciSeries().printFibonacciSeries(10);
		for (long t : fs)
			System.out.print(" " + t);
		System.out.println("\n" + fs[2]);
	}

	private long[] printFibonacciSeries(int n) {
		long fs[] = new long[n];
		if (n == 0)
			return fs;
		fs[0] = 0;
		if (n == 1)
			return fs;
		fs[1] = 1;
		for (int i = 2; i <= n - 1; i++) {
			fs[i] = fs[i - 1] + fs[i - 2];
		}
		return fs;
	}
}
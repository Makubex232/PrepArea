package com.yogi.recursion;

public class Fibanocci {

	public static int cacheMem[] = new int[100] ;
	public static void main(String args[]) {
		
		cacheMem[0] = 0 ;
		cacheMem[1] = 1 ;
		int maxLength = 10 ;
		for(int i=0; i<maxLength; i++) {
			System.out.print(fibanocciRecursion(i)+"\t");	
		}
		System.out.println();
		fibanocci(maxLength) ;
		
		System.out.println();
		for(int i=0 ; i<maxLength; i++) {
			System.out.print(fibanocciRecursionMemory(i)+"\t") ;
		}
		
	}

	/*
	 * This way is intuitive and easy to understand, 
	 * while because it does not reuse calculated Fibonacci number, 
	 * the time complexity is about O(2^n), but it does not store calculated result, 
	 * so it saves space a lot, actually the space complexity is O(1)
	*/
	public static int fibanocciRecursion(int num) {
		if(num<2) {
			return num ;
		}
		return fibanocciRecursion(num-1) + fibanocciRecursion(num-2) ;
	}
	
	/*
	 * With time complexity O(n), and space complexity O(1).
	*/	
	public static void fibanocci(int num) {
		int m = 0, n=1, oldM ;
		System.out.print("0\t1\t");
		for(int i=2; i<num ; i++) {
			oldM = m ;
			m = n ;
			n = m + oldM ;
			System.out.print(n+"\t");
		}

	}

	
	/*
	 * The time complexity is pretty good, which is O(n), while space complexity is O(n). 
	 * Let's investigate whether the space complexity can be optimized... 
	 * Since f(i) only requires f(i - 1) and f(i - 2), 
	 * there is not necessary to store all calculated Fibonacci numbers.
	*/
	public static int fibanocciRecursionMemory(int num) {
		if(num!=0 && cacheMem[num]==0) {
			cacheMem[num] = fibanocciRecursionMemory(num-1) + fibanocciRecursionMemory(num-2) ;
		}
		return cacheMem[num] ;
	}
}

package com.yogi.array;

/*
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5. 
*/
public class MaximumAbsoluteDifference {

	public static void main(String args[]) {
		MaximumAbsoluteDifference mad = new MaximumAbsoluteDifference();
//		int[] inputArray = {1, 3, -1} ;
		int[] inputArray = {-1} ;
		System.out.println(mad.findMaximumAbsoluteDifference(inputArray));
		System.out.println(mad.findOptimalMaximumAbsoluteDifference(inputArray));
	}
	
	
	private int findMaximumAbsoluteDifference(int[] inputArray) {
		int maximum = 0 ;
		int inputLength = inputArray.length ;
		
		for(int i=0; i<inputLength; i++) {
			for(int j=i+1; j<inputLength; j++) {
				maximum = Math.max(maximum,computeValue(inputArray[i],inputArray[j],i,j));
			}
		}
		
		return maximum ;
	}
	
	private int computeValue(int a, int b, int i, int j) {
		return Math.abs(a-b) + Math.abs(i-j) ;
	}
	
	private int findOptimalMaximumAbsoluteDifference(int[] inputArray) {
		int inputLength = inputArray.length ;
		int max1 = Integer.MIN_VALUE ;
		int max2 = Integer.MIN_VALUE ;
		int min1 = Integer.MAX_VALUE ;
		int min2 = Integer.MAX_VALUE ;
		
		for(int i=0; i<inputLength; i++) {
			max1 = Math.max(max1, inputArray[i]+i) ;
			min1 = Math.min(min1, inputArray[i]+i) ;
			max2 = Math.max(max2, inputArray[i]-i) ;
			min2 = Math.min(min2, inputArray[i]-i) ;
		}
		
		return Math.max((max1-min1), (max2-min2)) ;
	}
}

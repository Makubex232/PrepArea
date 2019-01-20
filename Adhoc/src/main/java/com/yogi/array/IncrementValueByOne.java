package com.yogi.array;

import java.util.Arrays;

public class IncrementValueByOne {

	public static void main(String args[]) {
//		int[] input = {1,3,5,2};
		int[] input = {1,3,5,9};
//		int[] input = {9,9,9,9};
//		int[] input = {0,9,9,9,9};
//		int[] input = {0,8,9,9,9};
		System.out.println(Arrays.toString(incrementArrayByOne(input)));
	}

	/*
	 * Time complexity is O(n) since each element in the input array is iterated once.
	 * Space complexity is O(n) since the existing array is incremented into new array.
	*/
	public static int[] incrementArrayByOne(int[] inputArray) {
		int inputSize = inputArray.length ;
		int[] resultArray = new int[inputSize] ;
		int carryOver = 1 ;
		
		for(int i=inputSize-1 ; i>=0 ; i--) {
			int incr = inputArray[i] + carryOver  ;
			if(incr>9) {
				resultArray[i] = 0 ;
				carryOver = 1 ;
			}
			else {
				resultArray[i] = incr ;
				carryOver = 0 ;
			}
		}
		
		if(carryOver == 1 ) {
			int[] finalArray = new int[inputSize+1];
			finalArray[0] = 1 ;
			for(int i=1; i<finalArray.length; i++) {
				finalArray[i] = resultArray[i-1] ;
			}
			return finalArray ;
		}else {
			boolean nonZero = false ;
			int nonZeroIndex = 0 ;
			for(; nonZeroIndex<resultArray.length; nonZeroIndex++) {
				if(resultArray[nonZeroIndex]!=0) {
					break ;
				}
			}
			int len = resultArray.length - nonZeroIndex ;
			int[] nonZeroResult = new int[len] ;
			for(int i=0; i<len; i++) {
				nonZeroResult[i] = resultArray[nonZeroIndex+i];
			}
			return nonZeroResult ;
		}
		
//		return resultArray ;
	}
	
}

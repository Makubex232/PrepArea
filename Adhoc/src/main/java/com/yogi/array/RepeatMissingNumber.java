package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
*/public class RepeatMissingNumber {

	public static void main(String args[]) {
		RepeatMissingNumber rmn = new RepeatMissingNumber();
//		int[] inputArray = {3,1,2,5,3} ;
		int[] inputArray = {1,2,3,4,5,6,7,8,9,5} ;
 		System.out.println(Arrays.toString(rmn.repeatedNumber(inputArray)));
 		System.out.println(Arrays.toString(rmn.optimiseRepeatedNumber(inputArray)));
	}
	
	private int[] repeatedNumber(int[] inputArray) {
		int[] output = new int[2] ;
		int inputLength = inputArray.length ;
		List<Integer> uniqueList = new ArrayList<>();
		boolean duplicateFound = false ;
		long expectedSum = 0 ;
		long actualSum = 0 ;
		
		for(int i=0; i<inputLength; i++) {
			if(!duplicateFound && uniqueList.contains(inputArray[i])) {
				output[0] = inputArray[i] ;
				duplicateFound = true ;
			}
			uniqueList.add(inputArray[i]) ;
			expectedSum = expectedSum + i + 1 ;
			actualSum = actualSum + inputArray[i] ;
		}
		int duplicateItem = (int) (inputLength+1  - (expectedSum - actualSum)) ;
		int missingItem = (int) (expectedSum - (actualSum - duplicateItem));
//		System.out.println("expectedsum "+expectedSum+"\tactualsum "+actualSum+"\tduplicate "+output[1]);
		System.out.println("duplicateItem "+duplicateItem +"\tmissingItem "+missingItem);
		output[1] = (int) (expectedSum - (actualSum - output[0])) ;
		
		return output ;
	}
	
	
	private int[] optimiseRepeatedNumber(int[] inputArray) {
		int[] output = new int[2] ;
		int inputLength = inputArray.length ;
		int[] inputCopy = new int[inputLength];
		int duplicateValue = 0 ;
		long expectedSum = 0 ;
		long actualSum = 0 ;
		
		for(int i=0; i<inputLength; i++) {
			int inputValue = inputArray[i] ;
			if(inputCopy[inputValue-1]!=0) {
				duplicateValue = inputValue  ;
			}
			
			inputCopy[inputValue-1] = 1 ; 
			expectedSum = expectedSum + i + 1 ;
			actualSum = actualSum + inputValue ;
		}
		
		output[0] = duplicateValue ; 
		output[1] = output[1] = (int) (expectedSum - (actualSum - output[0])) ;
		return output ;
	}
	
	
}

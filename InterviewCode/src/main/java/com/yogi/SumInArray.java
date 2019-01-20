package com.yogi;

/*
 * Question : 
 * Given an input array and a number n, We need to find the number of subsets in the array which sums up to n.
 * eg; 
 * Input : [2,4,6,10],  16
 * Output : 2
 * Explaination : [2,4.10] and [6,10] forms the subset which sums up to 16. Hence the ans is 2 subsets.
*/
public class SumInArray {
	
	public static void main(String args[]) {
		int[] inputArray = {2,4,6,10} ;
		int sumValue = 16 ;
//		numberOfSubsetsInArray(inputArray,sumValue) ;
		
	}

	private static int numberOfSubsetsInArray(int[] inputArray, int sumValue) {
		int count = 0 ;
		int inputLength = inputArray.length ;
		
		for(int i=inputLength; i>0 ; i-- ) {
			count += recursiveSubsetValidation(inputArray,inputLength,i);
		}
		
		return count ;
	}
	
	private static int recursiveSubsetValidation(int[] inputArray,int actualSize, int runSize) {
		int iterCount = combinationCount(actualSize,runSize);
//		formInput(inputArray,actualSize,runSize) ; 
		for(int i=0; i<iterCount; i++) {
			
		}
		
		return 0 ;
	}
	
	private static int combinationCount(int n, int r) {
		int numerator = factorial(n) ;
		int denominator = factorial(n-r) * factorial(r) ;
		
		return numerator / denominator ;
	}
	
	private static int factorial(int n) {
		int fact = 1 ;
		for(int i=1; i<=n; i++) {
			fact = fact * i ;
		}
		return fact ; 
	}
}

package com.yogi.array;

import java.util.Arrays;

public class Wave {

	public static void main(String args[]) {
		Wave w = new Wave();
//		int[] inputArray = {1,2,3,4} ;
//		int[] inputArray = {1,2,3,4,5} ;
		int[] inputArray = {1} ;
		System.out.println(Arrays.toString(w.generateWaveOutput(inputArray)));
	}
	
	public int[] generateWaveOutput(int[] inputArray) {
		int inputLength = inputArray.length ;
		int[] resultArray = new int[inputLength] ;
		Arrays.sort(inputArray) ;
		if(inputLength == 1 ) {
			return inputArray ;
		}
		
		for(int i=1; i<inputLength; i=i+2) {
			resultArray[i-1] = inputArray[i] ;
			resultArray[i] = inputArray[i-1] ;
		}
		
		if(inputLength%2 == 1) {
			resultArray[inputLength-1] = inputArray[inputLength-1] ;
		}
		
		return resultArray ;
	}
	
	
	
}

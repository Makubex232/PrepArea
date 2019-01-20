package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

	public static void main(String args[]) {
		MaxNonNegativeSubArray mnnsa = new MaxNonNegativeSubArray();
		int[] inputArray = {4,8,-1,-3,2,3,7,-7,5,1} ;
//		int[] inputArray = {1,2,5,6,-7,2,3,-1,5,2,7} ;
//		int[] inputArray = {4,8,-1,8,4,-7,5,1} ;
//		int[] inputArray = {-1,-3,-4} ;
//		int[] inputArray = {0, 0, -1, 0} ;
//		int[] inputArray = {-846930886, -1714636915, 424238335, -1649760492} ;
//		int[] inputArray = {1967513926, 1540383426, -1303455736, -521595368} ;
//		int[] inputArray = {756898537, -1973594324, -2038664370, -184803526, 1424268980} ;
//		int[] inputArray = {5 , 4, -1 , 4, 10} ;
//		int[] inputArray = {1,2,-1,4,3,-2,9,5,3} ;
//		int[] inputArray = {25150, 1412, 82797, 48381, 7065, -47699, -25129, -65483, -64607, -45322, -55176, 27224, 80366, 60444, 70285, -93898, -41133, 96576, -58266, 21711, -20614, -95737, 20591, -48762, -76197, -38588, -54873, 37304, 61200, -68960, 93947} ;
//		System.out.println(Arrays.toString(mnnsa.maxSet(inputArray)));
		System.out.println(Arrays.toString(mnnsa.maxSubSet(inputArray)));
	}
	
	public int[] maxSubSet(int[] inputArray) {
		int inputLength = inputArray.length ;
		long currentSum = 0 ;
		long maxSum = 0 ;
		List<CountIndex> ciList = new ArrayList<>() ;
		int currentStartIndex = 0 ;
		int startIndex = 0 ;
		int endIndex = 0 ;
		int counter = 0 ;
		int negativeCounter = 0 ;
		int maxCounter = 0 ;
		int currentEndIndex = 0 ;
		long maxElement = inputArray[0] ;
		long previousMax = inputArray[0] ;
		
//		int[] inputArray = {756898537, -1973594324, -2038664370, -184803526, 1424268980} ;
//		int[] inputArray = {5 , 4, -1 , 4, 10} ;
		for(int i=0; i<inputLength; i++) {
			maxElement = Math.max(inputArray[i], maxElement);
			negativeCounter = inputArray[i]<0 ? negativeCounter-1 : 0 ;
			counter = inputArray[i]>=0 ? counter+1 : 0 ; 
			
			if(negativeCounter == -1) {
				previousMax = Math.max(previousMax, currentSum);
				currentEndIndex = i ;
			}
			currentSum = inputArray[i]<0 ? 0 : currentSum + inputArray[i] ; 
//			if(currentSum>maxSum) {
//				int previousMax = maxSum ;
//			}
			maxSum = Math.max(maxSum, currentSum) ;
			
			if(counter==1) {
				currentStartIndex = i ;
			}
			
			
			if(currentSum==maxSum) {
				if(previousMax==currentSum ) {
					if(counter>maxCounter) {
						startIndex = currentStartIndex ;
						endIndex = i ;
						maxCounter = counter ;
					}
				}
				else {
					startIndex = currentStartIndex ;
					endIndex = i ;
					maxCounter = counter ;
				}
			}
			
			
		}
//		System.out.println("startIndex : "+startIndex+"\tendIndex : "+endIndex);
		int[] result = new int[endIndex - startIndex + 1] ;
		int j=0 ;
		for(int i=startIndex; i<=endIndex; i++) {
			result[j] = inputArray[i] ;
			j++ ;
		}
		
		if(maxElement<0) {
			return new int[] {} ;
		}
		
		return result ;
	}
	
	private int[] maxSet(int[] inputArray) {
		int inputLength = inputArray.length ;
		long currentSum = 0 ;
		long maxSum = 0 ;
		int startIndex = 0 ;
		int endIndex = 0 ;
		int currentStartIndex = 0;
		int currentEndIndex = 0 ;
		int indexCounter = 0 ;
		int maxCounter = 0 ;
		long maxValue = inputArray[0] ;
		long currentMax = inputArray[0] ;
		
		for(int i=0; i<inputLength; i++) {
			maxValue = Math.max(maxValue, inputArray[i]);
			if(inputArray[i]>=0) {
				currentSum += inputArray[i] ;
				indexCounter++ ;
			}else {
				currentSum = 0 ;
				currentStartIndex = i+1 ;
				indexCounter = 0 ;
			}
			
			currentSum = Math.max(currentSum, 0) ;
			maxSum = Math.max(maxSum, currentSum) ;
			
			if(currentSum == maxSum && indexCounter>=maxCounter) {
				if( maxSum>currentMax ) {
					currentMax = maxSum ;
					endIndex = i ;
				}
				if(maxSum==0 && currentMax==0) {
					currentMax = maxSum ;
					endIndex = i ;
				}
				if(maxSum!=0) {
					currentMax = maxSum ;
					endIndex = i ;
				}
			}
			if(endIndex>=currentStartIndex) {
				startIndex = currentStartIndex ;
			}
			maxCounter = Math.max(maxCounter, indexCounter) ;
			System.out.println("input : "+inputArray[i]+"\tcurrentSum : "+currentSum+"\tmaxSum : + "+maxSum+"\tcurrentStartIndex : "+currentStartIndex+"\tstartIndex : "+startIndex+"\tendIndex : "+endIndex+"\tindexCounter : "+indexCounter+"\tmaxCounter : "+maxCounter);
			
		}
		
		System.out.println("startIndex : "+startIndex+"\tendIndex : "+endIndex);
		int result[] = new int[endIndex - startIndex + 1];
		int j=0 ;
		for(int i=startIndex; i<=endIndex; i++) {
			result[j] = inputArray[i] ;
			j++ ;
		}
		
		if(maxValue<0) {
			return new int[] {} ;
		}else {
			return result ;	
		}
		
	}
	
	class CountIndex{
		int startIndex ;
		int endIndex ;
		int count ;
		public int getStartIndex() {
			return startIndex;
		}
		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}
		public int getEndIndex() {
			return endIndex;
		}
		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		
	}
	
	
}

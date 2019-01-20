package com.yogi.array;

public class ArrayCycle {

	public static void main(String args[]) {
//		int[] inputArray = {1,2,1,5,3,6} ;
		int[] inputArray = {10,2,3,4,5,1,3} ;
		System.out.println("Input array is cyclic :: "+isArrayCyclic(inputArray));
	}
	
	/*
	 * Assumption : There is no negative/zero input.
	 * This method iterates through all the values of the array sets it to negative (*-1). 
	 * If the array holds cyclic index, then it'll come across negative value with is set in the first iteration of that index. 
	*/	
	public static boolean isArrayCyclic(int[] inputArray) {
		System.out.println("len "+inputArray.length);
		int index = 0 ;
		for(int i=0; i<inputArray.length; i++) {
			System.out.println("i --> "+i+"\tinput --> "+inputArray[i]);
			if(index<inputArray.length && inputArray[index]<0) {
				System.out.println("Cyclic index is "+index );
				return true;
			}
			if(index>inputArray.length) {
				index = i+1 ;
			}else {
				inputArray[index] = inputArray[index] * -1 ;
				index = inputArray[index] * -1 ;
				
			}
			
		}
		
		return false ;
	}

	
	public static boolean isCyclic(int[] inputArray) {
		int rabbit = 0 , tortoise = 0 ;
		
		
		
		return false ;
	}
}

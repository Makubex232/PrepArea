package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
*/
public class FindDuplicate {

	public static void main(String args[]) {
		FindDuplicate fd = new FindDuplicate() ;
		Integer[] inputArray = {3,4,1,4,1};
		List<Integer> inputList = new ArrayList<>(Arrays.asList(inputArray));
		System.out.println(fd.getDuplicate(inputList) );
	}

	/*
	 * Time complexity is O(n) since we iterate through 1 to n.
	 * Space complexity is O(n) since we maintain a duplicate input.
	*/
	public int getDuplicate(List<Integer> inputList) {
		int inputSize = inputList.size() ;
		int[] duplicateInput = new int[inputSize] ;
		
		for(int i=0; i<inputSize; i++) {
			int inputItem = inputList.get(i) ;
			if(duplicateInput[inputItem]!=0) {
				return inputItem ;
			}
			duplicateInput[inputItem] = 1 ; 
		}
		
		return -1 ;
	}
}

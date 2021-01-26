package com.yogi;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.yogi.array.IncrementValueByOne;
import com.yogi.array.MaxNonNegativeSubArray;

public class IncrementValueByOneTest {

	@Test
	@DisplayName("Straight line scenario")
	public void straightLineScenario() {
		int[] input = {1,3,5,2};
		int[] output = {1,3,5,3} ;
		assertArrayEquals(output,IncrementValueByOne.incrementArrayByOne(input));
	}
	
	@Test
	@DisplayName("Carry over scenario")
	public void carryOverScenario() {
		int[] input = {1,3,5,9};
		int[] output = {1,3,6,0} ;
		assertArrayEquals(output,IncrementValueByOne.incrementArrayByOne(input));
	}
	
	@Test
	@DisplayName("Carry over extra index")
	public void extraIndexScenario() {
		int[] input = {9,9,9};
		int[] output = {1,0,0,0} ;
		assertArrayEquals(output,IncrementValueByOne.incrementArrayByOne(input));
	}
	
	
	@Test
	@DisplayName("Max non negative subset")
	public void nonNegativeSubset() {
		MaxNonNegativeSubArray mnnsa = new MaxNonNegativeSubArray();
		
		int[] inputArray1 = {4,8,-1,-3,2,3,7,-7,5,1} ;
		int[] outputArray1 = {2,3,7} ;
//		assertEquals()
		assertArrayEquals(mnnsa.maxSubSet(inputArray1), outputArray1);
		
		int[] inputArray2 = {1,2,5,6,-7,2,3,-1,5,2,7} ;
		int[] outputArray2 = {1,2,5,6} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray2), outputArray2);
		
		int[] inputArray3 = {4,8,-1,8,4,-7,5,1} ;
		int[] outputArray3 = {4,8} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray3), outputArray3);
		
		int[] inputArray4 = {-1,-3,-4} ;
		int[] outputArray4 = {} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray4), outputArray4);
		
		int[] inputArray5= {0, 0, -1, 0} ;
		int[] outputArray5 = {0,0} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray5), outputArray5);
		
		int[] inputArray6 = {-846930886, -1714636915, 424238335, -1649760492} ;
		int[] outputArray6 = {424238335} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray6), outputArray6);
		
		int[] inputArray7 = {1967513926, 1540383426, -1303455736, -521595368} ;
		int[] outputArray7 = {1967513926, 1540383426} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray7), outputArray7);
		
		int[] inputArray8 = {756898537, -1973594324, -2038664370, -184803526, 1424268980} ;
		int[] outputArray8 = {1424268980} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray8), outputArray8);
		
		int[] inputArray9 = {1,2,-1,4,3,-2,9,5,3} ;
		int[] outputArray9 = {9,5,3} ;
		assertArrayEquals(mnnsa.maxSubSet(inputArray9), outputArray9);
		
//		int[] inputArray10 = {25150, 1412, 82797, 48381, 7065, -47699, -25129, -65483, -64607, -45322, -55176, 27224, 80366, 60444, 70285, -93898, -41133, 96576, -58266, 21711, -20614, -95737, 20591, -48762, -76197, -38588, -54873, 37304, 61200, -68960, 93947} ;
//		int[] outputArray10 = {2,3,7} ;
//		assertArrayEquals(inputArray1, outputArray1);
		
	}
	
	
}

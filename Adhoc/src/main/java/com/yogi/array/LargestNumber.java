package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

	public static void main(String args[]) {
		LargestNumber ln = new LargestNumber();
//		int[] inputArray = { 3, 30, 34, 5, 9 };
//		int[] inputArray = { 90, 92, 34, 5, 9 };
		int[] inputArray = { 0,0,0,0 };
		System.out.println(ln.findLargestNumber(inputArray));
	}

	public String findLargestNumber(int[] inputArray) {
		int inputLength = inputArray.length;
		int maxNum = 0 ;
		List<NumberSort> numberList = new ArrayList<>();

		for (int i = 0; i < inputLength; i++) {
			maxNum = Math.max(inputArray[i], maxNum) ;
			NumberSort ns = new NumberSort();
			ns.setNum(inputArray[i]);
			numberList.add(ns);
		}

		if(maxNum<=0) {
			return "0";
		}
		
		Collections.sort(numberList);
		StringBuffer result = new StringBuffer();
		for (NumberSort ns : numberList) {
			result.append(ns.getNum());
		}
		return result.toString();
	}

	class NumberSort implements Comparable<NumberSort> {

		Integer num;

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		@Override
		public int compareTo(NumberSort inputArg) {
			// TODO Auto-generated method stub
			String sNum1 = this.num.toString();
			String sNum2 = inputArg.num.toString();
			String val1 = sNum1 + sNum2;
			String val2 = sNum2 + sNum1;
//			System.out.println("Comparing val1 " + val1 + "\tval2 " + val2 + "\t result " + val2.compareTo(val1));
			return val2.compareTo(val1);
		}

	}

}

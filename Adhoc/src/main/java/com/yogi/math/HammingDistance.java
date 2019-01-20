package com.yogi.math;

import java.util.ArrayList;
import java.util.Arrays;

public class HammingDistance {

	public static void main(String args[]) {
		HammingDistance hd = new HammingDistance();
//		Integer[] input = {2,4,6} ;
//		Integer[] input = {96, 96, 7, 81, 2, 13};
//		Integer[] input = {4,4};
//		Integer[] input = {2,96};
		Integer[] input = {96, 96, 7, 81, 2, 13};
		ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(input));
		
		System.out.println(hd.findHammingDistance(inputList));
//		System.out.println(hd.computeHammingDistance(2, 7));
	}
	
	public int findHammingDistance(ArrayList<Integer> inputList) {
		int inputSize = inputList.size() ;
		int result = 0 ;
		
		for(int i=0; i<inputSize; i++) {
			for(int j=0; j<inputSize; j++) {
				int distance = computeHammingDistance(inputList.get(i),inputList.get(j)) ;
//				System.out.println(inputList.get(i)+"\t"+inputList.get(j)+"\t"+distance);
				result += distance ; 
			}
		}
		
		return result ;
	}
	
	public int computeHammingDistance(Integer a, Integer b) {
		int result = 0 ;
		String s1 = Integer.toBinaryString(a);
		String s2 = Integer.toBinaryString(b);
		int i = s1.length()-1 ;
		int j = s2.length()-1 ;
		while(i>=0 && j>=0) {
			if(s1.charAt(i)!=s2.toString().charAt(j)) {
				result++ ;
			}
			i-- ;
			j-- ;
		}
		
		while(i>=0) {
			if(s1.charAt(i)!='0') {
				result++ ;
			}
			i-- ;	
		}
		
		while(j>=0) {
			if(s2.charAt(j)!='0') {
				result++ ;
			}
			j-- ;	
		}
//		i++; j++;
//		System.out.println(a+"\t"+b+"\t"+s1+"\t"+s2+"\t"+(result));
		return result ;
	}
}

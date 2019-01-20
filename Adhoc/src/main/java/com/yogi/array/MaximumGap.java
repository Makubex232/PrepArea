package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumGap {

	public static void main(String args[]) {
		MaximumGap mg = new MaximumGap();
		Integer input[] = {1,10,5} ;
		List<Integer> inputList = new ArrayList<>(Arrays.asList(input));
		System.out.println(mg.findMaximumGap(inputList)) ;
		System.out.println(mg.findGap(inputList)) ;
	}
	
	public int findMaximumGap(List<Integer> inputList) {
		int maximumGap = 0 ;
		if(inputList.size()<2) {
			return 0 ;
		}
		Collections.sort(inputList);
		for(int i=1; i<inputList.size(); i++) {
			int diff = inputList.get(i) - inputList.get(i-1);
			maximumGap = Math.max(maximumGap, diff) ;
		}
		
		return maximumGap ;
	}
	
	
	public int findGap(List<Integer> inputList) {
		if(inputList.size()<2) {
			return 0 ;
		}
		
		int min = Math.min(inputList.get(0),inputList.get(1)) ;
		int max = Math.max(inputList.get(0),inputList.get(1)) ;
		int diff = max - min  ;		
		for(int i=2; i<inputList.size(); i++) {
			int inputItem = inputList.get(i) ;
//			System.out.println("min "+min+"\tmax "+max+"\tinputItem "+inputItem);
			if(inputItem>max && inputItem-max > diff) {
				min = max ;
				max = inputItem ;
			}
 			if(inputItem>min && inputItem<max) {
				if(inputItem-min>max-inputItem) {
					max = inputItem ;
				}else {
					min = inputItem ;
				}
			}
 			if(inputItem<min && inputItem-min > diff ) {
 				max = min ;
 				min = inputItem ;
 			}
 			diff = max-min ;
		}
		diff = max - min  ;
		
		return diff ;
	}
}

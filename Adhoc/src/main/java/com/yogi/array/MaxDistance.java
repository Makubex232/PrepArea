package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxDistance {

	public static void main(String args[]) {
		MaxDistance md = new MaxDistance();
//		Integer[] inputArray = {3,5,4,2} ;
//		Integer[] inputArray = {3,3,5,4,2} ;
//		Integer[] inputArray = {10,10,10,10,10,2} ;
		Integer[] inputArray = {2,3,5,7,3,1} ;
		ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(inputArray)) ;
		System.out.println(md.maximumGapBruteForce(inputList)) ;
		System.out.println(md.maximumGap(inputList)) ;
	}
	
	public int maximumGapBruteForce(List<Integer> inputList) {
		int maxDistance = 0 ;
		if(inputList.size()==1) {
			return inputList.get(0);
		}
		for(int i=0; i<inputList.size(); i++) {
			int lVal = inputList.get(i) ;
			for(int j=inputList.size()-1; j>i; j--) {
				int rVal = inputList.get(j) ;
				if(lVal<=rVal && j-i >maxDistance) {
					maxDistance = j-i ;
				}
			}
		}
		
		return maxDistance ;
	}
	
	public int maximumGap(List<Integer> inputList) {
		int maxValue = 0 ;
		List<Distance> distanceList = new ArrayList<>();
		
		for(int i=0; i<inputList.size(); i++) {
			Distance d = new Distance();
			d.setVal(inputList.get(i));
			d.setIndex(i);
			distanceList.add(d) ;
		}
		
		Collections.sort(distanceList) ;
		
		for(int i=0; i<distanceList.size()-1; i++) {
			int val = distanceList.get(i).getVal() ;
			int index = distanceList.get(i).getIndex() ;
			int nextIndex = distanceList.get(i+1).getIndex() ;
			System.out.println("value "+val+"\tindex "+index);
			if(index<nextIndex && nextIndex-index >= maxValue) {
				maxValue = nextIndex-index ;
			}
		}
		System.out.println("maxValue "+maxValue);
		return 0 ;
	}
	
	class Distance implements Comparable<Distance>{

		Integer val ; 
		Integer index ;
		
		public void setVal(Integer val) {
			this.val = val ;
		}
		
		public void setIndex(Integer index) {
			this.index = index ;
		}
		
		public Integer getVal() {
			return this.val ;
		} 
		
		public Integer getIndex(){
			return this.index ;
		}
		
		@Override
		public int compareTo(Distance arg) {
			// TODO Auto-generated method stub
			return this.getVal() - arg.getVal();
		}
		
	}
}

package com.yogi.math;

import java.util.ArrayList;
import java.util.Collections;

public class RandomAttendance {

	public static void main(String args[]) {
		RandomAttendance ra = new RandomAttendance();
		ArrayList<Integer> in = new ArrayList<>();
		in.add(2);
		in.add(5);
		System.out.println(22%10);
		System.out.println(32%10);
		System.out.println(ra.solve(32,in));
	}

	/*
	  input >30 
	  15	6
	  25	17

	  input > 20
	  
	 */
	public ArrayList<Integer> solve(int n, ArrayList<Integer> inputList){
		ArrayList<Integer> outputList = new ArrayList<Integer>();
		ArrayList<String> sortedList = new ArrayList<String>() ;
		ArrayList<String> actualList = new ArrayList<String>() ;
		
		for(int i=1; i<=n; i++) {
			sortedList.add(new Integer(i).toString());
			actualList.add(new Integer(i-1).toString());
		}
		Collections.sort(sortedList) ;
		System.out.println(sortedList);
		System.out.println(actualList);
		for(Integer in : inputList) {
			outputList.add(Integer.parseInt(sortedList.get(in-1)));
		}
		
		return outputList;
	}
	
}

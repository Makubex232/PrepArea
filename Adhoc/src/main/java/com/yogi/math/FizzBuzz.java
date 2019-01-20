package com.yogi.math;

import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String args[]) {
		FizzBuzz fb = new FizzBuzz();
//		System.out.println(1%3);
		System.out.println(fb.generateFizzBuzz(16));
	}
	
	public ArrayList<String> generateFizzBuzz(int n){
		ArrayList<String> outputList = new ArrayList<>();
//		outputList
		for(int i=1; i<=n; i++) {
			String fb = (i%3==0) ? "Fizz" : "" ;
			fb = (i%5==0) ? fb+"Buzz" : fb ;
			if(fb.equals("")) {
				outputList.add(new Integer(i).toString());
			}else {
				outputList.add(fb) ;
			}
		}
		
		return outputList ;
	}
	
}

package com.yogi.math;

import java.util.ArrayList;

public class PrimeSum {

	public static void main(String args[]) {
		PrimeSum ps = new PrimeSum();
		int input = 16777214 ;
		System.out.println(ps.findPrimeSum(input).toString());
	}
	
	public ArrayList<Integer> findPrimeSum(int input){
		ArrayList<Integer> outputList = new ArrayList<>();
		for(int i=2;i<=input/2; i++) {
			if(isPrime(i) && isPrime(input-i)) {
				outputList.add(i) ;
				outputList.add(input-i) ;
				return outputList ;
			}
		}
		
		return outputList ;
	}
	
	public boolean isPrime(int a) {
		
		int val = (int) Math.sqrt(a);
		for(int i=2;i<=val; i++) {
			if(a%i==0) {
				return false ;
			}
		}
		
		return true ;
	}
	
}

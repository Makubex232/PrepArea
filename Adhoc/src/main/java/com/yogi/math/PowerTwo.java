package com.yogi.math;

public class PowerTwo {

	public static void main(String args[]) {
		PowerTwo pt = new PowerTwo();
		System.out.println(pt.isPowerExpressable(4));
	}
	
	public int isPowerExpressable(int input) {
		
		if(input==1) {
			return 1 ;
		}
		
		for(int i=2; i<=input/2; i++) {
			for(int j=2; j<=input/2; j++) {
				if(Math.pow(i, j) > input) {
					break ;
				}
				if(Math.pow(i, j) == input) {
					System.out.println(i+"\t"+j);
					return 1 ;
				}
			}
		}
		
		return 0 ;
	}
	
}

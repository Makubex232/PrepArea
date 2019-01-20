package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flip {

	public static void main(String args[]) {
		Flip f = new Flip();
//		String input = "100" ;
		String input = "01010110" ;
		System.out.println(Arrays.toString(f.filpInput(input)));
	}
	
	private int[] filpInput(String input) {
		int[] result = new int[input.length()] ;
		int[] inputCopy = new int[input.length()] ;
		int[] resultIndex = new int[2] ;
		boolean found = false ;
		int[] flipDone = new int[3] ;
		int[][] flipCountIndex = new int[3][2];
		
		for(int i=0; i<input.length(); i++) {
			for(int j=i; j<input.length(); j++) {
				int flipCount = swapCount(input.charAt(i),input.charAt(j));
				if(flipDone[flipCount]==0) {
					if(i==j) {
						flipCount = Math.max(flipCount-1, 0) ;
					}
					flipDone[flipCount] = 1 ;
					flipCountIndex[flipCount][0] = i ;
					flipCountIndex[flipCount][1] = j ;
				}
			}
		}
		
		if(flipDone[2]!=0) {
			return new int[] {flipCountIndex[2][0],flipCountIndex[2][1]} ;
		}else if(flipDone[1]!=0) {
			return new int[] {flipCountIndex[1][0],flipCountIndex[1][1]} ;
		}else {
			return new int[] {} ;
		}
		
	}
	
	public int swapCount(char i, char j) {
		
		if(i=='1' && j=='1') {
			return 0 ;
		}
		
		if((i=='0' && j=='1') || (i=='1' && j=='0')) {
			return 1 ;
		}
		
		if( (i=='0' && j=='0') ) {
			return 2 ;
		}
		return 0;
		
	}
	
}

package com.yogi.array;

import java.util.Arrays;

/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the followig :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]
*/
public class AntiDiagnal {
	
	public static void main(String args[]) {
		AntiDiagnal ad = new AntiDiagnal() ;
		int[][] inputArray = {
								{1,2,3},
								{4,5,6},
								{7,8,9}
								} ;
//		int[][] inputArray = {{1}
//				} ;
		int[][] resultArray = ad.getAntiDiagnal(inputArray) ;
		for(int i=0; i<resultArray.length; i++) {
			System.out.println(Arrays.toString(resultArray[i]));
		}
		
	}

	// Time complexity is O(n^2). Iterate 0th index for n times. Iterate from 1 to n again using different logic.
	// Space complexity is O(n) since new matrix is created to store all values of original matrix.
	public int[][] getAntiDiagnal(int[][] inputArray){
		int inputSize = inputArray.length ;
		if(inputSize <= 1) {
			return inputArray ;
		}
		
		int[][] resultArray = new int[2*inputSize-1][] ;
		
		for(int i=0; i<inputSize; i++) {
			int rPos = i;
			resultArray[i] = new int[i+1] ;
			for(int j=0 ;j<=i; j++) {
				resultArray[i][j] = inputArray[j][rPos] ;
//				System.out.print("i "+i+" j "+j+"rPos "+rPos+"\t"+inputArray[j][rPos]);
				rPos--;
			}
//			System.out.println();
		}
		
		for(int i=1; i<inputSize; i++) {
			int rPos = inputSize-1 ;
			int lPos = i ;
			int index = 0 ;
			resultArray[inputSize-1+i] = new int[inputSize-i] ;
			for(int j=i; j<inputSize; j++) {
//				System.out.print(inputArray[lPos][rPos]);
				resultArray[inputSize-1+i][index++] = inputArray[lPos][rPos] ;
				rPos-- ;
				lPos++ ;
			}
//			System.out.println();
		}
		
		return resultArray ;
	}

}

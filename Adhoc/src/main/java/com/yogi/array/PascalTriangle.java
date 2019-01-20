package com.yogi.array;

import java.util.Arrays;

public class PascalTriangle {
	
	public static void main(String args[]) {
		PascalTriangle pt = new PascalTriangle();
		int size = 3 ;
		int[][] res = pt.createPascalTriangle(size) ;
		for(int i=0;i<size; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
		System.out.println();
		System.out.println(Arrays.toString(pt.createPascalTriangleLine(size)) );
	}
	
	public int[][] createPascalTriangle(int size){
		if(size==0) {
			return new int[][] {} ;
		}
		int[][] result = new int[size][] ;
		result[0] = new int[1];
		result[0][0] = 1 ;
		
		for(int line=1; line<size; line++) {
			result[line] = new int[line+1] ;
			result[line][0] = result[line-1][0] ;
			for(int j=0; j<=line; j++) {
				if(j==0 || j==line) {
					result[line][j] = 1 ;
				}else {
					result[line][j] = result[line-1][j-1] + result[line-1][j] ;
				}
			}
		}
		return result ;
	}

	public int[] createPascalTriangleLine(int size){
		size = size + 1 ;
		if(size==0) {
			return new int[] {} ;
		}
		int[][] result = new int[size][] ;
		result[0] = new int[1];
		result[0][0] = 1 ;
		
		for(int line=1; line<size; line++) {
			result[line] = new int[line+1] ;
			result[line][0] = result[line-1][0] ;
			for(int j=0; j<=line; j++) {
				if(j==0 || j==line) {
					result[line][j] = 1 ;
				}else {
					result[line][j] = result[line-1][j-1] + result[line-1][j] ;
				}
			}
		}
		return result[size-1] ;
	}

}

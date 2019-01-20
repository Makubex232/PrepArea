package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {

	public static void main(String args[]) {
		RotateMatrix rm = new RotateMatrix() ;
		ArrayList<ArrayList<Integer>> inputMatrix = new ArrayList<>();
		ArrayList<Integer> r1 = new ArrayList<>();
		r1.add(1);
		r1.add(2);
		r1.add(3);
		
		ArrayList<Integer> r2 = new ArrayList<>();
		r2.add(4);
		r2.add(5);
		r2.add(6);
		
		ArrayList<Integer> r3 = new ArrayList<>();
		r3.add(7);
		r3.add(8);
		r3.add(9);
		
		inputMatrix.add(r1) ;
		inputMatrix.add(r2) ;
		inputMatrix.add(r3) ;
		
		rm.rotate(inputMatrix);
	}
	
    public void rotate(ArrayList<ArrayList<Integer>> inputMatrix) {
    	int numOfCol = inputMatrix.get(0).size();
    	int maxRow = inputMatrix.size() ;
//    	System.out.println("numcol "+numOfCol+"\tmaxrow "+maxRow);
    	int[] cache = new int[maxRow];
//    	System.out.println(inputMatrix.toString());
//    	for(int i=0 ;i<maxRow; i++) {
//    		System.out.println("src "+inputMatrix.get(i).get(2)+"\ttrgt "+inputMatrix.get(0).get(i));
//    		cache[i] = inputMatrix.get(i).get(2);
//    		if(i==maxRow-1) {
//    			inputMatrix.get(i).set(2, cache[0]);
//    		}else {
//    			inputMatrix.get(i).set(2, inputMatrix.get(0).get(i));	
//    		}
//    	}
    	int[][] outMatrix = new int[3][3] ;
    	
    	int curCount = 2 ;
    	for(int i=0 ; i<maxRow; i++) {
    		for(int j=0; j<maxRow; j++) {
//    			System.out.println("i "+i+"\tj "+j+"\tcurRow "+curRow);
    			outMatrix[j][curCount] = inputMatrix.get(i).get(j);
    			
    		}
    		curCount-- ;
    	}
    	
    	for(int i=0; i<maxRow; i++) {
    		System.out.println(Arrays.toString(outMatrix[i]));
    	}
    }
	
}

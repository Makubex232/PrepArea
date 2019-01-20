package com.yogi.array;

/*
 You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it.
*/
public class FindDistance {

	public static void main(String args[]) {
		FindDistance fdo = new FindDistance();
		int[] a = {-7,-13} ;
		int[] b = {1,-5} ;
		System.out.println("Result :: "+fdo.coverPoints(a, b)) ;
	}
	
	private int coverPoints(int[] a, int[] b) {
		int result = 0 ;
		int distance = 0 ;
		for(int i=0; i<a.length-1; i++) {
			distance = findDistance(a[i],b[i],a[i+1],b[i+1]) ;
			result = result + distance ;
		}
		return result ;
	}
	
	private int findDistance(int x0, int y0, int x1, int y1) {
		int xAxisDifference = Math.max(x0, x1) - Math.min(x0, x1) ;
		int yAxisDifference = Math.max(y0, y1) - Math.min(y0, y1) ;
		return Math.max(xAxisDifference, yAxisDifference) ;
	}
	
	
	
}

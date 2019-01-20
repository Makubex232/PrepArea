package com.yogi.array;

public class SpiralMatrix {

	public static void main(String args[]) {
		SpiralMatrix sm = new SpiralMatrix();
		int n = 10 ;
		int[][] res = sm.getSpiralMatrix(n);
		for(int i=0; i<n; i++) {
			for(int j=0;j <n; j++) {
				System.out.print(res[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public int[][] getSpiralMatrix(int n){
		int[][] result = new int[n][n] ;
		int firstRow = 0;
		int firstColumn = 0;
		int lastRow = n - 1;
		int lastColumn = n - 1;
		int incr = 0 ;
		int value = 1 ;

		while (firstRow < lastRow && firstColumn < lastColumn) {
			for (int i = firstColumn; i <= lastColumn; i++) {
				result[firstRow][i] = value++ ;
			}
			firstRow++;

			for (int i = firstRow; i <= lastRow; i++) {
				result[i][lastColumn] = value++ ;
			}
			lastColumn--;

			for (int i = lastColumn; i >= firstColumn; i--) {
				result[lastRow][i] = value++ ;
			}
			lastRow--;

			for (int i = lastRow; i >= firstRow; i--) {
				result[i][firstColumn] = value++ ;
			}
			firstColumn++;

		}
		
		if(firstRow == lastRow && firstColumn == lastColumn) {
			result[firstRow][firstColumn] = value++ ;
		}
		
		if(firstRow < lastRow && firstColumn == lastColumn){
			for(int i=firstRow; i<=lastRow; i++) {
				result[firstRow][firstColumn] = value++ ;
				firstRow++ ;
			}
		}
		
		if(firstRow == lastRow && firstColumn < lastColumn){
			for(int i=firstColumn; i<=lastColumn; i++) {
				result[firstRow][firstColumn] = value++ ;
				firstColumn++ ;
			}
		}
		
		
		return result;
	}
	
}

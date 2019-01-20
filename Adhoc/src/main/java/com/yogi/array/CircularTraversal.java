package com.yogi.array;

/*
 * Print matrix in spiral form. Print the 2-D array in spiral form.
*/
public class CircularTraversal {

	public static void main(String args[]) {
//		int[][] inputArray = { 
//								{ 1, 2, 3, 4, 5 }, 
//								{ 6, 7, 8, 9, 10 }, 
//								{ 11, 12, 13, 14, 15 }, 
//								{ 16, 17, 18, 19, 20 },
//								{ 21, 22, 23, 24, 25}
//							};
		
//		int[][] inputArray = { 
//				{ 1 }, 
//				{ 6 }, 
//				{ 1 }
//			};

		int[][] inputArray = { 
		{  } 
	};

		
		String order = "normal";
		CircularTraversal cto = new CircularTraversal();

		System.out.println("INPUT ARRAY \n");
		cto.printArray(inputArray, order);
		System.out.println("\n\n");

		order = "circular";
		cto.printArray(inputArray, order);

	}

	private void printArray(int[][] inputArray, String order) {
		if (order.equalsIgnoreCase("circular")) {
			traverseCircular(inputArray);
		} else if (order.equalsIgnoreCase("normal")) {
			traverseNormal(inputArray);
		} else {
			System.out.println("print order not supported. Only supported print order are normal and circular.");
		}
	}

	private void traverseNormal(int[][] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print("\t");
			for (int j = 0; j < inputArray[i].length; j++) {
				System.out.print(inputArray[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private void traverseCircular(int[][] inputArray) {
		int firstRow = 0;
		int firstColumn = 0;
		int lastRow = inputArray.length - 1;
		int lastColumn = inputArray[0].length - 1;
		int output[] = new int[(lastRow+1)*(lastColumn+1)] ;
		int incr = 0 ;
		
		while (firstRow < lastRow && firstColumn < lastColumn) {
			for (int i = firstColumn; i <= lastColumn; i++) {
				output[incr++] = inputArray[firstRow][i] ;
			}
			firstRow++;

			for (int i = firstRow; i <= lastRow; i++) {
				output[incr++] = inputArray[i][lastColumn] ;
			}
			lastColumn--;

			for (int i = lastColumn; i >= firstColumn; i--) {
				output[incr++] = inputArray[lastRow][i] ;
			}
			lastRow--;

			for (int i = lastRow; i >= firstRow; i--) {
				output[incr++] = inputArray[i][firstColumn] ;
			}
			firstColumn++;

		}
		
		if(firstRow == lastRow && firstColumn == lastColumn) {
			output[incr++] = inputArray[firstRow][firstColumn] ;
		}
		
		if(firstRow < lastRow && firstColumn == lastColumn){
			for(int i=firstRow; i<=lastRow; i++) {
				output[incr++] = inputArray[firstRow][firstColumn] ;
				firstRow++ ;
			}
		}
		
		if(firstRow == lastRow && firstColumn < lastColumn){
			for(int i=firstColumn; i<=lastColumn; i++) {
				output[incr++] = inputArray[firstRow][firstColumn] ;
				firstColumn++ ;
			}
		}
		
		System.out.println();
		for(int i=0; i<incr; i++) {
			System.out.print(output[i]+"\t");
		}
	}

}

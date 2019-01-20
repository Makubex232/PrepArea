package com.yogi.search;

public class FullScan {

	public static void main(String args[]) {
		String inputString = "1 42 35 72 85 98 100 215 42 59 2";
		String input[] = inputString.split(" ", -1);
		String itemToSearch = "42";
		search(input, itemToSearch);

	}

	public static boolean search(String input[], String itemToSearch) {

		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(itemToSearch)) {
				System.out.println(itemToSearch + " is available in input at " + i + " index.");
				return true;
			}
		}
		System.out.println(itemToSearch + " is not available in input.");
		return false;
	}

}

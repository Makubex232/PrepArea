package com.yogi.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HotelBooking {

	public static void main(String args[]) {
		HotelBooking hb = new HotelBooking();
		Integer[] arrival = { 1, 3, 5 };
		ArrayList<Integer> arrivalList = new ArrayList<>(Arrays.asList(arrival));
		Integer[] departure = { 2, 5, 8 };
		ArrayList<Integer> departureList = new ArrayList<>(Arrays.asList(departure));
		int roomCount = 1;

		System.out.println(hb.roomAvailabilityValidation(arrivalList, departureList, roomCount));
		System.out.println(hb.optimalRoomAvailabilityValidation(arrivalList, departureList, roomCount));
	}

	public boolean roomAvailabilityValidation(ArrayList<Integer> arrivalList, ArrayList<Integer> departureList,
			int roomCount) {
		boolean result = true;
		Map<Integer, Integer> validationMap = new HashMap<>();

		int i = 0;
		for (Integer arrivalTime : arrivalList) {
			Integer departureTime = departureList.get(i);
			i++;
//			System.out.println("arrivalTime "+arrivalTime+"\tdepartureTime "+departureTime);
			int retainArrivalTime = arrivalTime;
			for (int j = arrivalTime; j < departureTime; j++) {
				Integer mapValue = validationMap.get(retainArrivalTime);
				System.out.println("map key " + retainArrivalTime + "\tvalue " + mapValue);
				if (mapValue != null) {
					if (mapValue == roomCount) {
						return false;
					} else {
//						System.out.println("map put key "+retainArrivalTime+"\tvalue "+mapValue+1);
						validationMap.put(retainArrivalTime, mapValue + 1);
					}
				} else {
					validationMap.put(retainArrivalTime, 1);
				}
				retainArrivalTime++;
			}

		}

		return result;
	}

	public boolean optimalRoomAvailabilityValidation(ArrayList<Integer> arrivalList, ArrayList<Integer> departureList,
			int roomCount) {
		int  roomsRequired = 0;
		Collections.sort(arrivalList);
		Collections.sort(departureList);

		for(int i=0, j=0; i<arrivalList.size() && j<departureList.size() && roomsRequired <= roomCount ; ) {
			if(arrivalList.get(i)<departureList.get(j)) {
				i++ ;
				roomsRequired++ ;
			}else {
				j++ ;
				roomsRequired-- ;
			}
		}
		
		if(roomsRequired<=roomCount) {
			return true ;
		}else {
			return false ;
		}
	}

}

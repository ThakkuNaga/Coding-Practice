package com.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers where each element points to the index of the next element 
how would you detect if there is a cycle in this array
Note: if the element of array is in range[0, n-1], where n is the length of array, then there must be at least one cycle.
Thus, the element may be negative or out of range[0,n-1]
*/

class LengthOfArrayCycle {

	public static void main(String[] args) {
		int[] arr1 = { 1, 0 };// 2
		System.out.println(lengthOfCycle(arr1, 0));

		int[] arr2 = { 1, 2, 0 };// 3
		System.out.println(lengthOfCycle(arr2, 0));

		int[] arr3 = { 1, 2, 3, 1 };// 3
		System.out.println(lengthOfCycle(arr3, 0));

		assert lengthOfCycle(new int[] { 1, 2, 3, 4 }, 0) == -1;
		assert lengthOfCycle(new int[] { 1, 2, 3, 4 }, -1) == -1;
		assert lengthOfCycle(new int[] { 1, 2, 3, 4 }, 4) == -1;
		assert lengthOfCycle(new int[] { 2, 3, 4, 0 }, 0) == -1;
		assert lengthOfCycle(new int[] { 2, 3, 0 }, 0) == 2;
	}

	public static int lengthOfCycle(int[] arr, int startInd) {
		System.out.println(Arrays.toString(arr));
		if (startInd < 0 || startInd >= arr.length) {
			return -1;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int cur = startInd, idx = 0;
		while (cur < arr.length) {
			if (map.containsKey(arr[cur])) {
				return idx - map.get(arr[cur]);
			}
			map.put(arr[cur], idx++);
			cur = arr[cur];
		}
		return -1;
	}

	// UPDATE -------------
	// Here's another solution using Floyd's Tortoise and Hare pointers!
	// Not very easy to come up with, especially during the interview, though good
	// to know
	// Special thanks to @Sithis for the idea!
	public static int lengthOfCycleFloydTortoiseAndHare(int[] arr, int startInd) {
		if (startInd < 0 || startInd >= arr.length) {
			return -1;
		}
		int slow = arr[startInd];
		int fast = arr[arr[startInd]];
		// trying to detect a cycle at first
		while (slow != fast) {
			// out of bounds - no cycle
			if (fast >= arr.length) {
				return -1;
			}
			slow = arr[slow];
			fast = arr[arr[fast]];
		}
		// yes, there is a cycle for sure, we need to find the starting point
		fast = 0;
		while (fast != slow) {
			fast = arr[fast];
			slow = arr[slow];
		}
		// okay, we have found the starting point, so move away from it again and count
		// the length of the cycle
		int length = 1;
		slow = arr[slow];
		while (fast != slow) {
			length++;
			slow = arr[slow];
		}
		return length;
	}

}
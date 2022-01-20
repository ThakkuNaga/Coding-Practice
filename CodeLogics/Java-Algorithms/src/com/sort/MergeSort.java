package com.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 5, 2, 34, 12, 52, 23, 2, 3, 3, 100, 50 };
		int[] temp = new int[array.length];
		mergesort(array, temp, 0, array.length - 1);
		System.out.println(Arrays.toString(temp));
	}

	public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd)
			return;

		int middle = (leftStart + rightEnd) / 2;

		mergesort(array, temp, leftStart, middle);
		mergesort(array, temp, middle + 1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd);
	}

	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}

		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}

}
package com.interviews;

import java.util.Arrays;
import java.util.TreeSet;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
 salary = {8000,9000,2000,3000,6000,1000};
 remove minimum and max
 find the average of remaining 
 without sort funtion
 
 */

class FindAvg {
  public static void main(String[] args) {
    int[] arr = { 8000, 9000, 2000, 3000, 6000, 1000 };
    findAvg(arr);
    findAvg2(arr);
  }

  private static int findAvg(int[] arr) {
    TreeSet<Integer> ts = new TreeSet<>();

    for (int num : arr) {
      ts.add(num);
    }
    System.out.println(ts);
    ts.pollFirst();
    ts.pollLast();
    System.out.println(ts);

    int avg = 0;
    for (int num : arr) {
      if (ts.contains(num))
        avg += num;
    }
    System.out.println("Avg:" + avg / ts.size());

    return (avg / ts.size());
  }

  public static void findAvg2(int[] a) {
    int[] a2 = new int[a.length - 2];

    int min = a[0];
    int max = a[0];
    int sum = 0;
    for (int i = 0; i < a.length; i++) {

      if (a[i] < min)
        min = a[i];

      if (a[i] > max)
        max = a[i];

      sum += a[i];

    }
    System.out.println(min + " " + max);

    int j = 0;
    for (int i : a)
      if (i != min && i != max)
        a2[j++] = i;

    System.out.println(Arrays.toString(a2));
    System.out.println("len: " + (a.length - 2) + " sum:" + (sum - (min + max)));
    System.out.println((sum - (min + max)) / (a.length - 2));

    // int len = a2.length;
    // int mid = len / 2;
    // System.out.println("Mid index:" + mid);

    // double median;
    // if (len % 2 == 0)
    // median = ((double) a2[mid] + (double) a2[mid - 1]) / 2;
    // else
    // median = (double) a2[mid];

    // System.out.println(a2[mid] + " " + a2[mid - 1] + " = " + median);

  }

}

package com.main;

class FindUnique {
    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 3, 2, 1 };
        int n = a.length - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {

                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1]; 
                    a[j + 1] = tmp;
                }
            }

        }
        System.out.println(a[n]);

    }
}
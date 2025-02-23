// Given a two array – calculate median. Also provide atleast two solutions.

package Java;

import java.util.*;

class E11 {
    public static float countMedianS1(int[] arr1, int[] arr2) {
        float total = 0, count = 0, median;
        for (int i = 0; i < arr1.length; i++) {
            total += arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            total += arr2[i];
        }

        count = arr1.length + arr2.length;
        median = total / count;
        return median;
    }

    public static double countMedianS2(int[] numArray) {
        Arrays.sort(numArray);
        double median;
        if (numArray.length % 2 == 0)
            median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
        else
            median = (double) numArray[numArray.length / 2];
        return median;
    }

    public static void main(String[] args) {
        int[] a1 = { 1, 2, 3 };
        int[] a2 = { 4, 5, 6 };
        System.out.println("Solution 1: " + countMedianS1(a1, a2));
        System.out.println("Solution 2: " + (countMedianS2(a1) + countMedianS2(a2)) / 2);
    }
}
/* binary array is an array consisting of only the values 0 and 1. Given a
binary array of any length, return an array of positive integers that
represent the lengths of the sets of consecutive 1's in the input array, in
order from left to right.*/

package Java;

import java.util.*;

class E16 {
    public static List<Integer> nonogramrow(int[] array) {
        List<Integer> myList = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            } else {
                if (count > 0) {
                    myList.add(count);
                    count = 0;
                }
            }
        }

        if (count > 0) {
            myList.add(count);
        }

        return myList;
    }

    public static void main(String[] args) {
        int[] myArray = {};
        int[] myArray2 = { 0, 0, 0, 0, 0 };
        int[] myArray3 = { 1, 1, 1, 1, 1 };
        int[] myArray4 = { 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 };
        int[] myArray5 = { 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0 };
        int[] myArray6 = { 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1 };
        int[] myArray7 = { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };

        System.out.println("nonogramrow([]) => " + nonogramrow(myArray));
        System.out.println("nonogramrow([0,0,0,0,0]) => " + nonogramrow(myArray2));
        System.out.println("nonogramrow([1,1,1,1,1]) => " + nonogramrow(myArray3));
        System.out.println("nonogramrow([0,1,1,1,1,1,0,1,1,1,1]) => " + nonogramrow(myArray4));
        System.out.println("nonogramrow([1,1,0,1,0,0,1,1,1,0,0]) => " + nonogramrow(myArray5));
        System.out.println("nonogramrow([0,0,0,0,1,1,0,0,1,0,1,1,1]) => " + nonogramrow(myArray6));
        System.out.println("nonogramrow([1,0,1,0,1,0,1,0,1,0,1,0,1,0,1]) => " + nonogramrow(myArray7));
    }
}
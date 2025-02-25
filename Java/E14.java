// Given an array of integers, keep a total score based on the following:
// Add 1 point for every even number in the array.
// Add 3 points for every odd number in the array.
// Add 5 points for every time you encounter a 5 in the array.
// If an empty array or null is passed, give 0.

package Java;

class E14 {
    public static void main(String[] args) {
        int[] array = { 5, 1, 2, 4, 6, 3 };
        int point = 0;

        if (array.length == 0) {
            point = 0;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    point += 1;
                }
                if (array[i] % 2 != 0) {
                    if (array[i] == 5) {
                        point += 5;
                    } else {
                        point += 3;
                    }
                }
            }
        }

        System.out.println("Total Score: " + point);
    }
}
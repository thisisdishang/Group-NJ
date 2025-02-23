/* Implement a function countNumbers that accepts a sorted array of unique integers, count the
number of array elements that are less than the parameter lessThan.*/

package Java;

class E12 {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int count = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] < lessThan) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7 };
        System.out.println(countNumbers(array, 4));
    }
}

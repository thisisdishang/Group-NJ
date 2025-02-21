/* The greates common divisor (GCD) of two integers (of which at least one is nonzero) is the largest positive integer that divides the numbers.
Write a java non-recursive function that accepts two integers and returns -1 if both the integers are zero, otherwise it returns their GCD.
Write a java program which accepts two integers and prints their GCD. */

package Java;

public class E2 {
    public static int myGCD(int n1, int n2) {
        if (n1 == 0 && n2 == 0) {
            return -1;
        }

        if (n1 == 0) {
            return Math.abs(n2);
        }

        if (n2 == 0) {
            return Math.abs(n1);
        }

        int min = Math.min(n1, n2);
        int gcd = 1;

        for (int i = 1; i <= min; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    public static void main(String[] args) {
        System.out.println("GCD: " + myGCD(12, 15));
    }
}

/* Implement the previous problem with a recursive function that accepts two integers and returns -1 if both integers are zero,
 otherwise it returns their GCD. */

package Java;

public class E3 {
    public static int recursiveGCD(int n1, int n2) {
        if (n1 == 0 && n2 == 0) {
            return -1;
        }

        if (n1 == 0) {
            return Math.abs(n2);
        }

        if (n2 == 0) {
            return Math.abs(n1);
        }

        return recursiveGCD(n2, n1 % n2);
    }

    public static void main(String[] args) {
        System.out.println("GCD: " + recursiveGCD(60, 50));
    }
}

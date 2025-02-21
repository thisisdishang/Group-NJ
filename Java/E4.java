// Write a java program that implements tower of hanoi problem.

package Java;

public class E4 {
    public static void towerOfHanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move 1st disk from rod " + a + " to rod " + c);
            return;
        }

        towerOfHanoi(n - 1, a, c, b);
        System.out.println("Move " + n + "th disk from rod " + a + " to rod " + c);
        towerOfHanoi(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        towerOfHanoi(4, 'A', 'B', 'C');
    }
}

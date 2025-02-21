/* Write a program that asks the user for a list of names (one per line) until the user enters a blank line (i.e. just hits return when asked for a name).
 At that point the program should print out how many times each name in the list was entered. You may find that using a HashMap to keep track of the
 information entered by user may greatly simplify this problem. */

package Java;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class E6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String name;

        while (true) {
            System.out.print("Enter a name: ");
            name = sc.nextLine();

            if (name.isEmpty()) {
                break;
            }

            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        System.out.println("\nNames and their counts:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        sc.close();
    }
}

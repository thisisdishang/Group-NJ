// Password Cracker

package Java;

import java.util.Scanner;

class E8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a password
        System.out.println("Enter a secret password (5 characters or less): ");
        String secretPassword = scanner.nextLine();

        // Check if the password is valid
        if (secretPassword.length() > 5) {
            System.out.println("Password must be 5 characters or less.");
            return;
        }

        int attempts = 0;
        boolean found = false;

        // Start cracking the password by generating all possible passwords
        for (int length = 1; length <= secretPassword.length(); length++) {
            if (found)
                break;

            // Loop through all possible characters for the current length
            for (int i = 0; i < Math.pow(26, length); i++) {
                String passwordAttempt = generatePassword(length, i);
                attempts++;

                // Compare generated password with the secret password
                if (passwordAttempt.equals(secretPassword)) {
                    found = true;
                    System.out.println("Password cracked! It took " + attempts + " attempts.");
                    break;
                }
            }
        }

        scanner.close();
    }

    // Generate a password of a given length for a given index
    private static String generatePassword(int length, int index) {
        StringBuilder password = new StringBuilder();
        int tempIndex = index;

        for (int i = 0; i < length; i++) {
            char character = (char) ('a' + (tempIndex % 26)); // Generate character from 'a' to 'z'
            password.insert(0, character);
            tempIndex /= 26; // Move to the next character in the sequence
        }

        return password.toString();
    }
}
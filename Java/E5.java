/* Write a method removeDoubleLetters that takes a string as its argument and returns a new string with all doubled letters in the string
 replaced by a single letter, for example if you call removeDoubleLetters("bookkeeper"), the method should return "bokeper". */

package Java;

public class E5 {
    public static String removeDoubledLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i - 1));
            }
        }

        sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDoubledLetters("bookkeeper"));
    }
}

/* 1,000,000 to make it easier for programmers to display numbers in this fashion, implement a method
 private String addCommasToNumbericString(String digits) that takes a string of decimal digits representing a number and returns
 the string formed by inserting commas at every third position from the right. For example, given the string "1234567", the method
 should return "1,234,567". */

package Java;

public class E7 {
    public static String addCommasToNumbeString(String digits) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = digits.length() - 1; i >= 0; i--) {
            count++;
            sb.append(digits.charAt(i));
            if (count > 2) {
                sb.append(",");
                count = 0;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addCommasToNumbeString("1000000"));
    }

}

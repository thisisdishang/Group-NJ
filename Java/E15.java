/* Assign every lowercase letter a value, from 1 for a to 26 for z. Given a
string of lowercase letters, find the sum of the values of the letters in
the string.*/

package Java;

class E15 {
    public static int letterSum(String s) {
        String newS = s.toLowerCase();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += ((int) newS.charAt(i)) - 96;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("letterSum(\"\") => " + letterSum(""));
        System.out.println("letterSum(\"a\") => " + letterSum("a"));
        System.out.println("letterSum(\"z\") => " + letterSum("z"));
        System.out.println("letterSum(\"cab\") => " + letterSum("cab"));
        System.out.println("letterSum(\"excellent\") => " + letterSum("excellent"));
        System.out.println("letterSum(\"microspectrophotometries\") => " + letterSum("microspectrophotometries"));
    }
}

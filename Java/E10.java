/* Given two positive year numbers (with the second one greater than
or equal to the first), find out how many leap days (Feb 29ths)
appear between Jan 1 of the first year, and Jan 1 of the second
year in the Revised Julian Calendar. This is equivalent to asking
how many leap years there are in the interval between the two
years, including the first but excluding the second.*/

package Java;

public class E10 {
    public static int leaps(int startYear, int endYear) {
        int count = 0;

        for (int i = startYear; i < endYear; i++) {
            if ((i % 4 == 0) && (i % 100 != 0 || i % 900 == 600 || i % 900 == 200)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("leaps(2016, 2017) => " + leaps(2016, 2017));
        System.out.println("leaps(2019, 2020) => " + leaps(2019, 2020));
        System.out.println("leaps(1900, 1901) => " + leaps(1900, 1901));
        System.out.println("leaps(2000, 2001) => " + leaps(2000, 2001));
        System.out.println("leaps(2800, 2801) => " + leaps(2800, 2801));
        System.out.println("leaps(123456, 123456) => " + leaps(123456, 123456));
        System.out.println("leaps(1234, 5678) => " + leaps(1234, 5678));
    }
}
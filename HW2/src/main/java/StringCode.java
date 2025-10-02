import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {


    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str.isEmpty()) return 0;
        int count = 1;
        int max = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int index = c - '0';
                if (i + 1 < str.length()) {
                    char next = str.charAt(i + 1);
                    for (int j = 1; j <= index; j++) {
                        ans.append(next);
                    }
                }
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i + len <= a.length(); i++) {
            set.add(a.substring(i, i + len));
        }
        for (int i = 0; i + len <= b.length(); i++) {
            if (set.contains(b.substring(i, i + len))) {
                return true;
            }
        }
        return false;
    }
}

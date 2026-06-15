package Strings.Medium;

public class Atoi {
    public static void main(String[] args) {
        String s = "0-1";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        if (s.length() == 0) return 0;

        int n = s.length();
        int i = 0;

        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;

        if (i == n) return 0;

        // Handle sign
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        long res = 0;

        // Parse digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;

            if (sign * res <= min) return min;
            if (sign * res >= max) return max;

            i++;
        }

        return (int) (sign * res);
    }
}

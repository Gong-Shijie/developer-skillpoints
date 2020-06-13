package com.company;

public class LC7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        String string = x + "";
        if (x < 0) {
            string = string.substring(1);
            StringBuffer stringBuffer = new StringBuffer(string);
            string = String.valueOf(stringBuffer.reverse());
        } else {
            StringBuffer stringBuffer = new StringBuffer(string);

            string = String.valueOf(stringBuffer.reverse());
        }
        if (x > 0 && Long.parseLong(string) < Integer.MAX_VALUE) {
            return Integer.parseInt(string);
        }
        if (x < 0 && (0-Long.parseLong(string)) > Integer.MIN_VALUE)
            return 0-Integer.parseInt(string);
        return 0;
    }


}

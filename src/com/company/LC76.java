package com.company;

import java.util.Arrays;

public class LC76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s.length() == 0)
            return "";
        String minLength = s;
        String result = "" + s.charAt(0);
        int i = 0, j = 1;

        while (j < s.length()) {
            result = result + s.charAt(j);

            //移动右边之后判断是否包含
            if (contanis(getSorted(result),getSorted(t))) {
                minLength = minLength.length() > result.length() ? result : minLength;
//                    result中有多余的该元素 或者是左边不是目标 都可以移动左侧
                while (getSorted(result).contains(s.charAt(i) + "" + s.charAt(i)) || !t.contains(s.charAt(i) + "")) {
                    i++;
                    result = result.substring(1);
                }
                minLength = minLength.length() > result.length() ? result : minLength;
            }
            j++;
        }
        return minLength;
    }

    public static String getSorted(String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
    public static boolean contanis(String a,String b){
        for (int i = 0; i < b.length(); i++) {
            if(!a.contains(""+b.charAt(i)))
                return false;
        }
        return true;
    }


}

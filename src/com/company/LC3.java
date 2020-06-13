package com.company;

import java.util.ArrayList;
import java.util.HashMap;
//双指针 滑动  while while 控制两层两个指针的滑动  每次都取result的最大值
public class LC3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 1;
        if (s == "")
            return 0;
        int maxLength = 1;
        String result = "" + s.charAt(0);
        while (j < s.length()) {

            if (result.contains("" + s.charAt(j)))
                maxLength = Math.max(result.length(), maxLength);
            // 直到右端无重复
            while (result.contains("" + s.charAt(j))) {
                i++;
                result = result.substring(1);
            }


            result = result + s.charAt(j);

            j++;
        }
        maxLength = Math.max(maxLength, result.length());
        return maxLength;

    }
}


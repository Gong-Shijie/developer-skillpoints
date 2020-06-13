package com.company;
//a中寻找最长的字串b
// 滑动窗口  常用来解决字符串中，或者其他情况  a集合 寻找 b集合的情况
 public class LC28 {
    public int strStr(String haystack, String needle) {
        if (needle == null)
            return 0;
        int winlength = needle.length();
        for (int i = 0; i < haystack.length()-winlength+1; i++) {
            if(haystack.substring(i,winlength+i).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

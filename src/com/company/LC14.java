package com.company;
//   寻找最长公共前缀   预设最优解不断优化最优解
//   subString  是一个后开区间   集合的长度总是最后一个index是length-1
public class LC14 {
    public static void main(String[] args) {
        String test = new String("0123456");
        System.out.println(test.substring(0,2));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String longestPrefix = strs[0];
        for(String ele :strs ){
            while(!ele.startsWith(longestPrefix)){
                longestPrefix = longestPrefix.substring(0,longestPrefix.length()-1);
            }
        }
        return longestPrefix;
    }
}

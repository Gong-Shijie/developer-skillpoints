package com.company;

public class LC409 {
    //哈希 回文字符串  哈希的思想 映射下标
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));

    }
    public static  int longestPalindrome(String s) {
        int flag = 0;
        int result = 0;
        int[] array = new int[(int)('z'-'A')];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'A']++;
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                result = result + array[i];
            }else {
                if(flag!=1){
                    result= result +array[i];
                    flag=1;
                }else {
                    result = result +array[i]-1;
                }
            }
        }
        return result;

    }
}

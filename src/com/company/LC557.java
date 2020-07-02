package com.company;

// 字符串 逆序  逆序 就使用 StringBuffer 中的 reverse 方法
// 字符串 String trim 删除两端空格 split 按照 指定字符进行切割
public class LC557 {
    public static void main(String[] args) {
        System.out.println(reverseWords("hello hi"));
    }
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            StringBuffer stringBuffer = new StringBuffer(word).reverse();
            result.append(stringBuffer).append(" ");
        }
        return String.valueOf(result).trim();
    }
}

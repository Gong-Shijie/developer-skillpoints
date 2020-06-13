package com.company;
//   递归   统计字符出现次数for循环中加上while来做
//  字符串尽量用StringBuilder
public class LC38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String preResult = countAndSay(n - 1);
        StringBuilder nowResult= new StringBuilder();
        for (int i = 0; i < preResult.length(); i++) {
            char temp = preResult.charAt(i);
            int countTemp = 1;
            while (i+1<preResult.length()&&preResult.charAt(i+1) == temp) {
                countTemp++;
                i++;
            }
            nowResult.append(countTemp).append(temp);
        }
        return String.valueOf(nowResult);

    }


}



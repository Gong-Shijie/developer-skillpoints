package com.company;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    //需要生成某种序列  然后来 根据题目的条件进行剪枝
//    每一次递归结束意味着当前找的了一种可能序列
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, n+n,n,n);
        return result;


    }

    public static void generate(List<String> result, String list, int times, int n, int left, int right) {
        if (times > n - 1) {
            result.add(new String(list));
            return;
        }
        if (left > 0)

            generate(result, list + "(", times + 1, n, left - 1, right);


        if (left < right)
            generate(result, list + ")", times + 1, n, left, right - 1);
    }

}

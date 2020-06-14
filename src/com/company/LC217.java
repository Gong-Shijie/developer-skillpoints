package com.company;

import java.util.HashSet;
import java.util.Set;

// 存在重复元素  重复---> 哈希
public class LC217 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

    }

    public static boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}

package com.company;
//找出出现两次的数字  异或相同的一组会被消除 但凡是出现了两次的数字或者是字母都可以找出单独出现的一个
//异或运算满足交换律 ^  映射的方法hashmap思路
public class LC136 {
    public static void main(String[] args) {
        System.out.println();
    }
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}

package com.company;

public class LC376 {
    //贪心
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4}));
    }
    public static int wiggleMaxLength(int[] nums) {
        int num = 1;
        int flag = 3;

        if (nums.length < 3) {
            if (nums.length == 2) {
                if (nums[0] != nums[1]) {
                    return 2;
                } else {
                    return 1;
                }
            }
            return nums.length;
        }
        if (getState(nums[0], nums[1]) != 3)
            num++;
        flag = getState(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if ((getState(nums[i - 1], nums[i]) == flag) || (nums[i] == nums[i - 1])) {
            } else {
                num++;
                if (flag == 3) {
                    flag = getState(nums[i - 1], nums[i]);
                } else {
                    flag = flag == 1 ? 0 : 1;
                }
            }

        }
        return num;
    }
    public static int getState(int i, int j) {
        if (i == j)
            return 3;
        return j - i > 0 ? 1 : 0;
    }
}
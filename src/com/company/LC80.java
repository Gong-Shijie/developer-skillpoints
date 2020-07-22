package com.company;
// 遍历数组填数 游标 思想   删除重复的元素
// 注意 判断的逻辑 在 结果的游标  而不是在当前的游标上
public class LC80 {
    public int removeDuplicates(int[] nums) {
        // 0 1 下标不会出现重复
        int i = 2;
        if (nums.length <= 2) {
            return nums.length;
        }
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}

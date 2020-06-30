package com.company;

import java.util.HashMap;

//移除指定元素然后将其他元素提前
//思路就是设置一个双指针一个指针不走除非得到了指定需要的元素
public class LC27 {
    public static void main(String[] args) {
        HashMap<Integer,String> nameMap = new HashMap<>();
        nameMap.put(1,"lisa");
        nameMap.put(2,"jenny");
        nameMap.put(3,"rose");
        nameMap.put(0,"jisso");
        System.out.println(nameMap.get(0));
        System.out.println(nameMap.containsValue("lisa"));
        int [] a = new int[]{1,2,3,4};
        System.out.println(a[0]);
        System.out.println(a[4]);
    }

    public static int removeElement(int[] nums, int val) {
        int result=0 ;
        for (int i = 0,j = 0; i < nums.length; i++) {
            if (nums[i] != val){
               nums[j] = nums[i]; j++;result++;
            }else {

            }
        }
        return result;
    }
}

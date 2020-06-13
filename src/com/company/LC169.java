package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class LC169 {
    //寻找出现次数大于一半数组长度的数
    //可以排序后取中值
     public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,3,2,3,4}));
    }
    public static int majorityElement2(int[] nums) {
        HashMap<Integer,Integer> flag = new HashMap<>();
        int length = nums.length;

         for(int ele:nums) {
             if(!flag.containsKey(ele)){
                 flag.put(ele, 1);
             }else {

                 flag.put(ele, flag.get(ele)+1);
             }
         }
         Collection<Integer> set = flag.values();
         for(int ele:nums){
             if(flag.get(ele)>length/2){
                 return ele;
             }
         }
         return nums[0];


    }

    public static int majorityElement(int[] nums) {
         Arrays.sort(nums);
         return nums[nums.length/2];
    }


}

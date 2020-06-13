package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(
                new int[]{3,2,3,1,2,4,5,5,6},4));
    }
    public static int findKthLargest(int[] nums, int k) {
        //最小堆   往往用来保存大的数  因为堆顶的数最小  堆内的数肯定都大
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>(k);
        //最大堆
        PriorityQueue<Integer> priorityQueue1 =
                new PriorityQueue<Integer>(4, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer integer, Integer t1) {
                        return  integer-t1;
                    }
                });
        for (int i = 0; i <k ; i++) {
            priorityQueue.add(nums[i]);
        }
        for(int i = k;i<nums.length;i++){
            if(nums[i]>=priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }

        return priorityQueue.peek();
    }
}

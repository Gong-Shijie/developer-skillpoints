package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
// 使用优先级队列 来求 第 K 大的数
// 全部入队列  然后持续poll 当 PriorityQueue size == K 时 top就是 第K大的数
// 默认是小顶堆
// 堆的 每一次 插入和删除都是 logn 的复杂度  n代表堆的size 相当于是将数据在树找到合适的位置放进去

//  标准做法
//针对静态数据，如何在一个包含 n 个数据的数组中，查找前 K 大数据呢？我们可以维护一个大小为 K 的小顶堆，
// 顺序遍历数组，从数组中取出数据与堆顶元素比较。
// 如果比堆顶元素大，我们就把堆顶元素删除，并且将这个元素插入到堆中；
// 如果比堆顶元素小，则不做处理，继续遍历数组。这样等数组中的数据都遍历完之后，堆中的数据就是前 K 大数据了。
// 遍历数组需要 O(n) 的时间复杂度，一次堆化操作需要 O(logK) 的时间复杂度，所以最坏情况下，n 个元素都入堆一次，时间复杂度就是 O(nlogK)。


public class Main {

    public static void main(String[] args) {
	// write your code here
        int k = 2;
        // 小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        // 大顶堆
        PriorityQueue<Integer> bigTopHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        priorityQueue.add(0);
        priorityQueue.add(3);
        priorityQueue.add(2);

        priorityQueue.add(5);

        priorityQueue.add(6);

        priorityQueue.add(1);
        while(priorityQueue.size() != k){
            priorityQueue.poll();
        }
        System.out.println("该组数第K大的数是：" +  priorityQueue.peek());
        System.out.println(priorityQueue.size());

    }
}

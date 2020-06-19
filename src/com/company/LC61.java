package com.company;
// 链表旋转  关键点 head tail length
// 引用保存某个节点状态 链表的位置
public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode newHead = head ;
        ListNode newTail = head;
        int count = 1;
        while(head.next!=null){
            head = head.next;
            count++;
        }
        head.next = newHead;
        for (int i = 0 ;i<count-k%count;i++){
            newHead = newHead.next;
        }
        ListNode temp = newHead;
        for (int i = 0 ;i<count;i++){
            newTail = temp;
            temp = temp.next;
        }
        newTail.next = null;
        return newHead;
    }
}

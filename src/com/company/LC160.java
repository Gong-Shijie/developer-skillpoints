package com.company;


public class LC160 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
        return null;
        }
        ListNode ptrA= headA;
        ListNode ptrB = headB;
        while(ptrA!=ptrB){
            //让链表A、B走相同的距离
        ptrA = ptrA==null?headB:ptrA.next;//当到达末尾的时候让他指向另外链表的开头
        ptrB = ptrB==null?headA:ptrB.next;//当到达末尾的时候让他指向另外链表的开头
        }



        return ptrA;
        }
        }
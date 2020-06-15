package com.company;

import java.util.Stack;

// 两数相加 高位在首(栈的方法解决链表逆序)
/*
*             1234
            1->2->3->4
            头插法： 当前待插的next =  头的next
                    头的next = 当前节点
                    * */

public class LC445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> sl1 = new Stack<>();
        Stack<ListNode> sl2 = new Stack<>();
        while (l1 != null) {
            sl1.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            sl2.add(l2);
            l2 = l2.next;
        }
        int carry = 0,sum = 0 ;
        ListNode head  = new ListNode(0);
        while (!sl1.isEmpty() || !sl2.isEmpty() || carry != 0) {
            sum = carry;
            sum = sl1.isEmpty()?sum:sum+ sl1.pop().val;
            sum = sl2.isEmpty()?sum:sum+ sl2.pop().val;
            ListNode  cur = new ListNode(sum%10);

            cur.next = head.next;
            head.next = cur;

            carry = sum/10;
        }
        return head.next;

    }
}

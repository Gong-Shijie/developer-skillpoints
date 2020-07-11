package com.company;

import java.util.List;
// 解题关键在构造一个 新节点
// 指针的思想辅助处理 只有next是修改，赋值都是指针
public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre;
        cur = cur.next;
        ListNode last = cur;
        pre.next = null;
        for (int i = 0; i <= n - m; i++) {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        last.next = cur;
        return result.next;
    }
}

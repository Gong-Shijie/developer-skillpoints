package com.company;

// 归并排序 链表
public class LC148 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode s = head, r = head.next, l;
        while (r != null && r.next != null) {
            s = s.next;
            r = r.next.next;
        }
        ListNode rHead = s.next;
        s.next = null;
        l = mergeSort(head);
        r = mergeSort(rHead);
        return merge(l, r);

    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        cur.next = l == null ? r : l;
        return dummyNode.next;
    }
}
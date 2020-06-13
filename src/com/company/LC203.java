package com.company;

//链表类题目可以增加一些辅助的链表来进行辅助
public class LC203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        ListNode ptr=result;
        while (head!=null){
            if(head.val!=val){
                ptr.next = head; ptr = ptr.next;
            }
            head = head.next;

        }
        return result.next;
    }
}

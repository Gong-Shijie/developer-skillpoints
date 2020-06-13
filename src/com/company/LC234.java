package com.company;

public class LC234 {
    public static void main(String[] args) {
        String temp = new String("temp");
        String temp2 = new String("temp");
        System.out.println(temp.equals(temp2));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //逆序 slow后的节点
        ListNode tail =null;
        ListNode mid = slow.next;
        slow = slow.next;
        while(slow!=null){
            ListNode temp =slow.next;
            ListNode temp2 =tail.next;
            tail.next = slow;
            slow = temp;
            slow.next = temp2;
        }
        tail = tail.next;
        while(head!=mid){
            if(head.val!=tail.val)
            {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;

    }
}

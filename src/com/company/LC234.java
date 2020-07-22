package com.company;

public class LC234 {
    public static void main(String[] args) {
        String temp = new String("temp");
        String temp2 = new String("temp");
        System.out.println(temp.equals(temp2));
        String[] result = "sd fd".split(" ");
        for(String s : result){
            System.out.println(s);
        }
    }

    public boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode lHead = head;
        cut(head, slow);
        ListNode rHead = reverse(slow);
        return compare(lHead, rHead);
    }

    private boolean compare(ListNode lHead, ListNode rHead) {
        while(lHead!=null){
            int l = lHead.val;
            int r = rHead!=null?rHead.val:l+1;
            if(l!=r)return false;
            lHead = lHead.next;
            if(rHead==null)return false;
            rHead = rHead.next;
        }
        return true;
    }

    private void cut(ListNode head, ListNode slow) {
        while(head!=slow){
            head = head.next;
        }
        head.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        while(head!=null){
            ListNode dymNext = dummyNode.next;
            ListNode headNext = head.next;
            dummyNode.next = head;
            head.next = dymNext;
            head = headNext;
        }
        return dummyNode.next;
    }

}


package com.company;

import java.util.List;

//链表逆序 增加一个辅助节点作为头节点
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LC206 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = reverseList(l1);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }

        }


    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        ListNode headtemp  = new ListNode(0);
        headtemp.next =head;
        insertHead(headtemp,head.next);
        head.next=null;
        return headtemp.next;

    }
    public static void insertHead(ListNode head, ListNode node){
        if(node==null){
          return;
        }
        ListNode tempFlag =node.next;
        ListNode temp = head.next;
        head.next = node;
        node.next = temp;
        insertHead(head,tempFlag);
    }








 }


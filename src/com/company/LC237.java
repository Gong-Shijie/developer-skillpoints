package com.company;

//只有操作了next 和 val等才会有作用，只是改变引用不会影响内存
public class LC237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

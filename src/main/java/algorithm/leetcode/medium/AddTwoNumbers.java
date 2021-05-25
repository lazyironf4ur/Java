package algorithm.leetcode.medium;

/**
 * @author:Lazy1ron
 * @date:2021/3/1 23:02
 */
public class AddTwoNumbers {

    class ListNode {
        ListNode next;
        int val;

        ListNode() {};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(ListNode next , int val) {
            this.next = next;
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1 , ListNode l2) {
        ListNode head = null , tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            int s1 = l1 != null ? l1.val : 0;
            int s2 = l2 != null ? l2.val : 0;
            sum = s1 + s2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum%10);
            } else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(1);
        }
        return head;
    }
}


//2. 两数相加
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
// https://leetcode-cn.com/problems/add-two-numbers/
//新疾控中心
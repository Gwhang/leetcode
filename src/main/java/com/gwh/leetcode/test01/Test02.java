package com.gwh.leetcode.test01;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 **
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 */
public class Test02 {

    public static void main(String[] args) {
        ListNode list1= new ListNode(2);
        ListNode list11 = new ListNode(4);
        ListNode list12 = new ListNode(3);
        list11.next = list12;
        list1.next = list11;

        ListNode list2= new ListNode(5);
        ListNode list21 = new ListNode(6);
        ListNode list22 = new ListNode(4);
        list21.next = list22;
        list2.next = list21;

        System.out.println(addTwoNumbers(list1,list2));

    }

    /**
     *
     * 链表
     * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 987 + 23 = 987 + 023 = 1010
     * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     * 如果两个链表全部遍历完毕后，进位值为 1，则在新链表最前方添加节点 1
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        // 循环链表
        while(l1 != null || l2 != null) {
            // 如果l1为空了则值为0 否则取l1的值
            int x = l1 == null ? 0 : l1.val;
            // 如果l2为空则取值为0 否则取l2的值
            int y = l2 == null ? 0 : l2.val;
            // 计算两数的和
            int sum = x + y + carry;
            // 判断是否进位
            carry = sum / 10;
            // 如果进位则取个位
            sum = sum % 10;
            // 放入返回结果
            cur.next = new ListNode(sum);
            // 指向下一个指针
            cur = cur.next;
            // 如果l1 不为空 则取l1链表指向的值
            if(l1 != null) {
                l1 = l1.next;
            }
            // 如果l2 不为空 则取l1链表指向的值
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果进位有值，则将其放入链表
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        // 预先定义的指针指向真实的链表
        return pre.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }



}

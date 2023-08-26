package demo;

import model.Node;

/**
 * @author Bryce_dd 2023/8/26 00:09
 * 将1，2，3，4，5，6，7
 * 转换成
 * 1，7，2，6，3，5，4
 */
public class Node01 {
    public static void main(String[] args) {
        Node head = Node.build(1, 2, 3, 4);
//        test1(head);
        test2(head);
    }

    public static void test2(Node head) {
        // 找链表中点
        Node index1 = head;
        Node index2 = head;
        while (index2 != null && index2.next!= null && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
        }
        // 截断成两段链表
        index2 = index1.next;
        index1.next = null;
        // 反转后半段链表
        Node index2Pre = null;
        Node index2Next = null;
        while (index2 != null) {
            index2Next = index2.next;
            index2.next = index2Pre;
            index2Pre = index2;
            index2 = index2Next;
        }
        index2 = index2Pre;
        index2.println();
        // 合并两个链表
        Node pre = head;
        Node next = null;
        while (index2 != null) {
            next = pre.next;
            pre.next = index2;
            index2 = index2.next;
            pre.next.next = next;
            pre = next;
        }
        head.println();
    }



    public static void test1(Node head) {
        Node node1 = head;
        Node node2 = head;
        while(node2 != null && node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        System.out.println(node1.value);
        System.out.println(node2.value);
        node2 = node1.next;
        node1.next = null;// 截断前半段；
        node2.println();
        // 反转链表
        Node node2Next = null;
        Node node2Pre = null;
        while (node2 != null) {
            node2Next = node2.next;
            node2.next = node2Pre;
            node2Pre = node2;
            node2 = node2Next;
        }
        node2 = node2Pre;
        node2.println();
        Node pre = head;
        Node next = null;
        while (node2 != null) {
            next = pre.next;
            pre.next = node2;
            node2 = node2.next;
            pre.next.next = next;
            pre = next;
        }
        head.println();
    }

}

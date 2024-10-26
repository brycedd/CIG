package chapter2.ctwo19;

import model.Node;

/**
 * @author Bryce_dd 2023/2/13 21:30
 */
public class Main {
    public static void main(String[] args) {
        Node node1 = Node.build(1, 3, 5, 7, 9);
        Node node2 = Node.build(0,2,4,6,8,10);
        Node merge = merge(node1, node2);
        merge.println();

    }

    public static Node merge(Node node1, Node node2) {
        // 若都为空
        if (null == node1 || null == node2) {
            return node1 == null ? node2 : node1;
        }
        // 比较两个头谁更大
        Node newHead = node1.value >= node2.value ? node2 : node1;

        Node index1 = newHead == node1 ? node1.next : node1;
        Node index2 = newHead == node2 ? node2.next : node2;

        Node pre = newHead;
        while (index2 != null && index1 != null) {
            if (index2.value <= index1.value) {
                pre.next = index2;
                pre = index2;
                index2 = index2.next;
            } else {
                pre.next = index1;
                pre = index1;
                index1 = index1.next;
            }
        }

        pre.next = index1 == null ? index2 : index1;
        return newHead;
    }
}

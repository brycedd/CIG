package chaptertwo.ctwo05;

import model.Node;

/**
 * @author Bryce_dd 2022/12/20 23:54
 */
public class Main {
    public static void main(String[] args) {
        Node head = Node.build(1, 2, 3, 4, 5, 6, 7, 8, 9);
        head.println();
        Node node = reversePart(head, 1, 9);
        node.println();
    }

    public static Node reversePart(Node head, int from, int to) {
        // 找出需要交换的前一个节点，以及需要交换的后一个节点
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) return head;
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}


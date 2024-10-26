package chapter2.ctwo18;

import model.Node;

/**
 * @author Bryce_dd 2023/2/13 21:16
 */
public class Main {
    public static void main(String[] args) {
        Node head = Node.build(1, 2, 4, 7, 9);
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        Node node = addNode(head, 0);
        node.println();
    }

    public static Node addNode(Node head, int num) {
        Node build = Node.build(num);
        if (head == null) {
            build.next = build;
            return build;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && num <= cur.value) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = build;
        build.next = cur;
        return num < head.value ? build : head;
    }
}

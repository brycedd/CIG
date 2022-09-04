package netcode;

/**
 * 克隆一个链表，链表存在rand节点；链表为单向链表；
 *
 * @author Bryce_dd 2022/9/4 23:06
 */
public class P6 {

    public static void main(String[] args) {
    }

    public static Node copy1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;
        // 一次遍历两个值， 原节点及原节点的克隆节点
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static class Node {
        private Node next;
        private Node rand;
        private final String value;

        public Node(String value) {
            this.value = value;
        }
    }
}

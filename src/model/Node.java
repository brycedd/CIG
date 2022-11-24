package model;

/**
 * @author Bryce_dd 2022/11/24 22:05
 */
public class Node {
    public int value;
    public Node next;

    public Node last;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    public static Node build(int... i) {
        Node node = null;
        Node preNode = null;
        for (int value : i) {
            if (node == null) {
                node = new Node(value);
                preNode = node;
            } else {
                Node last = preNode;
                preNode.next = new Node(value);
                preNode = preNode.next;
                preNode.last = last;
            }
        }
        return node;
    }

    public void println() {
        int i = 0;
        Node head = this;
        while (head != null) {
            System.out.printf("node:%s value = %s, lastValue = %s, nextValue = %s%n",
                    ++i,
                    head.value,
                    null != head.last ? head.last.value : null,
                    null != head.next ? head.next.value : null);
            head = head.next;
        }
    }
}

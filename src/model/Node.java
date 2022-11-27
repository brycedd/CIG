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

    public void println(boolean... printDetail) {
        System.out.print("Node: ");
        Node head = this;
        Node headDetail = this;
        while (head != null) {
            System.out.print(" " + head.value);
            head = head.next;
        }
        System.out.println();
        if (null == printDetail || printDetail.length == 0 || !printDetail[0]) {
            return;
        }
        int i = 0;
        while (headDetail != null) {
            System.out.printf("node:%s value = %s, lastValue = %s, nextValue = %s%n",
                    ++i,
                    headDetail.value,
                    null != headDetail.last ? headDetail.last.value : null,
                    null != headDetail.next ? headDetail.next.value : null);
            headDetail = headDetail.next;
        }
    }
}

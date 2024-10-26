package chapter2.ctwo11;

import model.Node;

/**
 * @author Bryce_dd 2023/1/3 23:23
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Node node = buildRingNode();
        Node ringNode = getRingNode(node);
        System.out.println(ringNode);
    }

    /**
     * 判断并找到有环链表的入环节点
     */
    public static Node getRingNode(Node head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        Node s = head.next;
        Node f = head.next.next;
        while (s != f) {
            // 判断快指针下一个值是否为null
            if (f.next == null || f.next.next == null)
                return null;
            s = s.next;
            f = f.next.next;
        }
        // 找到了相遇节点
        f = head;
        while (f != s) {
            s = s.next;
            f = f.next;
        }
        // 再次相遇，f节点则为入环节点
        return f;
    }

    public static Node buildRingNode() {
        Node build = Node.build(1, 2, 3, 4, 5, 6, 7, 8);
        Node lastNode = build;
        Node fistRingNode = null;
        while (lastNode.next != null) {
            if (4 == lastNode.value)
                fistRingNode = lastNode;
            lastNode = lastNode.next;
        }
        lastNode.next = fistRingNode;
        return build;
    }
}

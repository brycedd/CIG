package chaptertwo.ctwo20;

import model.Node;

/**
 * @author Bryce_dd 2023/2/13 22:02
 */
public class Main {
    public static void main(String[] args) {
        Node head = Node.build(1, 2, 3, 4, 5, 6, 7, 8);
        head = selfMerge(head);
        head.println();
    }

    public static Node selfMerge(Node head) {
        if (null == head || head.next == null || head.next.next == null || head.next.next.next == null) {
            return head;
        }

        Node index1 = head;
        Node index2 = head.next;
        while (index2.next != null && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
        }
        // 此时index1为前半部分最后一个节点
        index2 = index1.next;
        index1.next = null;
        Node pre = head;
        Node next = null;
        while (pre.next != null && index2.next != null) {
            next = pre.next;
            pre.next = index2;
            index2 = index2.next;
            pre.next.next = next;
            pre = next;
        }
        pre.next = index2;
        return head;
    }
}

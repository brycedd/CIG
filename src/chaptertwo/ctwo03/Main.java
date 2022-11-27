package chaptertwo.ctwo03;

import model.Node;

/**
 * 1: 删除链表中间节点
 * 2: 删除链表a/b处的节点
 *
 * @author Bryce_dd 2022/11/27 17:55
 */
public class Main {

    public static void main(String[] args) {
        Node head = Node.build(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Node node = removeMidNode(head);
        node.println();
        Node node1 = removeByRatio(Node.build(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1, 3);
        node1.println();
    }

    /**
     * 1 直接返回
     * 2 删除1
     * 3,4 删除2
     * 5,6 删除3
     * 7,8 删除4
     * 9,10 删除5
     * 此处类似双指针处理，每当后移两位，将要删除的前一位的位置则往后移动一位，当无法向后移动两位后，pri的就为要删除的
     * 节点前一节点
     */
    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByRatio(Node head, int a, int b) {
        if (head == null || a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil((double) (n * a) / (double) b);
        if (n == 1) {
            return head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

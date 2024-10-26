package chapter2.ctwo02;

import model.Node;

/**
 * 在单链表和双链表中删除倒数第k个节点：时间复杂度：O(N), 额外空间复杂度: O(1)
 *
 * @author Bryce_dd 2022/11/24 22:03
 */
public class Main {
    public static void main(String[] args) {
        Node build = Node.build(3, 4, 7, 1, 3, 7);
        Node node = removeLastKthNode(build, 3);
        node.println();
    }

    public static Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            // 刚好head就是倒数第lastKth位置
            head = head.next;
            head.last = null;
            return head;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            // 删除当前值的next
            Node newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }
}

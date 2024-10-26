package chapter2.ctwo10;

import model.Node;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/12/29 20:57
 * 求两个均为0～9value node相加
 */
public class Main {

    public static void main(String[] args) {
        Node node1 = Node.build(1, 7, 9, 0);
        Node node2 = Node.build(3, 8, 9);
//        Node sum = sum(node1, node2);
        Node sum = sum2(node1, node2);
        sum.println();
    }

    /**
     * 逆序两个链表，再相加生成新链表，再逆序回来原链表，可节省额外的栈空间
     */
    public static Node sum2(Node node1, Node node2) {
        // 反转
        Node next;
        Node pre = null;
        while (node1 != null) {
            next = node1.next;
            node1.next = pre;
            pre = node1;
            node1 = next;
        }
        Node head1 = pre;
        pre = null;
        while (node2 != null) {
            next = node2.next;
            node2.next = pre;
            pre = node2;
            node2 = next;
        }
        Node head2 = pre;

        Node res = null;
        int n = 0; // 进位
        while (head1 != null || head2 != null) {
            int p1 = 0;
            int p2 = 0;
            if (head1 != null) {
                p1 = head1.value;
                head1 = head1.next;
            }
            if (head2 != null) {
                p2 = head2.value;
                head2 = head2.next;
            }
            // 拼接结果
            Node node = new Node((p1 + p2 + n) % 10);
            node.next = res;
            res = node;
            n = (p1 + p2 + n) / 10;
        }

        if (0 != n) {
            Node node = new Node(n);
            node.next = res;
            res = node;
        }

        return res;
    }

    public static Node sum(Node node1, Node node2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node cur1 = node1;
        Node cur2 = node2;
        while (cur1 != null) {
            stack1.add(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.add(cur2);
            cur2 = cur2.next;
        }

        Node result = null;
        // 开始做加法
        int n = 0;
        while (!stack1.empty() || !stack2.empty()) {
            int p1 = stack1.empty() ? 0 : stack1.pop().value;
            int p2 = stack2.empty() ? 0 : stack2.pop().value;
            // 下一个进位
            Node node = new Node((p1 + p2 + n) % 10);
            node.next = result;
            result = node;
            n = (p1 + p2 + n) / 10;
        }
        return result;
    }
}

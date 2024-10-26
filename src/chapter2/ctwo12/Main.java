package chapter2.ctwo12;

import model.Node;

import java.util.Stack;

/**
 * @author Bryce_dd 2023/1/31 21:57
 * 给定一个单链表的头节点head，实现一个调整单链表的函数，使得每k个节点之间逆序，若不足k，则不操作
 * 例：
 * 1 2 3 4 5 6 7 8 null
 * k = 3
 * 3 2 1 6 5 4 7 8 null
 */
public class Main {
    public static void main(String[] args) {
        Node node = Node.build(1, 2, 3, 4, 5, 6, 7, 8);
//        Node node1 = reverseKNodesDD(node, 3);
//        Node node1 = reverseKNodes1(node, 3);
        Node node1 = reverseKNodes2(node, 3);
        node1.println();
    }

    /**
     * 通过栈来逆序k个元素并重新连接
     * 时间O(N) 空间O(k)
     */
    public static Node reverseKNodesDD(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node newHead = null;
        Node preTall = null;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
            if (stack.size() == k) {
                // 开始弹出逆序node
                Node pop = stack.pop();
                if (null == newHead) {
                    newHead = pop;
                }
                if (null != preTall) {
                    preTall.next = pop;
                }
                while (!stack.empty()) {
                    Node pop1 = stack.pop();
                    pop.next = pop1;
                    pop = pop1;
                }
                preTall = pop;
            }
        }
        // 处理栈内剩余
        Node last = null;
        while (!stack.empty()) {
            last = stack.pop();
        }
        if (preTall != null) {
            preTall.next = last;
        }
        return newHead;
    }

    public static Node reverseKNodes1(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = resign1(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    private static Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        Node next = null;
        while (!stack.empty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        // 此时cur已是最后一个栈内元素
        cur.next = right;
        return cur;
    }

    public static Node reverseKNodes2(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    private static void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }
}

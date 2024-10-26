package chapter2.ctwo07;

import model.Node;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/12/29 21:41
 * 判断一个链表是否为回文结构
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(Node.build(1, 2, 3, 5, 3, 2, 1)));
        System.out.println(isPalindrome2(Node.build(1, 2, 3, 5, 3, 2)));
        System.out.println(isPalindrome2(Node.build(1, 2, 2, 1)));
        System.out.println(isPalindrome2(Node.build(1, 1)));
        System.out.println(isPalindrome2(Node.build(1)));

    }

    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;

        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    /**
     * 使用栈结构保存右半段，再出栈比较
     */
    public static boolean isPalindrome(Node head) {
        if (head == null) return false;
        if (head.next == null) return true;
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> rightStack = new Stack<>();
        while (right != null) {
            rightStack.add(right);
            right = right.next;
        }
        while (!rightStack.empty()) {
            int value = rightStack.pop().value;
            if (value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

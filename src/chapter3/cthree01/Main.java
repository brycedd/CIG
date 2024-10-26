package chapter3.cthree01;

import chapter3.Node;

import java.util.Stack;

/**
 * @author Bryce_dd 2023/2/19 22:50
 */
public class Main {
    public static void main(String[] args) {
        Node simpleTree = Node.getSimpleTree();
        preOrderRecur(simpleTree);
        System.out.println();
        preOrder2(simpleTree);
        System.out.println();
        System.out.println(" in order");
        inOrderRecur(simpleTree);
        System.out.println();
        inOrder(simpleTree);
        System.out.println();
        System.out.println(" pos order");
        posOrderRecur(simpleTree);
        System.out.println();
        posOrder(simpleTree);
    }

    /**
     * 用两个栈实现后序
     */
    public static void posOrder(Node head) {
        if (null == head) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.empty()) {
            Node pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack1.push(pop.left);
            }
            if (pop.right != null) {
                stack1.push(pop.right);
            }
        }
        while (!stack2.empty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    /**
     * 递归实现后序
     */
    public static void posOrderRecur(Node head) {
        if (null == head) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 非递归实现中序
     */
    public static void inOrder(Node head) {
        if (null == head) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || head != null) {
            if (null != head) {
                stack.push(head);
                head = head.left;
            } else {
                Node pop = stack.pop();
                System.out.print(pop.value + " ");
                head = pop.right;
            }
        }
    }

    /**
     * 递归实现中序
     */
    public static void inOrderRecur(Node head) {
        if (null == head) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 利用栈实现先序遍历树
     */
    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.push(head);
        while (!nodes.empty()) {
            Node pop = nodes.pop();
            System.out.print(pop.value + " ");
            if (null != pop.right) {
                nodes.push(pop.right);
            }
            if (null != pop.left) {
                nodes.push(pop.left);
            }
        }
    }

    public static void preOrder2(Node head) {
        if (null == head) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.print(pop.value + " ");
            if (null != pop.right) {
                stack.push(pop.right);
            }
            if (null != pop.left) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 递归先序遍历树
     */
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}

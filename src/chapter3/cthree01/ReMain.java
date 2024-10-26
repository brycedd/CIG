package chapter3.cthree01;

import chapter3.Node;

import java.util.Stack;

/**
 * @author Bryce_dd 2024/3/17 20:47
 */
public class ReMain {

    public static void main(String[] args) {
        /**
         *                                       1
         *                             2                   3
         *                        4         5       6            7
         *                     8     9   10            11    12     13
         */
        Node simpleTree = Node.getSimpleTree();

        inOrder(simpleTree);
        System.out.println();
        inStackOrder(simpleTree);
    }

    private static void inStackOrder(Node node) {
        if (null == node) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node peek = stack.peek();
            if (null != peek.left) {
                stack.push(peek.left);
                continue;
            }
            Node pop = stack.pop();
            System.out.print(pop.value + " ");
            if (null != pop.right) {
                stack.push(pop.right);
            }
        }
    }

    private static void preStackOder(Node node) {
        if (null == node) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
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

    private static void lastOrder(Node node) {
        if (null == node) {
            return;
        }
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.print(node.value + " ");
    }

    private static void preOrder(Node simpleTree) {
        if (null == simpleTree) {
            return;
        }
        System.out.print(simpleTree.value + " ");
        preOrder(simpleTree.left);
        preOrder(simpleTree.right);
    }

    private static void inOrder(Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

}

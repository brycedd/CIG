package chapter3.cthree02;

import chapter3.Node;

/**
 * @author Bryce_dd 2023/2/20 23:58
 */
public class Main {
    public static void main(String[] args) {
        Node depthNode = Node.getDepthNode();
        System.out.println(depthNode);
    }

    public static int minDepth1(Node head) {
        if (null == head) {
            return 0;
        }
        return process(head);
    }

    private static int process(Node cur) {
        return 0;
    }
}

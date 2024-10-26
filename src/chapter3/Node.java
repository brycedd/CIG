package chapter3;

/**
 * @author Bryce_dd 2023/2/19 22:51
 */
public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    /**
     *                                       1
     *                             2                   3
     *                        4         5       6            7
     *                     8     9   10            11    12     13
     */
    public static Node getSimpleTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node6.right = node11;
        node7.left = node12;
        node7.right = node13;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node1.left = node2;
        node1.right = node3;
        System.out.println(" /**\n" +
                "     *                                       1\n" +
                "     *                             2                   3\n" +
                "     *                        4         5       6            7\n" +
                "     *                     8     9   10            11    12     13\n" +
                "     */");
        return node1;
    }

    public static Node getDepthNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;
        node3.right = node5;
        return node1;
    }
}

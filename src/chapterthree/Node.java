package chapterthree;

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

    public static Node getSimpleTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node1.left = node2;
        node1.right = node3;
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

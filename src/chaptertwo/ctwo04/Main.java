package chaptertwo.ctwo04;

import model.Node;

/**
 * @author Bryce_dd 2022/12/20 23:20
 */
public class Main {
    public static void main(String[] args) {
//        reverseListTest();
        reverseList2Test();
    }

    public static void reverseListTest() {
        Node build = Node.build(1, 2, 3, 4, 5);
        build.println(true);
        Node node = reverseList(build);
        node.println(true);
    }

    public static void reverseList2Test() {
        Node build = Node.build(1, 2, 3, 4, 5);
        build.println(true);
        Node node = reverseList2(build);
        node.println(true);
    }

    /**
     * 反转单向链表
     */
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     */
    public static Node reverseList2(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            // 设置当前节点的pre和next
            head.next = pre;
            head.last = next;
            // 设置下一个节点的pre
            pre = head;
            // 设置下一个遍历节点
            head = next;

        }
        return pre;
    }
}

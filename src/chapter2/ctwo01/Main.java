package chapter2.ctwo01;

import model.Node;

/**
 * 打印两个有序链表公共部分
 *
 * @author Bryce_dd 2022/11/24 21:41
 */
public class Main {

    public static void main(String[] args) {
        Node head1 = Node.build(1,3,4,5,6);
        Node head2 = Node.build(0,3,4,6);
        printCommonPart(head1, head2);
    }

    public static void printCommonPart(Node node1, Node node2) {
        Node head1 = node1;
        Node head2 = node2;
        while (head1 != null && head2 != null) {
            if (head1.value == head2.value) {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
        }
    }
}

package cone06;

import java.util.Stack;

/**
 * Tower of Hanoi 汉诺塔
 * <p>
 * A3 = 7;
 * A4 = A3 + 1 + A3
 * An = A(n-1) + 1 + A(n-1) = 2A(n-1) + 1
 *
 * @author Bryce_dd 2022/9/3 15:52
 */
public class Main {

    public static void main(String[] args) {
//        move(3, "左", "中", "右");
        int process = process(3, "A", "B", "C", "A", "C");
        System.out.println(process);
    }


    // 允许一次性从最左移动到最右
    public static void move(int n, String args1, String args2, String args3) {
        if (n == 1) {
            System.out.println("把 {" + n + "}  从 【" + args1 + "】 移动到 【" + args3 + "】");
        } else {
            move(n - 1, args1, args3, args2);
            System.out.println("把 {" + n + "}  从 【" + args1 + "】 移动到 【" + args3 + "】");
            move(n - 1, args2, args1, args3);
        }
    }

    // 不允许一次性从最左移动到最右
    public static int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }


    // 上一个条件，利用栈来解答
    public static int hanoiProblem(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.NO};
        int step = 0;
        while (rS.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record,
                                     Action preNoAct,
                                     Action nowAct,
                                     Stack<Integer> fStack,
                                     Stack<Integer> tStack,
                                     String from,
                                     String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

    public enum Action {
        NO, LToM, MToL, MToR, RToM;
    }
}

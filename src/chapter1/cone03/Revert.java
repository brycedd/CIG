package chapter1.cone03;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/8/28 22:54
 */
public class Revert {

    public static void revertStack(Stack<Integer> source) {
        if (!source.empty()) {
            Integer last = getAndRemoveLastElement(source);
            revertStack(source);
            source.push(last);
        }
    }

    private static Integer getAndRemoveLastElement(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.empty()) {
            return pop;
        } else {
            Integer last = getAndRemoveLastElement(stack);
            stack.push(pop);
            return last;
        }
    }
}

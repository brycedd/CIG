package chapterone.cone09;

import java.util.Stack;

/**
 * @author Bryce_dd 2022/9/26 23:31
 * 给定一个整型矩阵map，其中的值只有0和1两种，求其中
 * 全是1的所有矩形区域中，最大的矩形区域为1的数量；
 */
public class Main {
    public static void main(String[] args) {
        int[][] map = getMap();
        int maxArea = maxRecSize(map);
        System.out.println(maxArea);
    }


    public static int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = ints[j] == 0 ? 0 : height[j] + 1;
                // 每获得到每层的高度后，计算一次，最大矩形大小
                maxArea = Math.max(maxArea, maxRecFromBottom(height));
            }
        }
        return maxArea;
    }

    /**
     * 获得到每层高度后（例：height{3,4,5,4,3,6}）
     * 去计算每个值向左向右能延展到的最大位置，例如例子中，最后一个3，向左能延伸到第一个3，向右能
     * 延伸到最后一位，那最后一个三这个位置，的矩形面积为 3 * 6 = 18
     * 即，求每位，向左找到第一个比他小的位置，这个位置的前一位，就是能延伸的最大长度,向右同理
     */
    private static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] >= height[i]) {
                // 当当前栈顶(j)大于或等于当前索引值时，弹出栈顶，并计算当前值，矩形面积
                // 被弹出栈顶向右能扩展的最大index为i - 1；若弹出后栈顶index记为k，则向左能扩展的最大值为k + 1
                // 则，最大面积为 height[j] * ((i - 1) - (k + 1) + 1) = height[j] * (i - k - 1)
                // 特殊情况为height[j] = index[i] 此时弹出的右边界不准，但我们是求最大面积，因为相等，那么i一定会被压入栈，计算i时，
                // 最大面积会被正确计算
                int j = stack.pop();
                // 计算面积
                int k = stack.empty() ? -1 : stack.peek(); // 处理边界：当弹出后栈为空时，说明向左无法延伸，记为-1
                maxArea = Math.max(maxArea, height[j] * (i - k - 1));
            }
            // 仅当栈为空，或栈顶元素小于当前元素时，才将当前index压入栈
            // 保证栈结构从栈底到栈顶为由小到大，且不重复
            stack.push(i);
        }
        // 依次弹出剩下的值：此时栈为自底到顶依次递增且不重复, 且栈顶值，一定为height数组最后一个值
        // 则，向右能扩展的最大长度为height.length - 1
        while (!stack.empty()) {
            int j = stack.pop();
            int k = stack.empty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, height[j] * (height.length - k - 1));
        }
        return maxArea;
    }

    /**
     * 0 1 2 3 4 5
     * --------------
     * 0 1 0 0 1 1     |0
     * 0 0 1 0 1 1     |1
     * 0 1 1 1 0 1     |2
     * 1 1 1 1 1 1     |3
     * 1 1 1 1 1 1     |4
     * 1 1 1 1 1 1     |5
     * --------------
     * 最后一层的height高度值为
     * height{3,4,5,4,3,6}
     */
    private static int[][] getMap() {
        int[][] map = new int[6][6];
        map[0][0] = 0;
        map[0][1] = 1;
        map[0][2] = 0;
        map[0][3] = 0;
        map[0][4] = 1;
        map[0][5] = 1;

        map[1][0] = 0;
        map[1][1] = 0;
        map[1][2] = 1;
        map[1][3] = 0;
        map[1][4] = 1;
        map[1][5] = 1;

        map[2][0] = 0;
        map[2][1] = 1;
        map[2][2] = 1;
        map[2][3] = 1;
        map[2][4] = 0;
        map[2][5] = 1;

        map[3][0] = 1;
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[3][5] = 1;

        map[4][0] = 1;
        map[4][1] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[4][4] = 1;
        map[4][5] = 1;

        map[5][0] = 1;
        map[5][1] = 1;
        map[5][2] = 1;
        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;
        return map;
    }

}

package netcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bryce_dd 2022/10/10 23:03
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                index++;
                continue;
            }
            int s = index + 1;
            int e = nums.length - 1;
            while (s < e) {
                int sum = nums[s] + nums[e];
                if (sum + nums[index] > 0) e--;
                if (sum + nums[index] < 0) s++;
                if (sum + nums[index] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[index]);
                    res.add(nums[s]);
                    res.add(nums[e]);
                    result.add(res);
                    s++;
                    e--;
                    while (s < e && nums[s] == nums[s - 1]) s++;
                    while (s < e && nums[e] == nums[e + 1]) e--;
                }
            }
            index++;
        }
        return result;
    }
}

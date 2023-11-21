package sort;

import java.util.Arrays;

import static sort.ArrayUtils.append;

/**
 * @author Bryce_dd 2023/9/18 14:26
 */
public class QuickSort {
    public static void main(String[] args) {
        System.out.println("QuickSort");
        Integer[] arr = {2, 5, 2, 1, 3, 7, 4, 5, 5, 6, 9, 0};
        Integer[] ints = quickSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static Integer[] quickSort(Integer[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int splitData = arr[0];
        Integer[] low = new Integer[0];
        Integer[] high = new Integer[0];
        Integer[] mid = new Integer[0];
        mid = append(mid, splitData);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < splitData) {
                low = append(low, arr[i]);
            } else if (arr[i] > splitData) {
                high = append(high, arr[i]);
            } else {
                mid = append(mid, arr[i]);
            }
        }
        low = quickSort(low);
        high = quickSort(high);
        return append(append(low, mid), high);
    }
}

package sort;

import java.util.Arrays;
import java.util.Random;

import static sort.ArrayUtils.cut;

/**
 * @author Bryce_dd 2023/9/18 15:21
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println("MergeSort");
//        Integer[] arr = {2, 5, 2, 1, 3, 7, 4, 5, 5, 6, 9, 0};
        Integer[] arr = getArr(1000000);
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        System.out.println(start);
        arr = mergeSort(arr);
        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(Arrays.toString(arr));
    }

    private static Integer[] getArr(int i) {
        Integer[] arr = new Integer[i];
        Random random = new Random();
        for (int j = 0; j < i; j++) {
            arr[j] = random.nextInt(1000000);
        }
        return arr;
    }

    private static Integer[] mergeSort(Integer[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
//        if (len <= 1000) {
//            return QuickSort.quickSort(arr);
//        }
        int mid = len / 2;
        Integer[] left = mergeSort(cut(arr, 0, mid));
        Integer[] right = mergeSort(cut(arr, mid, len));
        return merge(left, right);
    }

    private static Integer[] merge(Integer[] left, Integer[] right) {
        int i = 0, j = 0, index = 0;
        Integer[] result = new Integer[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[index++] = left[i++];
            } else {
                result[index++] = right[j++];
            }
        }
        while (i < left.length) {
            result[index++] = left[i++];
        }

        while (j < right.length) {
            result[index++] = right[j++];
        }
        return result;
    }
}

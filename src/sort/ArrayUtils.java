package sort;

import java.lang.reflect.Array;

/**
 * @author Bryce_dd 2023/9/18 15:21
 */
public class ArrayUtils {
    @SafeVarargs
    public static <T> T[] append(T[] arr, T... values) {
        if (arr.length == 0) {
            return values;
        }
        int len = values.length;
        @SuppressWarnings("unchecked")
        T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length + len);
        for (int i = 0; i < newArr.length; i++) {
            if (i <= arr.length - 1) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = values[i - arr.length];
            }
        }
        return newArr;
    }

    /**
     * [)
     */
    public static <T> T[] cut(T[] arr, int startIndex, int endIndex) {
        if (null == arr || arr.length == 0 || startIndex >= endIndex || endIndex > arr.length) {
            return arr;
        }
        int size = endIndex - startIndex;
        @SuppressWarnings("unchecked")
        // java.util.Arrays.copyOfRange(U[], int, int, java.lang.Class<? extends T[]>)
        T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), size);
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i + startIndex];
        }
        return newArr;
    }

    public static <T> T feildCast(Class<? extends T> clz, Object obj) {
        if (clz.isInstance(obj)) {
            return clz.cast(obj);
        } else {
            throw new IllegalArgumentException("clz cast error! obj");
        }
    }
}

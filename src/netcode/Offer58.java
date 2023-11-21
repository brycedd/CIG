package netcode;

/**
 * @author Bryce_dd 2023/9/12 15:53
 */
public class Offer58 {

    public static void main(String[] args) {
//        String str = "i am a superman";
        String str = "i ";
        System.out.println(test(str));
    }

    public static String test(String str) {
        char[] charArray = str.toCharArray();
        reverse(charArray, 0, charArray.length - 1);
        System.out.println(String.valueOf(charArray));
        reverseWord(charArray);
        return String.valueOf(charArray);
    }

    private static void reverseWord(char[] reverse) {
        int start = 0;
        int end;
        for (int i = 0; i < reverse.length; i++) {
            if (' ' ==  reverse[i]) {
                end = i - 1;
                reverse(reverse, start, end);
                start = i + 1;
            }
        }
    }

    public static void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            char c = charArray[end];
            charArray[end] = charArray[start];
            end--;
            charArray[start] = c;
            start++;
        }
    }
}

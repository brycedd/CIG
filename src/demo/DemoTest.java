package demo;

/**
 * @author Bryce_dd 2023/8/29 00:43
 */
public class DemoTest {
    public static void main(String[] args) {
        String str = "cdabcdcbadc";
        int i = 0;
        int j = str.length() -1;
        boolean flag = true;
        for (;i <= j; i++) {
            if(str.charAt(i) == str.charAt(j)) {
                System.out.println("a: " + str.charAt(i) + " b: " + str.charAt(j));
                j--;
                System.out.println("====");
            } else {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}

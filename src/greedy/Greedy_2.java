package greedy;

import java.util.Scanner;

/** 곱하기 혹은 더하기
 *
 * 대부분의 경우 + 보다는 x 가 값을 더 크게 만든다.
 * 두 수 중에서 하나라도 0 혹은 1인 경우, 곱하기 보다는 더하기를 수행하는 것이 효율적이다.
 * 따라서 두 수에 대하여 연산을 수행할 때, 두 수 중에서 하나라도 1 이하인 경우에는 더하며,
 * 두 수가 모두 2 이상인 경우에는 곱하면 정답이다.
 *
 * */

public class Greedy_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        /** 쌤이 푼 풀이 */
        long result = str.charAt(0) - '0';

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        System.out.println(result);

        /** 내가 푼 풀이
        int result = 0;
        int[] c = new int[str.length()];
        String[] s = str.split("");

        for (int i = 0; i < s.length; i++) {
            c[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < c.length; i++) {
            if (c[i] <= 1 || result <= 1) {
                result += c[i];
            } else {
                result *= c[i];
            }
        }

        System.out.println(result);

         */

    }
}

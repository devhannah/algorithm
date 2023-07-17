package dp;

import java.util.Scanner;

/***
 * 1로 만들기 문제
 * x가 주어졌을 떼,
 * x기 5로 나누어 떨어지면 5로 나누고
 * 3으로 나누어 떨어지면 3으로 나누고
 * 2로 나누어 떨어지면 2로 나누고
 * x에서 1빼기
 *
 * 26 -> 25 -> 5 -> 1 연산의 최솟값 구하기
 */

public class DynamicProgramming_2 {

    public static int[] d = new int[30001];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        for (int i = 2; i <= x + 1; i++) {
            // 현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            if (x % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            } else if (x % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            } else if (x % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }

        System.out.println(d[x]);
        // 26 -> 25 -> 5 -> 1
    }
}

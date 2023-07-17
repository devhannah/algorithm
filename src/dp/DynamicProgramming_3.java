package dp;

import java.util.Arrays;
import java.util.Scanner;

/***
 * 효율적인 화폐 구성 문제
 * 첫째 줄에 N, M 이 주어짐
 * 이후의 N개의 줄에는 각 화폐의 가치가 주어짐
 * 화폐의 가치는 10,000 보다 작거나 같은 가연수
 *
 * 첫째 줄에 최소 화폐 개수 출력
 * 불가능할 때는 -1
 */

public class DynamicProgramming_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }
        // dp table 초기화
        int[] d = new int[M + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int i = 0; i < N; i++) { // i -> 각각의 화폐 단위
            for (int j = money[i]; j <= M; j++) { // j -> 각각의 금액
                // (i - k)원을 만드는 방법이 존재하는 경우
                if (d[j - money[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - money[j]] + 1);
                }
            }
        }

        if (d[M] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(d[M]);
        }
    }
}

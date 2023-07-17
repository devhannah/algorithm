package dp;

import java.util.Scanner;

/***
 * 금광 문제
 * N X M 크기의 금광이 있음
 * 금광은 1 X 1 크기의 칸으로 나누어져 있으며,
 * 각 칸에는 특정한 크기의 금이 들어있음
 *
 * 채굴자는 첫번재 열부터 출발하여 금을 캐기 시작함
 * 맨처음에는 첫번째 열의 어느 행에서든 출발할 수 있음
 * 이후에 M - 1 번에 걸쳐서 매번 오른쪽 위, 오른쪽, 오른쪽 아래 3가지 중 하나의 위치로 이동해야 함
 * 결과적으로 채굴자가 얻을 수 있는 금의 최대 크기를 출력하기
 */

public class DynamicProgramming_4_1 {

    static int testCase, n, m;
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            // dp 테이블 초기화
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    dp[j][k] = arr[j][k];
                }
            }
            // dp 진행
            for (int k = 1; k < m; k++) {
                for (int j = 0; j < n; j++) {
                    int leftUp, leftDown, left;
                    // 왼쪽 위에서 오는 경우
                    if (j == 0) leftUp = 0;
                    else leftUp = dp[j - 1][k - 1];
                    // 왼쪽 아래에서 오는 경우
                    if (j == n - 1) leftDown = 0;
                    else leftDown = dp[j + 1][k - 1];
                    // 왼쪽에서 오는 경우
                    left = dp[j][k - 1];
                    dp[j][k] = dp[j][k] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int result = 0;
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[j][m - 1]);
            }
            System.out.println(result);
        }

    }

}

package dp;

import java.util.Arrays;
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

/* 잘못 푼 문제 */
public class DynamicProgramming_4 {
    public static int[][] d = new int[21][21];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        while (T != 0) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            int sum = 0;

            for (int i = 0; i < M; i++) {
                d[0][0] = arr[0][0];
                for (int j = 1; j < N; j++) {
                    d[j][i] = Math.max(arr[j - 1][i], arr[j][i]);
                    count = d[j][i];
                }
                sum += count;
            }
            T--;
            System.out.println(sum);
        }

    }

}

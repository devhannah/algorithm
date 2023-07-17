package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/***
 * 병사 배치하기 문제 해결 아이디어
 * 가장 긴 증가하는 부분 수열 (Longest Increasing Subsequence, LIS)
 * 본 문제는 가장 긴 감소하는 부분 수열을 찾는 문제로 치환할 수 있음
 */
public class DynamicProgramming_5_1 {

    static int N;
    static ArrayList<Integer> v = new ArrayList<>();
    static int[] dp = new int[2000];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            v.add(sc.nextInt());
        }
        // 순서를 뒤집어서 '최장 증가 부분 수열' 문제로 변환
        Collections.reverse(v);
        // 1차원 dp 테이블 초기화
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 열외해야 하는 병사의 최소의 수를 출력
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            maxVal = Math.max(maxVal, dp[i]);
        }
        System.out.println(N - maxVal);


    }

}

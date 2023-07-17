package implementation;

import java.util.Scanner;

/** 시각: 문제 해결 아이디어
 * 가능한 모든 시각의 경우를 하나씩 모두 세서 풀 수 있는 문제
 * 하루는 86,400초이므로, 00시 00분 00초부터 23시 59분 59초까지의 모든 경우는 86,400가지임
 * 따라서 단순히 시각을 1씩 증가시키면서 3이 하나라도 포함되어 있는지를 확인하면 됨
 * 이러한 유형은 완전 탐색(Brute Forcing) 문제 유형이라고 불림
 * 가능한 모든 경우의 수를 모두 검사해보는 탐색 방법을 의미
 * */

public class Implementation_2 {

    // 특정한 시각 안에 '3'이 포함되어 있는지의 여부를 알려주는 함수
    public static boolean check (int i, int j, int k) {

        if (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (check(i, j, k)) { count += 1; }
                }
            }
        }

        System.out.println(count);

    }

}

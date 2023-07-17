package dp;

import java.util.HashSet;
import java.util.Scanner;

/***
 * 병사 배치하기 문제
 * 첫째 줄에 N이 주어지고 둘째 줄에 각 병사의 전투력이 공백으로 구분되어 차례로 주어짐
 * 첫째 줄에 남아 있는 병사의 수가 최대가 되도록 하기 위해서 열외시켜야 하는 병사의 수를 출력하기
 */

public class DynamicProgramming_5 {

    public static int[] result = new int[2000];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            result[0] = arr[0];
            for (int j = 1; j < N; j++) {
                if (arr[j - 1] == arr[j]) {
                    continue;
                }
                result[j] = Math.max(arr[j - 1], arr[j]);
                hs.add(result[j]);
            }
        }

        System.out.println(N - hs.size());

    }
}

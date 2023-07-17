package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sorting_1 {

    /**
     * 두 배열의 원소 교체
     * 첫 번째 줄에 N, K 가 공백을 기준으로 구분되어 입력됨
     * 두 번째 줄에 배열 A의 원소들이 공백을 기준으로 구분 입력
     * 세 번째 줄에 배열 B의 원소들이 공백을 기준으로 구분 입력
     *
     * 최대 K 번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        Integer[] A = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            if (A[i] < B[i]) {
                int temp = A[i];
                A[i] = B[i];
                B[i] = temp;
            } else {
                continue;
            }
        }

        int sum = Arrays.stream(A).mapToInt(e -> e).sum();
        System.out.println(sum);
    }

}

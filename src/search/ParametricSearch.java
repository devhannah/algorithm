package search;


/**
 * 파라메트릭 서치란 최적화 문제를 결정 문제('예' 혹은 '아니오')로 바꾸어 해결하는 기법
 * 예시 -> 특정한 조건을 만족하는 가장 알맞은 값을 빠르게 찾는 최적화 문제
 * 일반적으로 코딩 테스트에서 파라메트릭 서치 문제는 이진 탐색을 이용하여 해결할 수 있음
 * */

import java.util.Scanner;

/**
 * [ 떡볶이 떡 만들기 ]
 * 적절한 높이를 찾을 때까지 이진 탐색을 수행해서 높이 H를 반복 조정하기
 * 조건의 만족 여부에 따라서 탐색 범위를 좁혀 나가야 하고
 * 탐색 범위가 큰 경우에는 가장 먼저 이진 탐색을 떠올려야 함
 * */
public class ParametricSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        /* 이진 탐색을 위한 시작과 끝점 */
        int start = 0;
        int end = (int) 1e9;
        int result = 0;

        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                // 잘랐을 때 떡의 양 계산
                if (arr[i] > mid) {
                    total += arr[i]- mid;
                }
            }
            if (total < M) {
                // 떡의 양이 부족한 경우 더 많이 자르기 (왼쪽 부분 탐색)
                end = mid - 1;
            } else {
                // 떡의 양이 충분한 경우 덜 자르기 (오른쪽 부분 탐색)
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에 result 기록
                start = mid + 1;
            }
        }

        System.out.println(result);

    }

}

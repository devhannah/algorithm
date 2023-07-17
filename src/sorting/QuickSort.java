package sorting;

import java.util.Arrays;

public class QuickSort {

    /**
     * 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
     * 일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나
     * 병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘
     *
     * 첫 번째 데이터를 기준 데이터(pivot)로 설정
     *
     * 퀵 정렬은 평균의 경우 O(NlogN)의 시간 복잡도를 가짐
     * 최악의 경우 O(N^2)의 시간 복잡도를 가짐
     *
     * */

    public static void quickSort(int[] arr, int start, int end) {

        // 원소가 1개인 경우 탈출 조건
        if (start >= end) { return; }

        int pivot = start;
        int left = start + 1;
        int right = end;

        /** pivot 기준으로 분할 할게요 */

        while (left <= right) {
            // pivot 보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;
            // pivot 보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;
            // 엇갈렸다면? 작은 데이터와 pivot 값을 교체
            // 엇갈리기 전까지 pivot 값은 바뀌지 않고 고정일 것
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
                // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 분할 이후, 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);

    }

    public static void main(String[] args) {

        int N = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, N - 1);
        System.out.print(Arrays.toString(arr));

    }

}

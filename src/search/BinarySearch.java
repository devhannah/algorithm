package search;

import java.util.Scanner;

/**
 * [ 이진 탐색 ]
 * 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는 것
 * -> 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘
 * 중간점을 포함해서 범위를 줄여나가야 함
 *
 * 단계마다 탐색 범위를 2로 나누는 것과 동일
 * 연산 횟수는 log2 N에 비례함
 * 이진 탐색은 탐색 범위를 절반씩 줄이며, 시간 복잡도는 O(logN)을 보장함
 *
 * */

/**
 * 정렬된 배열에서 특정 수의 개수 구하기
 * 첫째 줄에 N 과 원소 x 가 정수 형태로 공백 구분되어 입력
 * 둘째 줄에 N 개의 원소가 정수 형태로 공백으로 구분되어 입력
 * 수열의 원소 중에서 값이 x인 원소 개수를 출력 -> 값이 x인 원소가 하나도 없다면 -1 출력
 * */

public class BinarySearch {

    public static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, target, 0, N - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

}

package sorting;

public class CountSort {

    /**
     * 특정한 조건이 부합할 때만 사용할 수 있음
     * 계수 정렬은 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때 사용이 가능함
     * 데이터의 개수가 N, 데이터의(양수) 중 최댓값이 K 일 때, 최악의 경우에도
     * 수행 시간 O(N + K) 를 보장
     *
     * 동일한 값을 가지는 데이터가 여러 개 등장할 때 효과적으로 사용할 수 있음
     * -> 성적의 경우 100점 맞은 학생이 여럿일 수 있기 때문에 계수 정렬이 효과적
     * */

    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {

        int N = 15;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < N; i++) {
            cnt[arr[i]] += 1;
        }
        for (int i = 0; i <= MAX_VALUE; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " ");
            }
        }

    }
}

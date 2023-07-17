package sorting;

public class SelectionSort {

    /**
     * 선택 정렬은 N번 만큼 가장 작은 수를 찾아서 맨 앞으로 보내야 함
     * 구현 뱡식에 따라서 사소한 오차는 있을 수 있지만, 전체 연산 횟수는
     * 등차수열로 구할 수 있음
     * 시간 복잡도 = O(N^2)
     *
     * */


    public static void main(String[] args) {

        int N = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < N; i++) {
            int min_idx = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[min_idx] > arr[j]) {
                    min_idx = j;
                }
            }
            /** swap 연산 */
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

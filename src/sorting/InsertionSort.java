package sorting;

public class InsertionSort {

    /**
     * 삽입 정렬
     * 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입
     * 선택 정렬에 비해서 더 빠르게 동작함
     *
     * 첫 번째 데이터는 정렬이 이미 되어있다고 판단하고,
     * 두 번째 데이터가 어떤 위치로 들어갈지 판단을 해야함
     *
     * step 1. 이어서 다음 데이터가 어디로 들어갈지 판단하면 됨
     * -> 차례대로 왼쪽에 있는 데이터와 비교해서 왼쪽 오른쪽을 판단하면 된다
     * step 2. 이어서 다음 데이터가 어디로 들어갈지 판단
     * -> 위의 작업을 반복
     *
     * 시간 복잡도는 O(N^2)
     * 최선의 경우 -> 이미 모두 정렬된 배열의 경우 O(N)
     * */

    public static void main(String[] args) {

        int N = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < N; i++) {
            // idx i 부터 1까지 감소하며 반복하는 문법
            for (int j = i; j > 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                if (arr[j] < arr[j - 1]) {
                    /** swap */
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    // 작은 데이터를 만나면 멈춤
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}

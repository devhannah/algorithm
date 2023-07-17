package dp;

/**
 * 메모이제이션은 다이나믹 프로그래밍을 구현하는 방법 중 하나이다
 * 한 번 계산한 결과를 메모리 공간에 메모하는 기법
 * 같은 문제를 다시 호출하면 메모했던 결과를 그대로 가져옴
 * 값을 기록해 놓는다는 점에서 캐싱(Caching)이라고도 함
 *
 * [top-down] 하향식
 * [bottom-up] 상향식
 *
 * 다이나믹 프로그래밍의 전형적인 형태는 bottom-up 방식
 * 결과 저장용 배열은 DP 테이블이라고 부름
 *
 * 다이나믹 프로그래밍 문제에서는 각 부분 문제들이 서로 영향을 미치며 부분 문제가 중복이 됨
 * 반면에 분할 정복 문제에서는 동일한 문제가 반복적으로 계산되지 않음
 * */

public class Memoization {

    public static long[] d = new long[100];
    public static void main(String[] args) {

        // 첫번째 피보나치 수와 두번째 피보나치 수는 1
        d[1] = 1;
        d[2] = 1;
        int n = 50;

        // 피보나치 함수 반복문으로 구현 (bottom-up dynamic programming)
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[n]);

    }

}

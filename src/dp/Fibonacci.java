package dp;

/**
 * 피보나치 수열
 * 다이나믹 프로그래밍을 사용해 효과적으로 계산할 수 있음
 * 점화식?
 * 인접한 항들 사이의 관계식을 의미
 * 프로그래밍에서는 이러한 수열을 배열이나 리스트로 표현할 수 있음
 * */

public class Fibonacci {

    public static int fibonacci(int x) {
        if (x == 1 || x == 2) return 1;
        return fibonacci(x - 1) + fibonacci( x - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }

    /**
     * 단순 재귀 함수로 피보나치 수열을 해결하려고 하면 지수 시간 복잡도를 가지게 됨
     * 동일한 부분이 반복적으로 호출이 됨
     * f(2) 가 여러번 호출 = 중복되는 부분 문제
     * */

}

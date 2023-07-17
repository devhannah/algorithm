package greedy;

import java.util.Scanner;

/** 1이 될 때까지 */

public class Greedy_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;

        while (true) {

            int target = ( N / K ) * K;
            result += ( N - target);
            N = target;

            if (N < K) break;
            result += 1;
            N /= K;
        }

        result += N - 1;
        System.out.println(result);
    }
}

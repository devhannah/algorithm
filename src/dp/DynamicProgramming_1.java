package dp;

import java.util.Scanner;

/***
 * 개미 전사
 * 개미 전사는 부족한 식량을 충당하고자 메뚜기 마을의 식량 창고를 공격하려고 함
 * 식량창고는 일직선으로 이어져 있고, 각 식량창고에는 정해진 수의 식량을 저장하고 있으며,
 * 개미 전사는 식량창고를 선택적으로 약탈할 수 있음
 * 단, 서로 인접한 식량창고가 공격받으면 바로 알아챌 수 있기 때문에
 * 최소한 한 칸 이상 떨어진 식량창고를 약탈해야 함
 *
 * 첫번째 줄에 식량창고의 개수 N이 주어짐
 * 둘째 줄에 공백을 기준으로 각 식량창고에 저장된 식량의 개수 K가 주어짐
 * 개미 전사가 얻을 수 있는 식량의 최댓값은?
 */
public class DynamicProgramming_1 {

    public static int[] d = new int[100];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] earn = new int[N];
        for (int i = 0; i < N; i++) {
            earn[i] = sc.nextInt();
        }

        d[0] = earn[0];
        d[1] = Math.max(earn[0], earn[1]);
        for (int i = 2; i < N; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + earn[i]);
        }

        System.out.println(d[N - 1]);

    }

}

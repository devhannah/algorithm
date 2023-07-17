package implementation;

import java.util.Scanner;

/** 상하좌우 문제
 * L : 왼쪽으로 한칸 이동
 * R : 오른쪽으로 한칸 이동
 * U : 위로 한칸 이동
 * D : 아래로 한칸 이동
 * 주어진 공간을 벗어나는 움직임은 무시한다.
 * */

public class Implementation_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1;
        int y = 1;

        // L, R, U, D
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // plans 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);

            // 초기화
            int nX = -1;
            int nY = -1;

            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nX = x + directions[j][0];
                    nY = y + directions[j][0];
                }
            }

            // 공간을 벗어나는 경우 무시해야 함 //
            if (nX < 1 || nY < 1 || nX > N || nY > N) continue;
            x = nX;
            y = nY;
        }

        System.out.println(x + " " + y);

    }

}

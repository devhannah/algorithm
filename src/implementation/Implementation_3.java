package implementation;

import java.util.Scanner;

/** 왕실의 나이트 : 문제 조건
 * 전형적인 구현 문제
 * */

public class Implementation_3 {

    /* 이걸 쓰고 싶었는데 못 씀 더 연구해보기 */
    public static int[][] directions = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {

        // a1
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int row = str.charAt(1) - '0';
        int col = str.charAt(0) - 'a' + 1;

        int result = 0;
        int nextRow = -1;
        int nextCol = -1;

        for (int j = 0; j < 8; j++) {

            nextRow = row + dx[j];
            nextCol = col + dy[j];

            if (nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8) {
                result += 1;
            }

        }

        System.out.println(result);

    }

}

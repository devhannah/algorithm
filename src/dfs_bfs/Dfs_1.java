package dfs_bfs;

import java.util.Scanner;

/**
 * dfs 알고리즘 활용
 * 1. 특정한 지점의 주변 상, 하, 좌, 우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직 방문하지
 *      않은 점이 있다면 해당 지점을 방문
 * 2. 방문한 지점에서 다시 상, 하, 좌, 우를 살펴보면서 방문을 진행하는 과정을 반복하면,
 *      연결된 모든 지점을 방문할 수 있음
 * 3. 모든 노드에 대하여 1 ~ 2번의 과정을 반복하며, 방문하지 않은 지점의 수를 카운트
 *
 * [음료수 얼려 먹기]
 * 1. 첫번째 줄에 얼음 틀의 세로 길이 N, 가로 길이 M이 주어짐
 * 2. 두번째 줄부터 N + 1 번째 줄가지 얼음 틀의 형태가 주어짐
 * 구멍이 뚫린 부분은 0, 아닌 부분은 1
 * 한번에 만들 수 있는 아이스크림의 개수는?
 *
 * */
public class Dfs_1 {

    public static int N, M;
    public static int[][] graph = new int[1001][1001];

    // dfs 로 특정 노드 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        // 종료 조건
        if (x <= -1 || x >= N || y <= -1 || y >= M) {
            return false;
        }

        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        // 버퍼 지우기 -> 문자열 받을 것이기 때문에

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(i) - '0';
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }

}

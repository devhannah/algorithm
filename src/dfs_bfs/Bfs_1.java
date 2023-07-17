package dfs_bfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * [ 미로 탈출 문제 ]
 * 동빈이는 N x M 크기의 직사각형 미로에 갇힘
 * 동빈이의 위치는 (1, 1), 미로의 출구는 (N, M)의 위치에 존재 한 번에 한 칸씩 이동 가능
 * 괴물이 있는 부분은 0, 괴물이 없는 부분은 1로 표시
 * 미로는 반드시 탈출이 가능한 형태
 * 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수는?
 *
 * 5 6
 * 101010
 * 111111
 * 000001
 * 111111
 * 111111
 *
 * 10
 *
 * bfs 알고리즘 활용
 * 간선의 비용이 모두 같을 때 최단 거리릍 탐색할 수 있는 알고리즘
 * bfs 는 시작 지점에서 가까운 노드부터 차례대로 그래프의 모든 노드를 탐색함
 * 상, 하, 좌, 우로 연결된 모든 노드로의 거리가 1로 동일
 *
 * */

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
public class Bfs_1 {

    public static int N;
    public static int M;
    public static int[][] graph = new int[201][201];

    // 이동할 네가지 방향 정리
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        // queue 구현을 위해 queue 라이브러리 사용
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];
                if (nX < 0 || nX > N || nY < 0 || nY > M) {
                    continue;
                }
                if (graph[nX][nY] == 0) continue;
                if (graph[nX][nY] == 1) {
                    graph[nX][nY] = graph[x][y] + 1;
                    q.offer(new Node(nX, nY));
                }
            }
        }
        return graph[N - 1][M - 1];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // bfs 를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }

}

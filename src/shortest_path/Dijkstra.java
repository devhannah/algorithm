package shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

}
public class Dijkstra {

    // 무한을 의미하는 값으로 10억을 설정
    public static final int INF = (int)1e9;
    // 노드의 개수 N, 간선의 개수 M, 시작 노드의 번호 START
    public static int N, M, START;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    // index, distance
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 방문 여부 확인을 위한 배열
    public static boolean[] visited = new boolean[100001];
    // 최단 거리 테이블
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int min_val = INF;
        // 가장 최단 거리가 짧은 노드(인덱스)
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            if (d[i] < min_val && !visited[i]) {
                min_val = d[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void dijkstraAlgorithm(int START) {
        d[START] = 0;
        visited[START] = true;
        for (int i = 0; i < graph.get(START).size(); i++) {
            d[graph.get(START).get(i).getIndex()] = graph.get(START).get(i).getDistance();
        }
        for (int i = 0; i < N - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        START = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstraAlgorithm(START);

        for (int i = 1; i <= N ; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }

    }

}

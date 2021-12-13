package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4485 {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;

        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        int num = 1;
        String cave;
        while (!(cave = br.readLine()).equals("0")) {
            N = Integer.parseInt(cave);
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = dijkstra();
            sb.append("Problem ").append(num++).append(": ").append(cost).append("\n");
        }

        System.out.println(sb);
    }

    public static int dijkstra() {

        Queue<Node> q = new PriorityQueue<>();
        int[][] move = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }

        q.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while (!q.isEmpty()) {
            Node pos = q.poll();
            int px = pos.x, py = pos.y;
            int cost = pos.cost;

            if (px == N - 1 && py == N - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dir[i][0];
                int ny = py + dir[i][1];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) continue;

                if (cost + map[ny][nx] < move[ny][nx]) {
                    move[ny][nx] = cost + map[ny][nx];
                    q.add(new Node(nx, ny, cost + map[ny][nx]));
                }
            }
        }
        return -1;
    }
}

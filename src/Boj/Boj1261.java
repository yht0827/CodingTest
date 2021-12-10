package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1261 {

    static class Node implements Comparable<Node> {

        int x, y, block;

        public Node(int x, int y, int block) {
            this.x = x;
            this.y = y;
            this.block = block;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(block, o.block);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M, N;
    static int[][] map;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static Queue<Node> q = new PriorityQueue<>();
    static boolean[][] checked;
    static int result;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        checked = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        q.add(new Node(1, 1, 0));
        checked[1][1] = true;

        while (!q.isEmpty()) {
            Node poll = q.poll();

            if (poll.x == N && poll.y == M) {
                result = poll.block;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = poll.x + dir[i][0];
                int dy = poll.y + dir[i][1];

                if (dx <= 0 || dy <= 0 || dx > N || dy > M || checked[dx][dy]) continue;

                checked[dx][dy] = true;
                q.add(new Node(dx, dy, poll.block + map[dx][dy]));
            }
        }

        System.out.println(result);
    }

}

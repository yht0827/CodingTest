package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1865 {

    static class Node {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int TC, N, M, W, INF = 987654321;
    static Node[] node;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        TC = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            node = new Node[2 * M + W];

            // 도로의 정보
            int idx = 0;
            for (int j = 0; j < M + W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if (j < M) {
                    node[idx++] = new Node(S, E, T);
                    node[idx++] = new Node(E, S, T);
                } else {
                    node[idx++] = new Node(S, E, T * -1);
                }
            }
            sb.append(bellmanFord() ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bellmanFord() {
        Arrays.fill(dist, INF);

        dist[1] = 0;

        for (int i = 1; i < N; i++) {

            for (Node value : node) {
                if (dist[value.end] > dist[value.start] + value.weight) {
                    dist[value.end] = dist[value.start] + value.weight;
                }
            }
        }

        // 음수 사이클
        for (Node value : node) {
            if (dist[value.end] > dist[value.start] + value.weight) {
                return true;
            }
        }
        return false;
    }
}

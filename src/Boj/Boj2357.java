package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2357 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    static class SegmentTree {

        long[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        public long minInit(long[] arr, int node, int start, int end) {

            if (start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] =
                    Math.min(minInit(arr, node * 2, start, (start + end) / 2),
                            minInit(arr, node * 2 + 1, (start + end) / 2 + 1, end));
        }

        public long maxInit(long[] arr, int node, int start, int end) {

            if (start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] =
                    Math.max(maxInit(arr, node * 2, start, (start + end) / 2),
                            maxInit(arr, node * 2 + 1, (start + end) / 2 + 1, end));
        }


        public long maxFind(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return Long.MIN_VALUE;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            return Math.max(maxFind(node * 2, start, (start + end) / 2, left, right),
                    maxFind(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }

        public long minFind(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return Long.MAX_VALUE;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            return Math.min(minFind(node * 2, start, (start + end) / 2, left, right),
                    minFind(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree maxTree = new SegmentTree(N);
        SegmentTree minTree = new SegmentTree(N);

        maxTree.maxInit(arr, 1, 1, N);
        minTree.minInit(arr, 1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(minTree.minFind(1, 1, N, a, b)).append(" ")
                    .append(maxTree.maxFind(1, 1, N, a, b)).append("\n");
        }

        System.out.println(sb);
    }

}

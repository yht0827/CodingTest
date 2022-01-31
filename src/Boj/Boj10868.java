package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10868 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static long[] arr;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        SegTree segTree = new SegTree(N);

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        segTree.init(arr, 1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(segTree.minFind(1, 1, N, a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static class SegTree {
        long[] tree;
        int treeSize;

        public SegTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        public long init(long[] arr, int node, int start, int end) {

            if (start == end) return tree[node] = arr[start];

            return tree[node] = Math.min(init(arr, node * 2, start, (start + end) / 2),
                    init(arr, node * 2 + 1, (start + end) / 2 + 1, end));
        }

        public long minFind(int node, int start, int end, int left, int right) {

            if (left > end || right < start) return Long.MAX_VALUE;

            if (left <= start && end <= right) return tree[node];

            return Math.min(minFind(node * 2, start, (start + end) / 2, left, right),
                    minFind(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }
    }
}

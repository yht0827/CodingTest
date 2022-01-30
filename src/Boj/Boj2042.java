package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2042 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static StringBuilder sb = new StringBuilder();

    static class SegmentTree {
        long[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        public long init(long[] arr, int node, int start, int end) {

            if (start == end) return tree[node] = arr[start];

            return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                    + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }

        public long sum(int node, int start, int end, int left, int right) {

            if (left > end || right < start) return 0;

            if (left <= start && end <= right) return tree[node];

            return sum(node * 2, start, (start + end) / 2, left, right)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }

        public long update(int node, int start, int end, int idx, long diff) {

            if (idx < start || idx > end) return tree[node];

            if (start == end) return tree[node] = diff;

            return tree[node] = update(node * 2, start, (start + end) / 2, idx, diff) +
                    update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segTree = new SegmentTree(N);
        segTree.init(arr, 1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                segTree.update(1, 1, N, b, c);
                arr[b] = c;
            } else {
                sb.append(segTree.sum(1, 1, N, b, (int) c)).append("\n");
            }
        }
        System.out.println(sb);
    }
}

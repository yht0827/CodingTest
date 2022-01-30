package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11505 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;
    static long[] arr;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegTree segTree = new SegTree(N);
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
                sb.append(segTree.multi(1, 1, N, b, (int) c) % MOD).append("\n");
            }
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

            if (start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] = init(arr, node * 2, start, (start + end) / 2) % MOD
                    * init(arr, node * 2 + 1, (start + end) / 2 + 1, end) % MOD;
        }

        public long multi(int node, int start, int end, int left, int right) {

            if (left > end || right < start) return 1;

            if (left <= start && end <= right) return tree[node];

            return multi(node * 2, start, (start + end) / 2, left, right) % MOD *
                    multi(node * 2 + 1, (start + end) / 2 + 1, end, left, right) % MOD;
        }

        public long update(int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) return tree[node];

            if (start == end) return tree[node] = diff;

            return tree[node] = update(node * 2, start, (start + end) / 2, idx, diff % MOD) % MOD *
                    update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff % MOD) % MOD;
        }
    }
}
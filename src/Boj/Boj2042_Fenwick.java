package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2042_Fenwick {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        FenwickTree ft = new FenwickTree(N);

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            ft.update(i, arr[i]);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                ft.update(b, c - arr[b]);
                arr[b] = c;
            } else {
                sb.append(ft.sum((int) c) - ft.sum(b - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class FenwickTree {
        long[] tree;

        public FenwickTree(int arrSize) {
            tree = new long[arrSize + 1];
        }

        public void update(int idx, long diff) {
            while (idx < tree.length) {
                tree[idx] += diff;
                idx += (idx & -idx);
            }
        }

        public long sum(int idx) {
            long result = 0L;
            while (idx > 0) {
                result += tree[idx];
                idx -= (idx & -idx);
            }
            return result;
        }
    }

}

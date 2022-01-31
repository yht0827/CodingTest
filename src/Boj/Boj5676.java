package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5676 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int temp = Integer.parseInt(st.nextToken());

                arr[i] = Integer.compare(temp, 0);
            }

            SegTree segTree = new SegTree(N);
            segTree.init(arr, 1, 1, N);

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd.equals("C")) {
                    segTree.update(1, 1, N, a, Integer.compare(b, 0));
                } else {
                    int num = segTree.multiply(1, 1, N, a, b);
                    sb.append(num == 0 ? "0" : num > 0 ? "+" : "-");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class SegTree {
        int[] tree;
        int treeSize;

        public SegTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            treeSize = (int) Math.pow(2, h + 1);
            tree = new int[treeSize];
        }

        public int init(int[] arr, int node, int start, int end) {

            if (start == end) {
                return tree[node] = arr[start];
            }
            return tree[node] = init(arr, node * 2, start, (start + end) / 2) *
                    init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }

        public int multiply(int node, int start, int end, int left, int right) {

            if (left > end || start > right) return 1;

            if (left <= start && end <= right) {
                return tree[node];
            }

            return multiply(node * 2, start, (start + end) / 2, left, right)
                    * multiply(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }

        public int update(int node, int start, int end, int idx, int diff) {

            if (idx < start || idx > end) {
                return tree[node];
            }

            if (start == end) {
                return tree[node] = diff;
            }

            return tree[node] = update(node * 2, start, (start + end) / 2, idx, diff)
                    * update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }

    }


}

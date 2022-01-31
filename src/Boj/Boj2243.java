package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2243 {
    private static final int MAX_CANDY = 1_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static SegTree segTree = new SegTree(MAX_CANDY);

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken()); // 꺼낼 사탕 순위
            if (A == 1) {
                long candy = segTree.binarySearch(1, 1, MAX_CANDY, B);
                sb.append(candy).append("\n");
            } else {
                int C = Integer.parseInt(st.nextToken());
                segTree.update(1, 1, MAX_CANDY, B, C);
            }
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

        public void update(int node, int start, int end, int idx, long diff) {

            if (idx < start || end < idx) return;

            tree[node] += diff;

            if (start != end) {
                update(node * 2, start, (start + end) / 2, idx, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
            }
        }

        public long binarySearch(int node, int start, int end, int idx) {
            if (start == end) {
                update(1, 1, MAX_CANDY, start, -1);
                return start;
            }

            // 이진 트리 좌 우
            if (tree[node * 2] >= idx) {
                return binarySearch(node * 2, start, (start + end) / 2, idx);
            } else {
                return binarySearch(node * 2 + 1, (start + end) / 2 + 1, end, idx - tree[node * 2]);
            }
        }
    }
}

package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2660 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, INF = 987654321;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == -1 && end == -1) {
                break;
            }
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                for (int k = 1; k <= N; k++) {
                    arr[i][k] = Math.min(arr[i][k], arr[i][j] + arr[j][k]);
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        int minNum = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, arr[i][j]);
            }
            minNum = Math.min(max, minNum);
            list.add(new int[]{max, i});
        }

        sb.append(minNum).append(" ");

        int cnt = 0;
        StringBuilder subSb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == minNum) {
                cnt++;
                subSb.append(i + 1).append(" ");
            }
        }

        sb.append(cnt).append("\n");
        sb.append(subSb);

        System.out.println(sb);

    }

}

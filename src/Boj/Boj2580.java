package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2580 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[9][9];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<int[]> list = new ArrayList<>();
    static boolean check;

    public static void main(String args[]) throws Exception {
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    list.add(new int[]{i, j});
            }
        }

        dfs(0);

    }

    public static void dfs(int index) {

        if (check)
            return;

        if (index == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
            check = true;
            return;
        }

        int x = list.get(index)[0];
        int y = list.get(index)[1];

        for (int i = 1; i <= 9; i++) {
            if (checkNum(x, y, i)) {
                map[x][y] = i;
                dfs(index + 1);
                map[x][y] = 0;
            }
        }
    }

    public static boolean checkNum(int x, int y, int num) {

        for (int i = 0; i < 9; i++) {
            if (num == map[x][i] || num == map[i][y])
                return false;
        }

        int dx = (x / 3) * 3;
        int dy = (y / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i + dx][j + dy] == num)
                    return false;
            }
        }

        return true;
    }

}

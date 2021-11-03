package Programmers;

public class 피로도 {

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons));
    }

    static int answer = 0;

    private static int solution(int k, int[][] dungeons) {
        int dSize = dungeons.length;

        boolean[] check = new boolean[dSize];
        dfs(0, dSize, k, check, dungeons);

        return answer;
    }

    private static void dfs(int cnt, int dSize, int k, boolean[] check, int[][] dungeons) {

        for (int j = 0; j < dSize; j++) {
            if (check[j]) continue;
            if (k < dungeons[j][0]) continue;

            check[j] = true;
            dfs(cnt + 1, dSize, k - dungeons[j][1], check, dungeons);
            check[j] = false;
        }

        answer = Math.max(answer, cnt);
    }
}

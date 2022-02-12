package Programmers;

import java.util.Arrays;

public class 양궁대회 {

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(n, info)));
    }

    static int[] answer = new int[11];
    static int maxScore = Integer.MIN_VALUE;

    public static int[] solution(int n, int[] info) {
        int[] score = new int[11];
        dfs(score, 0, n, info);

        if (Arrays.stream(answer).sum() == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    public static void dfs(int[] score, int cnt, int n, int[] info) {

        if (cnt == n) {
            int lionScore = 0, aPeachScore = 0;

            for (int i = 0; i < 11; i++) {
                // 라이언 승리
                if (info[i] < score[i]) {
                    lionScore += 10 - i;
                } else if (info[i] != 0 && info[i] >= score[i]) {
                    aPeachScore += 10 - i;
                }
            }

            if (lionScore > aPeachScore) {
                if (lionScore - aPeachScore >= maxScore) {
                    maxScore = lionScore - aPeachScore;
                    answer = score.clone();
                }
            }

        } else if (cnt < n) {
            for (int i = 0; i < 11 && score[i] <= info[i]; i++) {
                score[i]++;
                dfs(score, cnt + 1, n, info);
                score[i]--;
            }
        }

    }

}

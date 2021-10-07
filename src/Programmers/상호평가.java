package Programmers;

public class 상호평가 {

    public static void main(String[] args) {

        int[][] scores = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};
        System.out.println(solution(scores));
    }

    private static String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < scores.length; i++) {
            int max = -1;
            int min = 101;
            int sum = 0;
            int len = scores.length - 1;

            for (int j = 0; j < scores.length; j++) {
                if (i == j) continue;
                if (max < scores[j][i]) max = scores[j][i];
                if (min > scores[j][i]) min = scores[j][i];
                sum += scores[j][i];
            }

            if (max >= scores[i][i] && min <= scores[i][i]) {
                sum += scores[i][i];
                len++;
            }

            double score = (double) sum / len;

            answer.append(score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : score >= 50 ? "D" : "F");
        }

        return answer.toString();
    }

}

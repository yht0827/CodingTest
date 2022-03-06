package Programmers;

public class 프렌즈4블록 {

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m, n, board));
    }

    static char[][] map;

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(i, j);
            }
        }


        return answer;
    }

    public static void check(int i, int j) {
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};


    }

}

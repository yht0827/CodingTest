package Programmers;

import java.util.*;

public class 퍼즐조각채우기 {

    public static void main(String[] args) {
        int[][] game_board = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
        System.out.println(solution(game_board, table));
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    static boolean[][] visited; // 방문 체크
    static List<List<Point>> board = new ArrayList<>();
    static List<List<Point>> blockTable = new ArrayList<>();
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int boardSize;

    private static int solution(int[][] game_board, int[][] table) {
        boardSize = game_board.length;
        visited = new boolean[boardSize][boardSize];

        // 빈칸 저장
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) board.add(check(game_board, i, j, 0));
            }
        }

        // 방문 체크 배열 초기화
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(visited[i], false);
        }

        // 테이블에서 블록 저장
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (table[i][j] == 1 && !visited[i][j]) blockTable.add(check(table, i, j, 1));
            }
        }

        // 게임보드 중 빈 공간 방문 체크
        boolean[] visitedBoard = new boolean[board.size()];
        int answer = 0;

        for (List<Point> blockCheck : blockTable) {
            for (int j = 0; j < board.size(); j++) {
                List<Point> emptyCheck = board.get(j);

                // 빈공간과 블록의 개수가 같고, 방문한 적이 없는 곳
                if (emptyCheck.size() == blockCheck.size() && !visitedBoard[j]) {
                    // 빈 공간에 들어간 지 확인하고, 배열을 90도로 돌린다.
                    if (isRotate(emptyCheck, blockCheck)) {
                        answer += blockCheck.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    private static List<Point> check(int[][] game_board, int x, int y, int type) {
        Queue<Point> q = new LinkedList<>();
        List<Point> result = new ArrayList<>();

        q.add(new Point(x, y));
        visited[x][y] = true;

        result.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int dx = poll.x + dir[i][0];
                int dy = poll.y + dir[i][1];

                if (dx >= 0 && dy >= 0 && dx < boardSize && dy < boardSize) {
                    if (!visited[dx][dy] && game_board[dx][dy] == type) {
                        q.add(new Point(dx, dy));
                        visited[dx][dy] = true;

                        result.add(new Point(dx - x, dy - y));
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static boolean isRotate(List<Point> empty, List<Point> block) {

        for (int i = 0; i < 4; i++) {
            int zeroX = block.get(0).x;
            int zeroY = block.get(0).y;

            // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
            for (Point point : block) {
                point.x -= zeroX;
                point.y -= zeroY;
            }

            boolean isCollect = true;

            for (int j = 0; j < empty.size(); j++) {
                Point emptyPoint = empty.get(j);
                Point blockPoint = block.get(j);

                // 블록 좌표가 빈 공간의 좌표와 하나라도 다르면 중단
                if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
                    isCollect = false;
                    break;
                }
            }

            if (isCollect) {
                return true;
            } else {
                // 90도 회전 : (x, y) -> (y, -x)
                for (Point point : block) {
                    int temp = point.x;
                    point.x = point.y;
                    point.y = -temp;
                }
                Collections.sort(block);
            }
        }
        return false;
    }
}

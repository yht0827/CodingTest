package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj17837 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K; // 체스판 크기, 말의 개수
    static int result; // 턴 번호
    static int[][] dis = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // 4방향 이동
    static Board[][] boards; // 체스판 배열
    static Horse[] h; // 말 배열
    static Deque<Integer> hq; // 말 순서 큐

    /**
     * 체스 판
     * color -> 발판 색
     * list -> 체스말 위치 저장
     */
    static class Board {
        int color;
        LinkedList<Integer> list;

        public Board(int color, LinkedList<Integer> list) {
            this.color = color;
            this.list = list;
        }
    }

    /**
     * 체스 말
     * int x, y -> x,y좌표
     * int dir -> 방향
     */
    static class Horse {
        int x, y, dir;

        public Horse(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Horse{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 체스판 크기
        K = Integer.parseInt(st.nextToken()); // 말의 개수
        boards = new Board[N][N]; // 체스판 초기화
        h = new Horse[K]; // 말 초기화

        // 체스판 정보 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                boards[i][j] = new Board(Integer.parseInt(st.nextToken()), new LinkedList<>());
            }
        }

        // 말 정보 추가
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            boards[x - 1][y - 1].list.add(i);
            h[i] = new Horse(x - 1, y - 1, dir - 1);
        }

        move(); // 말 이동
        System.out.println(result); // 턴 번호 출력
    }

    private static void move() {
        int turn = 1;
        hq = new ArrayDeque<>(); // 말 순서 큐

        while (turn <= 1000) {
            for (int i = 0; i < K; i++) {

                int x = h[i].x;
                int y = h[i].y;
                int dir = h[i].dir;

                // 1. 현재 위치한 위치(x,y) 말의 총 개수 확인
                int size = boards[x][y].list.size();

                // 2. 현재 말이 몇 번째에 위치한 지 확인 (위에 있는 말이 LinkedList 뒤로 연결된다.)
                int idx = checkIndex(i, x, y, size);

                // 3. 옮길 말들 큐에 저장
                moveHorse(x, y, idx, size);

                // 4. 말을 옮기기 전에 현재 위치 체스판 정보 삭제
                boardClean(x, y, idx, size);

                // 5. 말 옮기기 + 개수 4개 이상 체크
                int dx = x + dis[dir][0];
                int dy = y + dis[dir][1];
                if (moveAndCheck(dx, dy, dir, i)) {
                    result = turn;
                    return;
                }
            }

            turn++; // 6. 턴 카운트 증가
        }
        result = -1; // 1000턴 안에 종료가 안 된 경우 -1
    }

    /**
     * 배열 범위 체크
     */
    private static boolean isRange(int dx, int dy) {
        return dx < 0 || dy < 0 || dx >= N || dy >= N || boards[dx][dy].color == 2;
    }

    /**
     * 말 이동 및 배열 갱신, 해당 위치에 말의 개수 체크
     */
    private static boolean moveAndCheck(int dx, int dy, int dir, int idx) {

        // 5-1. 범위 체크
        int color = isRange(dx, dy) ? 2 : boards[dx][dy].color;

        // 5-2. 막힌 칸 처리
        if (color == 2) {

            // 5-3. 좌표 및 방향 조절
            dir = (dir < 2) ? 1 - dir : 5 - dir;
            dx += dis[dir][0] * 2;
            dy += dis[dir][1] * 2;

            // 5-4. 벽에 갇혀 이동 할 수 없는 경우 확인
            color = isRange(dx, dy) ? 2 : boards[dx][dy].color;

            // 5-5. 벽에 갇힌 경우 원래대로 원상 복구
            if (color == 2) {
                dx -= dis[dir][0];
                dy -= dis[dir][1];
                addHorse(dx, dy, 0); // 이동한 말 추가
            } else {
                addHorse(dx, dy, color);
            }
        } else {
            addHorse(dx, dy, color);
        }

        // 5-7. 이동한 말(Horse 배열) 방향 및 좌표 정보 갱신
        int size = boards[dx][dy].list.size();
        for (int i = 0; i < size; i++) {
            int index = boards[dx][dy].list.get(i);
            Horse horse = h[index];
            if (index == idx) {
                h[index] = new Horse(dx, dy, dir);
            } else {
                h[index] = new Horse(dx, dy, horse.dir);
            }
        }

        // 5-8. 판에 말의 개수가 4개 이상 인경우 True/False
        return boards[dx][dy].list.size() >= 4;
    }


    // 5-6. 보드판에 말 추가 시키기
    private static void addHorse(int dx, int dy, int color) {
        while (!hq.isEmpty()) {
            if (color == 1) { // 빨간 장판(color == 1) 인경우 뒤에서부터 추가
                boards[dx][dy].list.add(hq.pollLast());
            } else {
                boards[dx][dy].list.add(hq.pollFirst());
            }
        }
    }


    /**
     * @param x    x 좌표
     * @param y    y 좌표
     * @param idx  옮길 말의 인덱스
     * @param size 리스트 사이즈
     */
    private static void boardClean(int x, int y, int idx, int size) {
        for (int i = idx; i < size; i++) {
            boards[x][y].list.remove(idx);
        }
    }

    /**
     * @param x    x좌표
     * @param y    y좌표
     * @param idx  옮길 말의 인덱스
     * @param size 리스트 크기
     */
    private static void moveHorse(int x, int y, int idx, int size) {
        for (int i = idx; i < size; i++) {
            hq.offer(boards[x][y].list.get(i));
        }
    }

    /**
     * @param index 현재 말의 index
     * @param x     x 좌표
     * @param y     y 좌표
     * @param size  말 List 크기
     * @return 인덱스 위치
     */
    private static int checkIndex(int index, int x, int y, int size) {
        for (int i = 0; i < size; i++)
            if (boards[x][y].list.get(i) == index) return i;

        return 0;
    }
}

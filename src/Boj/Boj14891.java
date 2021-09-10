package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14891 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] wheel = new int[4][8]; // 톱니바퀴 극 저장
    static int K; // 회전 수
    static int sum; // 점수
    static boolean[] flag; // 회전 했는지 체크

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 4; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(split[j]);
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            flag = new boolean[5];
            changeWheel(wheelNum, dir);
        }

        // 점수 계산
        for (int i = 0; i < 4; i++) {
            if (wheel[i][0] == 1) {
                sum += Math.pow(2, i);
            }
        }
        System.out.println(sum);
    }

    // 바퀴 회전
    public static void changeWheel(int num, int dir) {

        // 1~4번 톱니바퀴
        switch (num) {
            case 1:
                boolean checkOne = rightCheck(num);
                move(num, dir);

                if (!checkOne && !flag[2]) {
                    changeWheel(2, dir * (-1));
                }
                break;
            case 2:
            case 3:
                boolean checkLeft = leftCheck(num);
                boolean checkRight = rightCheck(num);
                move(num, dir);

                if (!checkLeft && !flag[num - 1]) {
                    changeWheel(num - 1, dir * (-1));
                }
                if (!checkRight && !flag[num + 1]) {
                    changeWheel(num + 1, dir * (-1));
                }
                break;
            case 4:
                boolean checkFour = leftCheck(num);
                move(num, dir);

                if (!checkFour && !flag[3]) {
                    changeWheel(3, dir * (-1));
                }
        }

    }

    // 시계방향, 반시계방향 움직이기
    public static void move(int num, int dir) {
        if (dir == 1) {
            int temp = wheel[num - 1][7];
            for (int i = 7; i > 0; i--) {
                wheel[num - 1][i] = wheel[num - 1][i - 1];
            }
            wheel[num - 1][0] = temp;
        } else {
            int temp = wheel[num - 1][0];
            for (int i = 0; i <= 6; i++) {
                wheel[num - 1][i] = wheel[num - 1][i + 1];
            }
            wheel[num - 1][7] = temp;
        }
        flag[num] = true;
    }

    // 오른쪽 톱니바퀴 체크
    public static boolean leftCheck(int num) {
        return wheel[num - 2][2] == wheel[num - 1][6];
    }

    // 왼쪽 톱니바퀴 체크
    public static boolean rightCheck(int num) {
        return wheel[num - 1][2] == wheel[num][6];
    }
}

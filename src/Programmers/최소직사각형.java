package Programmers;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int len = sizes.length;
        int garo = 0, sero = 0;

        // 0번에 최대 값 1번에 최소 값 저장
        for (int i = 0; i < len; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            sizes[i][0] = max;
            sizes[i][1] = min;
        }

        for (int[] size : sizes) {
            if (garo < size[0])
                garo = size[0];

            if (sero < size[1])
                sero = size[1];
        }


        return garo * sero;
    }

}

package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj19236 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static int result = 0;

    static class Shark {
        int x, y, dir, eatSum;

        public Shark(int x, int y, int dir, int eatSum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eatSum = eatSum;
        }
    }

    static class Fish implements Comparable<Fish> {

        int x;
        int y;
        int id;
        int dir;
        boolean live;

        public Fish(int x, int y, int id, int dir, boolean live) {
            this.x = x;
            this.y = y;
            this.id = id;
            this.dir = dir;
            this.live = live;
        }

        @Override
        public int compareTo(Fish o) {
            return this.id - o.id;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "x=" + x +
                    ", y=" + y +
                    ", id=" + id +
                    ", dir=" + dir +
                    ", live=" + live +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {

        List<Fish> list = new ArrayList<>();
        int[][] map = new int[4][4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int size = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                list.add(new Fish(i, j, size, dir - 1, true));
                map[i][j] = size;
            }
        }

        Collections.sort(list);

        // 0,0에서 시작
        Fish fish = list.get(map[0][0] - 1);
        Shark shark = new Shark(0, 0, fish.dir, fish.id);
        map[0][0] = -1;
        fish.live = false;

        dfs(list, map, shark);
        System.out.println(result);

    }

    private static void dfs(List<Fish> list, int[][] map, Shark shark) {

        if (result < shark.eatSum) result = shark.eatSum;

        moveFish(list, map);

        for (int i = 1; i < 4; i++) {
            int dx = shark.x + dir[shark.dir][0] * i;
            int dy = shark.y + dir[shark.dir][1] * i;

            if (dx >= 0 && dy >= 0 && dx < 4 && dy < 4 && map[dx][dy] > 0) {

                int[][] newMap = copyMap(map);
                List<Fish> newList = copyFish(list);

                newMap[shark.x][shark.y] = 0;
                Fish f = newList.get(map[dx][dy] - 1);
                Shark s = new Shark(f.x, f.y, f.dir, shark.eatSum + f.id);
                f.live = false;
                newMap[dx][dy] = -1;

                dfs(newList, newMap, s);
            }
        }
    }

    private static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[4][4];

        for (int i = 0; i < 4; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, 4);
        }

        return newMap;
    }

    private static List<Fish> copyFish(List<Fish> list) {
        List<Fish> temp = new ArrayList<>();
        list.forEach(fish -> temp.add(new Fish(fish.x, fish.y, fish.id, fish.dir, fish.live)));

        return temp;
    }

    private static void moveFish(List<Fish> list, int[][] map) {
        for (Fish fish : list) {
            if (!fish.live) continue;

            for (int i = 0; i < 8; i++) {
                int nextDir = (fish.dir + i) % 8;
                int dx = fish.x + dir[nextDir][0];
                int dy = fish.y + dir[nextDir][1];

                if (dx >= 0 && dy >= 0 && dx < 4 && dy < 4 && map[dx][dy] != -1) {
                    map[fish.x][fish.y] = 0;

                    if (map[dx][dy] != 0) {
                        Fish temp = list.get(map[dx][dy] - 1);

                        temp.x = fish.x;
                        temp.y = fish.y;
                        map[fish.x][fish.y] = temp.id;
                    }
                    fish.x = dx;
                    fish.y = dy;

                    map[dx][dy] = fish.id;
                    fish.dir = nextDir;
                    break;
                }
            }
        }
    }

}

package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1516 {

    static class Building {
        int idx;
        int time;
        int cnt = 0;
        List<Integer> child = new ArrayList<>();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer st;
    static List<Building> list = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new Building());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list.get(i).idx = i;
            result[i] = list.get(i).time = Integer.parseInt(st.nextToken());

            while (true) {
                int j = Integer.parseInt(st.nextToken());
                if (j == -1) break;

                list.get(j).child.add(i);
                list.get(i).cnt++;
            }
        }

        Queue<Building> q = new ArrayDeque<>();

        for (Building value : list) {
            if (value.cnt == 0) {
                q.offer(value);
            }
        }

        while (!q.isEmpty()) {
            Building poll = q.poll();

            for (int i = 0; i < poll.child.size(); i++) {
                Building building = list.get(poll.child.get(i));
                result[poll.child.get(i)] = Math.max(result[poll.child.get(i)], building.time + result[poll.idx]);

                if (--building.cnt == 0) {
                    q.offer(building);
                }

            }
        }

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}

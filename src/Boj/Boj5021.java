package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5021 {

    /**
     * 후계자 정보 이름, 부모 카운트, 혈통 숫자, 자식 정보
     */
    static class Info {
        String name;
        int cnt = 0;
        double blood = 0;
        List<Info> child = new ArrayList<>();

        public Info(String name) {
            this.name = name;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<String> candidate = new ArrayList<>(); //
    static Map<String, Info> childMap = new HashMap<>(); // 후계자 저장하는 맵 (K:V -> 이름, Info클래스)
    static String nearest = ""; // 가장 가까운 후계자 이름
    static double maxBlood = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Info utopia = new Info(br.readLine());
        utopia.blood = 1; // 유토피아 왕의 혈통 기본 값
        childMap.put(utopia.name, utopia);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] family = new String[3];

            for (int j = 0; j < family.length; j++) {
                family[j] = st.nextToken();
                if (!childMap.containsKey(family[j])) {
                    childMap.put(family[j], new Info(family[j]));
                }
            }

            Info info = childMap.get(family[0]);
            info.cnt = 2;
            childMap.get(family[1]).child.add(info);
            childMap.get(family[2]).child.add(info);
        }

        // 후보자
        for (int i = 0; i < M; i++)
            candidate.add(br.readLine());


        // 진입차수가 0인 최상위 Info 큐에 담는다.
        Queue<Info> q = new ArrayDeque<>();
        for (String s : childMap.keySet()) {
            if (childMap.get(s).cnt == 0) {
                q.offer(childMap.get(s));
            }
        }

        while (!q.isEmpty()) {
            Info poll = q.poll();

            for (Info info : poll.child) {
                info.cnt--;

                info.blood += poll.blood / 2; // 부모 혈통 더해줌

                // 진입 차수가 0이면 큐에 담음
                if (info.cnt == 0) {
                    q.offer(info);
                }
            }
        }

        for (String s : candidate) {
            if (childMap.containsKey(s) && maxBlood < childMap.get(s).blood) {
                Info info = childMap.get(s);
                maxBlood = info.blood;
                nearest = info.name;
            }
        }

        System.out.println(nearest);
    }

}

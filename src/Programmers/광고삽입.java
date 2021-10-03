package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 광고삽입 {

    public static void main(String[] args) {

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(solution1(play_time, adv_time, logs));
    }

    private static int s2i(String str) {
        return Integer.parseInt(str.substring(0, 2)) * 3600 +
                Integer.parseInt(str.substring(3, 5)) * 60 +
                Integer.parseInt(str.substring(6, 8));
    }

    private static String zeroPut(int time) {
        if (time < 10) {
            return "0" + time;
        }
        return String.valueOf(time);
    }

    private static String i2s(int time) {
        StringBuilder sb = new StringBuilder();

        sb.append(zeroPut(time / 3600)).append(":");
        time %= 3600;

        sb.append(zeroPut(time / 60)).append(":");
        time %= 60;

        sb.append(zeroPut(time));

        return sb.toString();
    }

    /* prefix Sum */
    public static String solution(String play_time, String adv_time, String[] logs) {
        int endTime = s2i(play_time);
        int adTime = s2i(adv_time);
        int index = 0;
        int[] sum = new int[endTime + 1];

        for (String log : logs) {
            String[] split = log.split("-");
            int start = s2i(split[0]), end = s2i(split[1]);
            sum[start]++;
            sum[end]--;
        }

        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }

        long ad = 0;

        for (int i = 0; i < adTime; i++) {
            ad = sum[i];
        }

        long max = ad;

        for (int i = 1; i <= sum.length - adTime; i++) {
            ad = ad - sum[i - 1] + sum[adTime + i - 1];
            if (ad > max) {
                max = ad;
                index = i;
            }
        }

        return i2s(index);
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return x == o.x ? Integer.compare(y, o.y) : Integer.compare(x, o.x);
        }
    }

    /* two pointer */
    private static String solution1(String play_time, String adv_time, String[] logs) {
        int endTime = s2i(play_time);
        int adTime = s2i(adv_time);
        List<Pair> list = new ArrayList<>();

        for (String log : logs) {
            String[] split = log.split("-");
            int start = s2i(split[0]), end = s2i(split[1]);
            list.add(new Pair(start, 1));
            list.add(new Pair(end, -1));
        }

        list.add(new Pair(0, 0)); // { 0, 0 }도 넣어준다. 동영상 시작 시간인 0 초도 광고가 재생될 수 있는 시간이므로 이벤트나 마찬가지.
        Collections.sort(list); // 정렬때문에 O(nlogn)

        int startIndex = 0, endIndex = 0; // 투포인터 시작 위치, 마지막 위치
        int startViews = 0, endViews = 0; // 새로운 구간에서 빠지는 시청자 수, 새로운 구간에 포함되는 시청자 수
        long sumViews = 0, maxViews = 0; // 현재 광고 구간의 누적 시청자수, 현재까지 구한 광고 구간의 누적 시청자수 최대값
        int advStartTime = 0, answerTime = 0; // 광고 시작 시간(매번 이벤트 시간이 대입될 것이다.), 현재까지 구한 광고 구간의 누적 시청자수 최대값이 나온 그 광고 시작 시간

        // 1. 0초에서 광고가 시작될 때의 광고 시간 동안의 누적 시청자 수 구하기 (0초 이벤트)
        // 먼저 광고 시간 전에 등장하는 이벤트들마다 시청자 수를 합산
        while (endIndex + 1 < list.size() && list.get(endIndex + 1).x <= adTime) {
            sumViews += (long) (list.get(endIndex + 1).x - list.get(endIndex).x) * endViews; // 시간 간격 * 시청자 수
            endViews += list.get(endIndex + 1).y; // 시청자 수 증가
            endIndex++;
        }

        // 광고시간과 마지막 이벤트 사이에서 발생한 시청자 수도 합산해준다.
        sumViews += (long) (adTime - list.get(endIndex).x) * endViews;
        maxViews = sumViews;

        // 2. 가까운 이벤트에 걸릴 때 마다 광고 시간 동안의 누적 시청자 수 구하기 Sum = Sum - A + B
        while (advStartTime <= endTime - adTime && endIndex + 1 < list.size()) {
            int delta1 = list.get(startIndex + 1).x - advStartTime; // 광고 시작 시간 이벤트 간격
            int delta2 = list.get(endIndex + 1).x - (advStartTime + adTime); // 광고 끝 시간 이벤트 간격
            if (delta1 <= delta2) { // 시작 구간이 다음 event에 더 가까운 경우
                sumViews += (long) (endViews - startViews) * delta1; // 시청자 수 * 시간 간격
                startViews += list.get(startIndex + 1).y;
                startIndex++;
                advStartTime += delta1;
            } else {
                sumViews += (long) (endViews - startViews) * delta2; // 시청자 수 * 시간 간격
                endViews += list.get(endIndex + 1).y;
                endIndex++;
                advStartTime += delta2;
            }
            if (sumViews > maxViews) {
                maxViews = sumViews;
                answerTime = advStartTime;
            }
        }

        return i2s(answerTime);
    }

}

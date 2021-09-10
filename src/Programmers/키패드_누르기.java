package Programmers;

public class 키패드_누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10, right = 12;

        for (int number : numbers) {
            if (number == 0) number = 11;

            if (number % 3 == 1) {
                sb.append("L");
                left = number;
            } else if (number % 3 == 0) {
                right = number;
                sb.append("R");
            } else {

                int rDis = changeDis(right, number);
                int lDis = changeDis(left, number);

                if (rDis < lDis) {
                    sb.append("R");
                    right = number;
                } else if (rDis > lDis) {
                    sb.append("L");
                    left = number;
                } else {
                    sb.append(hand.equals("right") ? "R" : "L");
                    if (hand.equals("right")) right = number;
                    else left = number;
                }
            }
        }
        return sb.toString();
    }

    public static int changeDis(int dis, int num) {

        if (dis == 1 || dis == 4 || dis == 7 || dis == 10) {
            dis++;
            int num1 = Math.abs(dis - num);
            return (num1 / 3) + 1;
        } else if (dis == 3 || dis == 6 || dis == 9 || dis == 12) {
            dis--;
            int num1 = Math.abs(dis - num);
            return (num1 / 3) + 1;
        } else {
            int num1 = Math.abs(dis - num);
            return (num1 / 3);
        }
    }

}

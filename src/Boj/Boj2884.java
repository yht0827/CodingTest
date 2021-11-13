package Boj;

import java.util.Scanner;

public class Boj2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int H = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        if (M < 45) {
            H--;
            M += 60;
        }

        M -= 45;

        if (H < 0) H = 23;

        System.out.println(H + " " + M);
    }

}

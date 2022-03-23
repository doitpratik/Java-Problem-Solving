package com.company.lecture29;

import java.util.Scanner;

public class DiceProb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] faces = {1, 2, 3, 4, 5, 6};
        int face = 6;
        int target = sc.nextInt();
        System.out.println(getCountDice(face, target));
    }

    private static int getCountDice(int faces, int target) {
        if(target == 0){
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= Math.min(target,faces); i++) {
            count += getCountDice(faces, target - i);
        }
        return count;
    }
}

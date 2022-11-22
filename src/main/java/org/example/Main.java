package org.example;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner input = new Scanner(System.in);
        int val = -1;

        do {
            val = Integer.parseInt(input.nextLine());
            int primaryNums = s.countPrimes(val);
            System.out.println(primaryNums);
        } while (val != -1);


    }
}

class Solution {
    public int countPrimes(long n) {
        if (n <= 1) return 0;
        else if (n == 2) return 0;

        boolean[] array = new boolean[(int) n + 1];

        Arrays.fill(array, true);

        for (int i = 2; i < n; i++) {

            if (!array[i])
                continue;

            for (int j = i; ((long) j * (long) i) < n; j++) {
                array[j * i] = false;
            }
        }

        int primary = 0;
        for (int i = 2; i < n; i++) {
            if (array[i]) {
                primary++;
            }
        }

        return primary;
    }
}
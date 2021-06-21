package com.shradha.max;

public class MaxFinder {

    public static Integer findMax(Integer int1, Integer int2, Integer int3) {
        Integer max = int1;
        if(int2.compareTo(max) > 0)
            max = int2;
        if(int3.compareTo(max) > 0)
            max = int3;
        System.out.printf("Max value of %s %s %s is %s. \n", int1, int2, int3, max);

        return max;
    }

    public static void main(String[] args) {
        Integer int1 = 78, int2 = 74, int3 = 8;
        findMax(int1, int2, int3);
    }

}

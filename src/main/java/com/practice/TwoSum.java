package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] returnIndicesBruteForce(int[] nums, int target) {

        int[] returnArray = new int[2];
        long startTime = System.currentTimeMillis();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    System.out.println("Match Found!!!");
                    returnArray[0] = i;
                    returnArray[1] = j;
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Program executed in : " + (endTime-startTime) + " ms");
        return returnArray;
    }

    //this assumes the value inside the arrays are not repeated ever
    public int[] returnIndicesEfficient(int[] nums, int target) {

        int[] returnArray = new int[2];
        Map<Integer, Integer> seenMap = new HashMap<>();
        long startTime = System.currentTimeMillis();
        for (int i=0; i<nums.length; i++) {
            if(seenMap.containsKey(target - nums[i])) {
                System.out.println("Match Found!!!");
                returnArray[0] = seenMap.get(target - nums[i]);
                returnArray[1] = i;
                break;
            } else {
                seenMap.put(nums[i], i);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Program executed in : " + (endTime-startTime) + " ms");
        return returnArray;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println("BruteFore: The indices are :: "+ Arrays.toString(twoSum.returnIndicesBruteForce(nums, target)));
        System.out.println("Time efficient: The indices are :: "+ Arrays.toString(twoSum.returnIndicesEfficient(nums, target)));
    }
}

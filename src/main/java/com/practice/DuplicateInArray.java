package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DuplicateInArray {

    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]==nums[j]) return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateInArray duplicateInArray = new DuplicateInArray();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(" The given array contains Duplicate :: "
                + duplicateInArray.containsDuplicate(nums));
    }
}

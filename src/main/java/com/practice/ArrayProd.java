package com.practice;

import java.util.Arrays;

public class ArrayProd {

    public int[] productExceptSelf(int[] nums) {

        int[] prodArray = new int[nums.length];
        int product = 1;
        prodArray[0] = nums[0];
        for(int i=1; i< nums.length; i++) {
            prodArray[i] = prodArray[i-1] * nums[i];
        }

        for(int i = prodArray.length-1; i >= 0; i--) {
            if(i==0) {
                prodArray[i] = product;
            } else {
                prodArray[i] = prodArray[i-1] * product;
                product = product * nums[i];
            }
        }
        return prodArray;
    }

    public static void main(String[] args) {
        ArrayProd arrayProd = new ArrayProd();
        int nums[] = {1,2,3,4};
        System.out.println(Arrays.toString(Arrays.stream(arrayProd.productExceptSelf(nums)).toArray()));
    }
}
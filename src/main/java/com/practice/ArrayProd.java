package com.practice;

public class ArrayProd {

    public int[] productExceptSelf(int[] nums) {

        int[] prodArray = new int[nums.length];
        int product = 1;
        for(int i=0; i< nums.length; i++) {
            product = product * nums[i];
        }

        return prodArray;
    }

    public static void main(String[] args) {
        ArrayProd arrayProd = new ArrayProd();
        int nums[] = {1,2,3,4};
        arrayProd.productExceptSelf(nums);
    }
}
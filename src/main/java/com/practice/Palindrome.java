package com.practice;

public class Palindrome {
    public boolean isPalindromeConveringString(int x) {
        String digitString = String.valueOf(x);
        StringBuilder sb = new StringBuilder(digitString).reverse();
        String reverseString = sb.toString();
        return reverseString.equals(digitString);
    }

    public boolean isPalindrome(int x) {

        if(x<0) {
            return false;
        }
        int reverse = 0, n=x, y;

        while(n!=0) {
            y=n%10;
            n=n/10;
            reverse = reverse * 10 + y;

        }
        return reverse == x;
    }

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
        int x = 129921;
        System.out.println("The input is Palindrome :: " +palindrome.isPalindromeConveringString(x));
        System.out.println("The input without String is Palindrome :: " +palindrome.isPalindrome(x));

    }
}

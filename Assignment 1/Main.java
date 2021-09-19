package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static int[] sortedSquareArray(int[]nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] squareArray = new int[nums.length];

        while(left <= right){
            int i = nums[left] * nums[left];
            int j = nums[right] * nums[right];
            if (i >= j){
                squareArray[index] = i;
                left++;
            }else {
                squareArray[index] = j;
                right--;
            }
            index--;
        }
        return squareArray;
    }
}

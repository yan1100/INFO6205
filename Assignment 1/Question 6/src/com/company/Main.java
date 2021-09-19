package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] % 2 == 0){
                left++;
            }else if (nums[right] % 2 != 0){
                right--;
            }else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {

    }

    public static void sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right){
            if (nums[index] == 0){
                swap(nums,index,left);
                left++;
                index++;
            }else if (nums[index] == 1){
                index++;
            }else {
                swap(nums,index,right);
                right--;
            }
        }
    }

    public static void swap (int[] list, int index1, int index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
}

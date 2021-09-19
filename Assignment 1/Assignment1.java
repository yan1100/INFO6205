package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Assignment1 {

    public class Question1 {

        public void sortArray(int[] nums) {
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

        public void swap (int[] list, int index1, int index2){
            int temp = list[index1];
            list[index1] = list[index2];
            list[index2] = temp;
        }

    }

    public class Question2 {

        public class Interval {
            int start;
            int end;

            public Interval() {
                this(0,0);
            }

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        public boolean canAttendMeetings(Interval[] intervals) {
            Comparator<Interval> comparator = new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            };

            Arrays.sort(intervals,comparator);

            for(int i = 0; i < intervals.length - 1; i++){
                if (intervals[i].end > intervals[i + 1].start){
                    return false;
                }
            }
            return true;
        }

    }

    public class Question3 {

        public int sumMaximize(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length - 1; i += 2){
                sum += nums[i];
            }
            return sum;
        }

    }

    public class Question4 {

        public int[] sortedSquareArray(int[]nums) {
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

    public class Question5 {
        public boolean isAnagram(String s, String t){
            if (s.length()!=t.length()){
                return false;
            }
            int[] letterCount = new int[26];
            for (int i = 0; i < s.length(); i++){
                letterCount[s.charAt(i)-'a']++;
                letterCount[t.charAt(i)-'a']--;
            }
            for (int i : letterCount ){
                if (i != 0){
                    return false;
                }
            }
            return true;
        }

    }

    public class Question6 {
        public int[] sortArray(int[] nums) {
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
}

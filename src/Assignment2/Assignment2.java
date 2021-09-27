package Assignment2;

import java.sql.Time;
import java.util.*;


public class Assignment2 {



    public class Question1{
        //Time: O(n)
        //Space:O(1)
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                int complement = target - nums[i];
                if (temp.containsKey(complement)){
                    return new int[] {temp.get(complement),i};
                }
                temp.put(nums[i],i);
            }
            return null;
        }
    }



    public class Question2{
        //Time: O(n log n)
        //Space:O(n)
        public int minMeetingRooms(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            int[] start = new int[intervals.length];
            int[] end = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++){
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }
            Arrays.sort(start);
            Arrays.sort(end);
            int startPointer = 0;
            int endPointer = 0;
            int room = 0;
            while (startPointer < intervals.length){
                if (start[startPointer] >= end[endPointer]){
                    room--;
                    endPointer++;
                }
                room++;
                startPointer++;
            }
            return room;
        }
    }



    public class Question3{
        //Time: O(n log n)
        //Space:O(n)
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums2);
            Set<Integer> temp = new HashSet<>();
            for (int number : nums1){
                if (binarySearch(nums2, number)){
                    temp.add(number);
                }
            }
            int[] res = new int[temp.size()];
            int i = 0;
            for (Integer n : temp){
                res[i] = n;
                i++;
            }
            return res;
        }

        private boolean binarySearch(int[] nums, int number) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (number < nums[mid]){
                    right = mid - 1;
                }else if (number > nums[mid]){
                    left = mid + 1;
                }else {
                    return true;
                }
            }
            return false;
        }
    }



    public class Question4{
        //Time: O(n log n)
        //Space:O(1)
        public List<Integer> majorityElement(int[] nums) {
            Arrays.sort(nums);
            List result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                int count = findLastPosition(nums,nums[i]) - i + 1;
                if (count > nums.length / 3){
                    result.add(nums[i]);
                    i += count - 1;
                }
            }
            return result;
        }

        public int findLastPosition(int[] nums, int target){
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (mid == right || nums[mid + 1] !=target){
                        return mid;
                    }
                    left = mid + 1;
                }else if (nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }



    public class Question5{
        //Time: O(log n)
        //Space:O(1)
        public int[] searchRange(int[] nums, int target) {
            int firstIndex = findPosition(nums, target,true);
            int lastIndex = findPosition(nums, target,false);
            if (firstIndex < 0){
                return new int[]{-1, -1};
            }else {
                return new int[]{firstIndex,lastIndex};
            }
        }

        public int findPosition(int[] nums, int target, boolean isFirst){
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (isFirst){
                        if (mid == left || nums[mid - 1] !=target){
                            return mid;
                        }
                        right = mid - 1;
                    }else {
                        if (mid == right || nums[mid + 1] !=target){
                            return mid;
                        }
                        left = mid + 1;
                    }
                }else if (nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return -1;
        }

    }



    public class Question6{
        //Time: O(n log n)
        //Space:O(1)
        public int countNegatives(int[][] grid){
            int rows = grid.length;
            int cols = grid[0].length;
            int count = 0;
            for (int i = 0; i < rows; i++){
                if (grid[i][0] < 0){
                    count += cols;
                }else if (grid[i][cols - 1] < 0) {
                    int left = 0;
                    int right = cols - 1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (grid[i][mid] < 0) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                    count += cols - left;
                }

            }
            return count;
        }

    }



    public class Question7{
        //Time: O(n log n)
        //Space:O(1)
        public int findPeakElement(int[] nums){
            int left = 0;
            int right = nums.length - 1;
            while (left < right){
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1]){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            return left;
        }

    }



    public class Question8 {
        //Time: O(n log n)
        //Space:O(1)
        public int findDuplicate(int[] nums){
            int low = 0;
            int high = nums.length - 1;
            int duplicate = 0;
            while (low <= high){
                int mid = low + (high - low) / 2;
                int count = 0;

                for (int n : nums) {
                    if (n <= mid){
                        count++;
                    }
                }

                if (count > mid) {
                    duplicate = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return duplicate;
        }
    }



    public class Question9 {
        //Time: O(log n)
        //Space: O(1)
        public int findKthPositive(int[] arr, int k) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] - (mid + 1) < k) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }

            }
            return left + k;
        }
    }
}

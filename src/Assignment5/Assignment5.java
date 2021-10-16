package Assignment5;

import java.util.*;

public class Assignment5 {

    public class Question1 {
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        public int myAtoi(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            int sign = 1;
            int index = 0;
            int sum = 0;
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
            if (index < s.length()){
                if (s.charAt(index) == '+'){
                    index++;
                }else if (s.charAt(index) == '-'){
                    sign = -1;
                    index++;
                }
            }
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                if (sum > Integer.MAX_VALUE / 10 ||
                        (sum == Integer.MAX_VALUE / 10 && s.charAt(index) - '0' > 7) ) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
                sum = sum * 10 + (s.charAt(index) - '0');
                index++;
            }
            return sign * sum;
        }

    }



    public class Question2 {
        //Time Complexity: O(1)
        //Space Complexity: O(1)
        public String reformatDate(String date) {
            StringBuilder res = new StringBuilder();
            Map<String,String> monthMap= new HashMap<>();
            monthMap.put("Jan","01");
            monthMap.put("Feb","02");
            monthMap.put("Mar","03");
            monthMap.put("Apr","04");
            monthMap.put("May","05");
            monthMap.put("Jun","06");
            monthMap.put("Jul","07");
            monthMap.put("Aug","08");
            monthMap.put("Sep","09");
            monthMap.put("Oct","10");
            monthMap.put("Nov","11");
            monthMap.put("Dec","12");
            String year = date.substring(date.length() - 4);
            String month = date.substring(date.length() - 8, date.length() - 5);
            res.append(year + "-" + monthMap.get(month) + "-");
            if (!Character.isDigit(date.charAt(1))) {
                res.append("0" + date.charAt(0));
            }else {
                res.append("" + date.charAt(0) + date.charAt(1));
            }
            return res.toString();
        }
    }



    public class Question3 {
        //Time Complexity: O(n)
        //Space Complexity: O(n)
        public boolean isValid(String s) {
            Map<Character,Character> map = new HashMap();
            map.put('(',')');
            map.put('{','}');
            map.put('[',']');
            Stack stack = new Stack();
            for (int i = 0; i < s.length(); i++){
                if (map.containsKey(s.charAt(i))) {
                    stack.push(s.charAt(i));
                }else {
                    if (stack.isEmpty()){
                        return false;
                    }else if (s.charAt(i) != map.get(stack.pop())){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }


    public class Question4 {
        //Time Complexity: O(n^2)
        //Space Complexity: O(n)
        public String countAndSay(int n) {
            StringBuilder res = new StringBuilder();
            res.append("1");
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < n; i++) {
                char prev = res.charAt(0);
                int count = 1;
                for (int j = 1; j < res.length(); j++) {
                    char curr = res.charAt(j);
                    if (curr == prev) {
                        count++;
                    }else {
                        temp.append(count);
                        temp.append(prev);
                        prev = curr;
                        count = 1;
                    }
                }
                temp.append(count);
                temp.append(prev);
                res = temp;
                temp = new StringBuilder();
            }
            return res.toString();
        }

    }



    public class Question5 {
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice){
                    minPrice = prices[i];
                }
                int curProfit = prices[i] - minPrice;
                if (curProfit > maxProfit) {
                    maxProfit = curProfit;
                }
            }
            return maxProfit;
        }
    }



    public class Question6 {
        //Time Complexity: O(n)
        //Space Complexity: O(1)
        public int pivotIndex(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int leftSum = 0;
            int rightSum = sum - nums[0];
            if (rightSum == 0){
                return 0;
            }
            for (int j = 1; j < nums.length; j++){
                rightSum -= nums[j];
                leftSum += nums[j - 1];
                if (leftSum == rightSum){
                    return j;
                }
            }
            return -1;
        }

    }


    public class Question7 {
        //Time Complexity: O(nlogn)
        //Space Complexity: O(n)
        public int[][] highFive(int[][] items) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int[] i : items) {
                int id = i[0];
                int score = i[1];
                if (!map.containsKey(id)){
                    map.put(id,new PriorityQueue<Integer>(5));
                }
                map.get(id).offer(score);
                if (map.get(id).size() > 5) {
                    map.get(id).poll();
                }
            }
            int index = 0;
            int[][] res = new int[map.size()][2];
            for (int id: map.keySet()) {
                int sum = 0;
                while (!map.get(id).isEmpty()) {
                    sum += map.get(id).poll();
                }
                res[index][0] = id;
                res[index][1] = sum / 5;
                index++;
            }
            return res;
        }

    }



    public class Question8 {
        //Time Complexity: O(logn)
        //Space Complexity: O(1)
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                }else if (nums[start] <= nums[mid]) {
                    if (nums[start] <= target && nums[mid] > target) {
                        end = mid - 1;
                    }else {
                        start = mid + 1;
                    }
                }else {
                    if (nums[end] >= target && nums[mid] < target) {
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }

    }
}

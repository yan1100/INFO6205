package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public static boolean canAttendMeetings(Interval[] intervals) {
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

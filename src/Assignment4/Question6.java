package Assignment4;

import java.util.ArrayList;

public class Question6 {
    class FrontMiddleBackQueue {
        ArrayList<Integer> queue;
        int front;
        int middle;
        int back;
        int size;

        public FrontMiddleBackQueue() {
            queue = new ArrayList<Integer>();
            size = 0;
        }

        public void pushFront(int val) {
            queue.add(0,val);
            size++;
        }

        public void pushMiddle(int val) {
            queue.add(size/2,val);
            size++;
        }

        public void pushBack(int val) {
            queue.add(size, val);
            size++;
        }

        public int popFront() {
            if (!queue.isEmpty()){
                int front = queue.get(0);
                queue.remove(0);
                size--;
                return front;
            }else{
                return -1;
            }
        }

        public int popMiddle() {
            if (!queue.isEmpty()){
                int middle = queue.get((size - 1) / 2);
                queue.remove((size - 1) /2);
                size--;
                return middle;
            }else{
                return -1;
        }

        }

        public int popBack() {
            if (!queue.isEmpty()){
                int back = queue.get(size - 1);
                queue.remove(size - 1);
                size--;
                return back;
            }else {
                return -1;
            }

        }
    }
}

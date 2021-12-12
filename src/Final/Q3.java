package Final;

public class Q3 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumpToEnd(arr));
        int[] arr2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minJumpToEnd(arr2));
        int[] arr3 = {1, 0, 0, 0, 0};
        System.out.println(minJumpToEnd(arr3));
        int[] arr4 = {2, -1, 4, 5, 6};
        System.out.println(minJumpToEnd(arr4));
    }

    public static int minJumpToEnd(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i ++) {
            count++;
            int num = arr[i];
            int max = 0;
            int index = 0;
            for (int j = 1; j <= num; j++) {
                if (arr[i + j] + (i+j) > max) {
                    max = arr[i + j];
                    index = i + j;
                }
            }
            if (max <= 0){
                return -1;
            }
            if (i + max >= arr.length - 2) {
                break;
            }
            i = index - 1;
        }
        return count + 1;
    }

}

package Final;

public class Q4 {
    public static void main(String[] args) {
        String[] words1 = {"hello","leetcode"};
        String order1 =  "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienLanguage(words1,order1));

        String[] words2 = {"word","world","row"};
        String order2 =  "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienLanguage(words2,order2));

        String[] words3 = {"apple","app"};
        String order3 =  "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienLanguage(words3,order3));

    }

    public static boolean isAlienLanguage(String[] words, String order) {
        int[] map = new int[26];

        for (int i = 0; i < order.length(); i++){
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], map) > 0) {
                return false;
            }
        }

        return true;
    }

    static int compare(String s1, String s2, int[] map) {
        int n = s1.length();
        int m = s2.length();

        for(int i = 0, j = 0; i < n && j < m; i++, j++) {
            int pos1 = map[ s1.charAt(i) - 'a' ];
            int pos2 = map[ s2.charAt(j) - 'a' ];

            if (pos1 != pos2) {
                return pos1 - pos2;
            }
        }

        return n - m;
    }
}

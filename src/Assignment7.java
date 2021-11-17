import java.util.*;

public class Assignment7 {
    public class Question1 {
        public boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (letterExist(board, r, c, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean letterExist(char[][] board, int r, int c, String word, int n) {
            int rows = board.length;
            int cols = board[0].length;
            if (n >= word.length()) {
                return true;
            }
            if (r < 0 || r == rows || c < 0 || c == cols || board[r][c] != word.charAt(n)) {
                return false;
            }
            board[r][c] = '-';
            int[] rOffsets = {0, 1, 0, -1};
            int[] cOffsets = {1, 0, -1, 0};
            for (int d = 0; d < 4; ++d) {
                if (letterExist(board, r + rOffsets[d], c + cOffsets[d], word, n + 1))
                    return true;
            }
            board[r][c] = word.charAt(n);
            return false;
        }
    }


    public class Question2 {
        int count = 0;
        public int countArrangement(int n) {
            boolean[] visited = new boolean[n + 1];
            backtracking(n, 1, visited);
            return count;
        }

        private void backtracking (int n, int index, boolean[] visited) {
            if (index > n) {
                count++;
            }else {
                for (int i = 1; i <= n; i++) {
                    if (!visited[i] && (i % index == 0 || index % i == 0)) {
                        visited[i] = true;
                        backtracking(n, index + 1, visited);
                        visited[i] = false;
                    }
                }
            }
        }
    }


    public class Question3 {
        public List<String> restoreIpAddresses(String s) {
            List list = new ArrayList<String>();
            addToList(list, s, "", 0);
            return list;
        }

        public void addToList(List list, String s, String output, int n) {
            if (n == 4) {
                if (s.length() == 0) {
                    output = output.substring(0, output.length() - 1);
                    list.add(output);
                }
                return;
            }
            for (int i = 0; i < 3 && i < s.length(); i++) {
                String seg = s.substring(0, i + 1);
                if (isValid(seg)) {
                    addToList(list, s.substring(i + 1), output + seg + ".", n + 1);
                }
            }
        }

        public boolean isValid(String seg) {
            if (seg.length() > 1 && seg.startsWith("0")) {
                return false;
            }
            if (Integer.valueOf(seg) > 255) {
                return false;
            }
            return true;
        }
    }


    public class Question4 {
        class TrieNode {
            String val;
            TrieNode[] child = new TrieNode[26];
            boolean isEnd = false;
        }

        public List<String> findWords(char[][] board, String[] words) {
            WordTrie trie = new WordTrie();
            TrieNode root = trie.root;
            for (String word : words){
                trie.insert(word);
            }

            List<String> res = new LinkedList<>();
            int rows = board.length;
            int cols = board[0].length;
            boolean[][] visited = new boolean[cols][rows];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    find(board, visited, r, c, rows, cols, res, root);
                }
            }
            return res;
        }

        private void find(char[][] board, boolean[][] visited, int r, int c, int rows, int cols, List<String> res, TrieNode cur) {
            if (r < 0 || r >= rows || c < 0 || c >= cols || visited[c][r])
                return;
            cur = cur.child[board[r][c] - 'a'];
            if (cur == null) {
                return;
            }
            visited[c][r] = true;
            if (cur.isEnd) {
                res.add(cur.val);
                cur.isEnd = false;
            }
            find(board, visited, r + 1, c, rows, cols, res, cur);
            find(board, visited, r - 1, c, rows, cols, res, cur);
            find(board, visited, r, c + 1, rows, cols, res, cur);
            find(board, visited, r, c - 1, rows, cols, res, cur);
            visited[c][r] = false;
        }

        class WordTrie {
            TrieNode root = new TrieNode();

            void insert(String s) {
                TrieNode cur = root;
                for (char c : s.toCharArray()) {
                    if (cur.child[c - 'a'] == null) {
                        cur.child[c - 'a'] = new TrieNode();
                        cur = cur.child[c - 'a'];
                    } else
                        cur = cur.child[c - 'a'];
                }
                cur.isEnd = true;
                cur.val = s;
            }
        }
    }



    public class Question5 {
        int maxLength = 0;
        public int maxLength(List<String> arr) {
            Set<Integer> visitedIndex = new HashSet<>();
            backtracking("",0, arr, visitedIndex);
            return maxLength;
        }

        private void backtracking(String s, int startIndex, List<String> arr, Set<Integer> visitedIndex) {
            if (isUniqueString(s)) {
                maxLength = Math.max(maxLength, s.length());
            }else {
                return;
            }
            for (int i = startIndex; i < arr.size(); i++) {
                if (!visitedIndex.contains(i) && isUniqueChar(s, arr.get(i))){
                    visitedIndex.add(i);
                    backtracking(s + arr.get(i), i + 1, arr, visitedIndex);
                    visitedIndex.remove(i);
                }
            }
        }

        private boolean isUniqueChar(String s1, String s2) {
            for (char c : s1.toCharArray()) {
                if (s2.indexOf(c) >= 0) {
                    return false;
                }
            }
            return true;
        }

        private boolean isUniqueString(String s) {
            int[] charCount = new int[256];
            for (char c : s.toCharArray()) {
                charCount[c]++;
                if (charCount[c] > 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
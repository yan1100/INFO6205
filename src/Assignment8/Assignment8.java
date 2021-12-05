package Assignment8;

import org.w3c.dom.Node;

import java.util.*;

public class Assignment8 {

    public class Question1 {
        class TrieNode {
            TrieNode[] child;
            boolean isEnd;

            public TrieNode() {
                child = new TrieNode[26];
            }
        }

        class Trie {
            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode curr = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (curr.child[c - 'a'] == null) {
                        curr.child[c - 'a'] = new TrieNode();
                    }
                    curr = curr.child[c - 'a'];
                }
                curr.isEnd = true;
            }

            public boolean search(String word) {
                TrieNode curr = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (curr.child[c - 'a'] == null) {
                        return false;
                    }
                    curr = curr.child[c - 'a'];
                }
                return curr.isEnd;
            }

            public boolean startsWith(String prefix) {
                TrieNode curr = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (curr.child[c - 'a'] == null) {
                        return false;
                    }
                    curr = curr.child[c - 'a'];
                }
                return true;
            }
        }
    }



    public class Question2 {
        public boolean validPath(int n, int[][] edges, int start, int end) {
            List<Integer>[] graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                graph[u].add(v);
                graph[v].add(u);
            }

            boolean[] visited = new boolean[n];

            if (dfs(visited, graph, start, end)) {
                return true;
            }
            return false;
        }

        public boolean dfs(boolean[] visited, List<Integer>[] graph, int start, int end) {
            if (start == end) {
                return true;
            }
            visited[start] = true;

            for (int i : graph[start]) {
                if (visited[i] == true)
                    continue;
                if (dfs(visited, graph, i, end))
                    return true;
            }
            return false;
        }
    }



    public class Question3 {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        public void dfs(char[][] grid, int i, int j) {
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                dfs(grid, i - 1, j);
                dfs(grid, i + 1, j);
                dfs(grid, i, j - 1);
                dfs(grid, i, j + 1);
            }
        }
    }



    public class Question4 {
        public int findCircleNum(int[][] isConnected) {
            int[] visited = new int[isConnected.length];
            int count = 0;
            for (int i = 0; i < isConnected.length; i++) {
                if (visited[i] == 0) {
                    dfs(isConnected, visited, i);
                    count++;
                }
            }
            return count;
        }

        public void dfs(int[][] isConnected, int[] visited, int i) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && visited[j] == 0) {
                    visited[j] = 1;
                    dfs(isConnected, visited, j);
                }
            }
        }
    }



    public class Question5 {
        public int countComponents(int n, int[][] edges) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>();
                graph.put(i, list);
            }
            for (int i = 0; i < edges.length; i++) {
                graph.get(edges[i][0]).add(edges[i][1]);
                graph.get(edges[i][1]).add(edges[i][0]);
            }

            boolean[] visit = new boolean[n];
            Arrays.fill(visit, false);
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    bfs(i, graph, visit);
                    count++;
                }
            }
            return count;

        }

        public void bfs(int i, Map<Integer, List<Integer>> graph, boolean[] visit) {
            if (visit[i]) {
                return;
            }
            visit[i] = true;
            List<Integer> list = graph.get(i);
            for (Integer n : list) {
                bfs((int) n, graph, visit);
            }
        }
    }



    public class Question6 {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int count = 0;
            int n = grid.length;
            int dir[] = {-1, 0, 1, 0, -1, 1, 1, -1, -1};

            if (grid[0][0] != 0) {
                return -1;
            }

            Queue<int[]> queue = new LinkedList();
            queue.add(new int[]{0, 0});
            grid[0][0] = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;
                for (int i = 0; i < size; i++) {
                    int[] node = queue.poll();
                    if (node[0] == n - 1 && node[1] == n - 1) {
                        return count;
                    }
                    for (int k = 0; k < 8; k++) {
                        int r = node[0] + dir[k];
                        int c = node[1] + dir[k + 1];
                        if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 0) {
                            grid[r][c] = 1;
                            queue.add(new int[]{r, c});
                        }
                    }
                }
            }
            return -1;
        }
    }



    public class Question7 {
        public int orangesRotting(int[][] grid) {
            int count = 0;
            Queue<int[]> queue = new LinkedList();

            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == 2)
                        queue.add(new int[]{i, j});
                    if (grid[i][j] == 1)
                        count ++;
                }
            }

            int time = 0;
            int [][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            while(!queue.isEmpty() && count > 0){
                time ++;
                int size = queue.size();
                while(size > 0){
                    int [] xy = queue.poll();
                    for(int [] d : directions){
                        int x = xy[0] + d[0];
                        int y = xy[1] + d[1];
                        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                                || grid[x][y] == 0 || grid[x][y] == 2)
                            continue;
                        queue.add(new int []{x, y});
                        grid[x][y] = 2;
                        count --;
                    }
                    size --;
                }
            }
            if (count != 0) {
                return -1;
            }
            return time;
        }
    }
}

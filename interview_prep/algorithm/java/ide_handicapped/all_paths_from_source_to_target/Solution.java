import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return new AbstractList<List<Integer>>() {
            private List<List<Integer>> paths;

            public List<Integer> get(final int index) {
                if (paths == null) {
                    solve();
                }
                return paths.get(index);
            }

            public int size() {
                if (paths == null) {
                    solve();
                }
                return paths.size();
            }

            private void solve() {
                paths = new ArrayList<>();
                dfs(
                        0,
                        graph.length - 1,
                        new boolean[graph.length],
                        new ArrayList<>() {
                            {
                                add(0);
                            }
                        });
            }

            private void dfs(int node, int target, boolean[] pass, List<Integer> path) {
                if (node == target) {
                    paths.add(new ArrayList<>(path));
                    return;
                }
                for (int v : graph[node]) {
                    path.add(v);
                    dfs(v, target, pass, path);
                    path.remove(path.size() - 1);
                }
            }
        };
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/all-paths-from-source-to-target/description/
        t1();
    }
 
    public static void t1() {
        final Solution sol = new Solution();
        final List res = sol.allPathsSourceTarget(new int[][] { 
            new int[]{1,2},
            new int[]{3},
            new int[]{3},
            new int[]{0}
        });
        assert res.contains(Stream.of(0, 1, 3).collect(Collectors.toList()));
        assert res.contains(Stream.of(0, 2, 3).collect(Collectors.toList()));
        // System.out.println(res);
    }

    
    
}
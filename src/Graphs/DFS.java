package Graphs;
import java.util.*;

public class DFS {
    public static void main(String[] args) {


    }
    public List<Integer> depthDive(int v, List<List<Integer>> adj){
        boolean[] vis = new boolean[v + 1];
        vis[0] = true;
        List<Integer> list = new ArrayList<>();
        dfs(0, vis, adj, list);
        return list;
    }
    private void dfs(int node, boolean[] vis, List<List<Integer>> adj, List<Integer> list){
        vis[node] = true;
        list.add(node);

        for (Integer val : adj.get(node)){
            if (!vis[val]){
                dfs(val, vis, adj, list);
            }
        }
    }
}

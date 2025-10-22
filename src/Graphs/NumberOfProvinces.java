package Graphs;
import java.util.*;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        // mat -> adj List;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[isConnected.length];
        int counter = 0;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]){
                counter++;
                depthDive(adj, vis, i);
            }
        }
        return counter;
    }

    private void depthDive(List<List<Integer>> adj, boolean[] vis, int val){
        vis[val] = true;
        for (int node : adj.get(val)){
            if (!vis[node]){
                depthDive(adj, vis, node);
            }
        }
    }
}

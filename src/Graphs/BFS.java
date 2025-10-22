package Graphs;
import java.util.*;
public class BFS {
    public static void main(String[] args) {

    }
    private List<Integer> leverOrder(int v, List<List<Integer>> adj){
        boolean[] visited = new boolean[v];
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();
        visited[0] = true;
        que.add(0);

        while (!que.isEmpty()){
            Integer node = que.poll();
            bfs.add(node);
            for (Integer val : adj.get(node)){
                if (!visited[val]){
                    que.add(val);
                    visited[val] = true;
                }
            }
        }
        return bfs;
    }
}

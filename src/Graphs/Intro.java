package Graphs;
import java.util.*;
public class Intro {
    // Ways to store graph : 1) Matrix  2) List

    // for two Nodes u and v, go and add like : mat[u][v] = 1 and mat[v][u] = 1;
    // 1 shows the connection between the two nodes, AND in case of Weighted graphs replace 1 with the given weight between two nodes
    // Ex : mat[u][v] = weight and mat[v][u] = weight;

    // List Example :

    // for Ex : Suppose 10 nodes are given;
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            graph.add(new ArrayList<>());
        }
        // showing the connection :
        int u = 1;
        int v = 3;
        graph.get(u).add(v);
        graph.get(v).add(u);


        System.out.println(graph);
    }


}

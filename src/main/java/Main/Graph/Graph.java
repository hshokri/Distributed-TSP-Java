package Main.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int start;
    private final int end;
    private final int[][] graph;
    private List<Integer> path;

    public Graph(int start, int end, int[]... g){
        this.start = start;
        this.end = end;
        this.graph = g;
        this.path = new ArrayList<>();

        var len = end - start + 1;
        int[][] w = new int[len][len];


        for(var i = 0; i < len; i++){
            for(var j = start; j < start + len; j++){
                w[i][j] = graph[i][j];
            }
        }

        var solver = new TSP(g);
        solver.getShortestPathCost();
        path = solver.getShortestPath();

    }

    public List<Integer> getTsp(){
        return path;
    }

    public boolean contains(int x){
        return x >= this.start && x < this.end;
    }
}

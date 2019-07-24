package graph.maxflow;

import java.util.*;

public class FordFulkerson {

    public int maxflow(int[][] capacity, int source, int sink) {
        int maxflow = 0;
        int[][] residualCapacity = new int[capacity.length][capacity[0].length];

        for (int i=0; i<capacity.length; i++) {
            for (int j = 0; j < capacity[0].length; j++) {
                residualCapacity[i][j] = capacity[i][j];
            }
        }

        Map<Integer, Integer> parent = new HashMap<>();

        List<List<Integer>> augmentedPaths = new ArrayList<>();

        while (bfs(residualCapacity, parent, source, sink)) {
            List<Integer> augmentedPath = new ArrayList<>();
            int flow = Integer.MAX_VALUE;

            int v = sink;
            while (v!=source) {
                augmentedPath.add(v);
                int u = parent.get(v);
                if(flow>residualCapacity[u][v])
                    flow = residualCapacity[u][v];
                v = u;
            }

            augmentedPath.add(source);
            Collections.reverse(augmentedPath);
            augmentedPaths.add(augmentedPath);

            v = sink;
            while (v!=source) {
                int u = parent.get(v);
                residualCapacity[u][v] -= flow;
                residualCapacity[v][u] += flow;
                v = u;
            }

            maxflow += flow;
        }

        printAugmentedPaths(augmentedPaths);
        return maxflow;
    }

    private boolean bfs(int[][] residualCapacity, Map<Integer, Integer> parent, int source, int sink){
        boolean foundAugmentedPath = false;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v=0; v<residualCapacity[u].length; v++){
                if(!visited.contains(v) && residualCapacity[u][v]>0) {
                    queue.add(v);
                    visited.add(v);
                    parent.put(v, u);

                    if(v==sink) {
                        foundAugmentedPath = true;
                        break;
                    }
                }
            }
        }

        return foundAugmentedPath;
    }

    private void printAugmentedPaths(List<List<Integer>> augmentedPaths){
        augmentedPaths.forEach(path->{
            path.forEach(v -> System.out.print(v+" "));
            System.out.println();
        });
    }

    public static void main(String[] args) {
        FordFulkerson fordFulkerson = new FordFulkerson();
        int[][] capacity = {
                {0, 3, 0, 3, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0},
                {3, 0, 0, 1, 2, 0, 0},
                {0, 0, 0, 0, 2, 6, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Max Flow: "+fordFulkerson.maxflow(capacity, 0, 6));

    }
}

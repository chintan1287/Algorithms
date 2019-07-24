package graph.shortestpath;

public class FloydWarshallAllPairShortestPath {

    private static final int INF = Integer.MAX_VALUE;

    public int[][] allPairShortestPath(int[][] distanceMetrics){
        int[][] distance = new int[distanceMetrics.length][distanceMetrics.length];
        int[][] path = new int[distance.length][distance.length];

        for (int i=0; i<distanceMetrics.length; i++) {
            for (int j=0; j<distanceMetrics[0].length; j++) {
                distance[i][j] = distanceMetrics[i][j];

                if(distance[i][j]!=INF && i!=j) path[i][j] = i;
                else path[i][j] = -1;
            }
        }

        for (int k=0; k<distanceMetrics.length; k++) {
            for (int i=0; i<distanceMetrics.length; i++) {
                for (int j=0; j<distanceMetrics[0].length; j++) {
                    if(distance[i][k] == INF || distance[k][j] == INF)
                        continue;

                    if(distance[i][j] > distance[i][k]+distance[k][j]) {
                        distance[i][j] = distance[i][k]+distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        for (int i=0; i<distance.length; i++) {
            if(distance[i][i] < 0) {
                // negative cycle exception
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };

        FloydWarshallAllPairShortestPath allPairShortestPath = new FloydWarshallAllPairShortestPath();
        int[][] distance = allPairShortestPath.allPairShortestPath(graph);

        System.out.println("Minimum Distance matrix");
        for(int i=0; i < distance.length; i++){
            for(int j=0; j < distance.length; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

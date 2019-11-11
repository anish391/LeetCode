import java.util.Arrays;

public class Dijkstra {
    static final int vertexes = 9;

    int minimumDistance(int[] dist, boolean[] shortestPathSet){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int v=0;v<vertexes;v++){
            if(!shortestPathSet[v] && dist[v]<=min){
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void printSolution(int dist[], int[] parent)
    {
        int src = 0;
        System.out.println("Vertex\t Distance\tPath");
        for (int i = 1; i < vertexes; i++)
        {
            System.out.print("\n"+src+" -> "+i+ "\t\t"+ dist[i]+"\t\t"+src+" ");
            printPath(parent, i);
        }
    }

    void printPath(int parent[], int j)
    {
        // Base Case : If j is source
        if(parent[j]==-1)
            return;
        printPath(parent, parent[j]);
        System.out.print(j+" ");
    }

    void dijkstra(int[][] graph, int src){

        int[] dist = new int[vertexes];
        boolean[] shortestPathSet = new boolean[vertexes];
        int[] parent = new int[vertexes];

        for(int v=0;v<vertexes;v++){
            dist[v] = Integer.MAX_VALUE;
            shortestPathSet[v] = false;
            parent[v] = -1;
        }

        dist[src] = 0;

        for(int count=0;count<vertexes-1;count++){
            int u = minimumDistance(dist, shortestPathSet);
            shortestPathSet[u] = true;

            for(int v=0;v<vertexes;v++){
                if(!shortestPathSet[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<=dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }
        printSolution(dist, parent);

    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra d = new Dijkstra();
        d.dijkstra(graph, 0);
    }
}

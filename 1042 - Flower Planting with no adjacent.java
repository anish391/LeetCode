class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap();
        int[] result = new int[N];
        for(int i=1;i<=N;i++)
            graph.put(i, new ArrayList<Integer>());
        for(int[] path: paths){
            int u = path[0];
            int v = path[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=1;i<=N;i++){
            // An array to represent if a previously used node has used a color.
            // Array is of size 5 to provide 1 indexing.
            boolean[] usedColors = new boolean[5];
            // Mark true is a previous node has used the color.
            for(int neighbors: graph.get(i))
                usedColors[result[neighbors-1]] = true;
            for(int c=4;c>0;c--)
                if(!usedColors[c])
                    result[i-1] = c;
        }
        return result;
    }
}
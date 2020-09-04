class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] indexes = new int[m];
        int[] result = new int[queries.length];
        LinkedList<Integer> queue = new LinkedList();
        for(int i=1;i<=m;i++){
            indexes[i-1] = i;
            queue.offer(i);
        }
        // System.out.println(queue);
        // System.out.println(Arrays.toString(indexes));
        for(int i=0;i<queries.length;i++){
            int currentNumber = queries[i];
            int currentIndex = queue.indexOf(currentNumber);
            queue.removeFirstOccurrence(currentNumber);
            queue.offerFirst(currentNumber);
            //System.out.println(queue);
            result[i] = currentIndex;
        }
        return result;
        
    }
}
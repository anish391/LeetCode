class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i: sticks)
            pq.offer(i);
        int result = 0;
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            result+= first+second;
            pq.offer(first+second);
        }
        return result;
    }
}
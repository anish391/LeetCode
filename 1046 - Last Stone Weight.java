class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        for(int i: stones)
            pq.add(i);
        for(int i=0;i<stones.length-1;i++)
            pq.offer(pq.poll()-pq.poll());
        return pq.poll();
    }
}
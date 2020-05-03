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

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
        for(int stone: stones){
            pq.offer(stone);
        }
        while(pq.size()>=2){
            int y = pq.poll();
            int x = pq.poll();
            if(y==x)
                continue;
            else
                pq.offer(y-x);
        }
        return pq.size()==1?pq.peek():0;
    }
}
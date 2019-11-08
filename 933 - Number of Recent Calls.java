# 

class RecentCounter {

    Queue<Integer> q;
    
    public RecentCounter() {
        q = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        q.add(t);
        if(q.peek()< t - 3000){
            q.poll();
        }
        return q.size();    
    }
}


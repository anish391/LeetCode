class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList();
        Queue<Integer> direQueue = new LinkedList();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R')
                radiantQueue.offer(i);
            else
                direQueue.offer(i);
        }
        while(!radiantQueue.isEmpty() && !direQueue.isEmpty()){
            int r_index = radiantQueue.poll();
            int d_index = direQueue.poll();
            if(r_index<d_index)
                radiantQueue.offer(r_index+senate.length());
            else
                direQueue.offer(d_index+senate.length());
        }
        return radiantQueue.size()>direQueue.size()?"Radiant":"Dire";
    }
}
class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length==0)
            return true;
        // A mapping between a frog on a stone and the locations the frog can jump to.
        Map<Integer, Set<Integer>> map = new HashMap();
        for(int i=0;i<stones.length;i++)
            map.put(stones[i], new HashSet());
        // Initally the frog is at stone 0 and can jump 1 distance. So it can reach stone 1 only.
        map.get(0).add(1);
        // We check up till second last stone in array and see if it reaches array.
        int lastStone = stones[stones.length-1];
        for(int i=0;i<stones.length-1;i++){
            int stone = stones[i];
            for(int step: map.get(stone)){
                int nextStone = stone+step;
                if(nextStone == lastStone)
                    return true;
                Set<Integer> jumpsTo = map.get(nextStone);
                if(jumpsTo != null){
                    if(step-1>0)
                        jumpsTo.add(step-1);
                    jumpsTo.add(step);
                    jumpsTo.add(step+1);
                }
            }
        }
        return false;
    }
}

// My process.
class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length>=2 && stones[0]+1!=stones[1] || stones[stones.length-1]==Integer.MAX_VALUE)
            return false;
        boolean[] hasStone = new boolean[stones[stones.length-1]+1];
        for(int stone: stones){
            hasStone[stone] = true;
        }
        return backtrack(stones, stones[stones.length-1], hasStone, 0, 1);
    }
    
    public boolean backtrack(int[] stones, int lastStone, boolean[] hasStone, int distance, int prevJump){
        if(distance==lastStone)
            return true;
        if(distance>lastStone)
            return false;
        boolean small = false, medium = false, large = false;
        int smallJump = distance+prevJump-1, mediumJump = distance+prevJump, largeJump = distance+prevJump+1;
        if(prevJump-1>0 && smallJump>=0 && smallJump<hasStone.length && hasStone[smallJump])
            small = backtrack(stones, lastStone, hasStone, smallJump, prevJump-1);
        if(mediumJump>=0 &&mediumJump<hasStone.length && hasStone[mediumJump])
            medium = backtrack(stones, lastStone, hasStone, mediumJump, prevJump);
        if(largeJump>=0 &&largeJump<hasStone.length && hasStone[largeJump])
            large = backtrack(stones, lastStone, hasStone, largeJump, prevJump+1);
        return small || medium || large;
    }
}
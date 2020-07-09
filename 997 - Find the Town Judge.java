class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for(int[] t: trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i=1;i<=N;i++)
            if(count[i]==N-1)
                return i;
        return -1;
    }
}

class Solution {
    public int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> indegree = new HashMap();
        Map<Integer, Integer> outdegree = new HashMap();
        
        for(int i=1;i<=N;i++){
            indegree.put(i,0);
            outdegree.put(i,0);
        }
        
        for(int[] t: trust){
            int personTrusts = t[0];
            int trustedPerson = t[1];
            indegree.put(trustedPerson, indegree.get(trustedPerson)+1);
            outdegree.put(personTrusts, outdegree.get(personTrusts)+1);
        }
        
        for(int i=1;i<=N;i++){
            if(indegree.get(i)==N-1 && outdegree.get(i)==0)
                return i;
        }
        return -1;
    }
}
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastSeen = new int[26];
        List<Integer> result = new ArrayList();
        for(int i=0;i<S.length();i++){
            lastSeen[S.charAt(i)-'a'] = i;
        }
        //System.out.println(Arrays.toString(lastSeen));
        int partitionEnd = 0;
        int partitionStart = 0;
        int currentPosition = 0;
        while(currentPosition<S.length()){
            partitionEnd = Math.max(partitionEnd, lastSeen[S.charAt(currentPosition)-'a']);
            if(partitionEnd == currentPosition){
                result.add(partitionEnd-partitionStart+1);
                partitionStart = partitionEnd+1;
            }
            currentPosition++;
        }
        return result;
    }
}
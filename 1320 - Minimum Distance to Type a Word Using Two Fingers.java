class Solution {
    
    Map<String, Integer> dp;
    
    public int minimumDistance(String word) {
        if(word==null || word.length()==0)
            return 0;
        dp = new HashMap();
        return backtrack(word, 0, -1, -1, -1, -1);
        
    }
    
    public int backtrack(String word, int index, int fX, int fY, int sX, int sY){
        if(index==word.length())
            return 0;
        String key = getKey(index, fX, fY, sX, sY);
        if(dp.containsKey(key))
            return dp.get(key);
        int distance;
        int[] cell = getCoord(word.charAt(index));
        int x = cell[0];
        int y = cell[1];
        if(fX==-1 && fY==-1)
            distance = backtrack(word, index+1, x, y, sX, sY);
        else if(sX==-1 && sY==-1)
            distance = Math.min(backtrack(word, index+1, fX, fY, x, y),
                                backtrack(word, index+1, x, y, sX, sY)+distance(x,y,fX,fY));
        else
            distance = Math.min(backtrack(word, index+1, fX, fY, x, y)+distance(x,y,sX,sY),
                                backtrack(word, index+1, x, y, sX, sY)+distance(x,y,fX,fY));
        dp.put(key, distance);
        return distance;
    }
    
    public String getKey(int index, int x1, int y1, int x2, int y2){
        StringBuilder sb = new StringBuilder();
        sb.append(index).append("#").append(x1).append("#").append(y1).append("#").append(x2).append("#").append(y2);
        return sb.toString();
    }
    
    public int[] getCoord(char ch){
        int position = ch-'A';
        int x = position/6;
        int y = position%6;
        return new int[]{x,y};
    }
    
    public int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
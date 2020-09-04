class TweetCounts {

    Map<String, TreeMap<Integer, Integer>> tweetMap;
    
    public TweetCounts() {
        tweetMap = new HashMap();
    }
    
    public void recordTweet(String tweetName, int time) {
        tweetMap.putIfAbsent(tweetName, new TreeMap());
        TreeMap<Integer, Integer> tweetTimes = tweetMap.get(tweetName);
        tweetTimes.put(time, tweetTimes.getOrDefault(time, 0)+1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        Map<Integer, Integer> tweetTime = tweetMap.get(tweetName);
        int interval;
        if(freq.equals("minute"))
            interval=60;
        else if(freq.equals("hour"))
            interval=3600;
        else 
            interval=86400;
        int size = ((endTime-startTime)/interval) + 1;
        int[] buckets = new int[size];
        Map<Integer, Integer> requiredTimes = tweetMap.get(tweetName).subMap(startTime, endTime+1);
        for(Map.Entry<Integer, Integer> entry: requiredTimes.entrySet()){
            int index = (entry.getKey() - startTime)/interval;
            buckets[index] += entry.getValue();
        }
        List<Integer> result = new ArrayList();
        for(int bucket: buckets)
            result.add(bucket);
        return result;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
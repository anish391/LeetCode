class Twitter {

    private class Tweet{
        int tweetId;
        int time;
        
        public Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<Tweet>> tweetMap;
    int time;
    final static int maxFeedTweets = 10;
        
    /** Initialize your data structure here. */
    public Twitter() {
        this.followerMap = new HashMap();
        this.tweetMap = new HashMap();
        this.time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList());
            follow(userId, userId);
        }
        Tweet tweet = new Tweet(tweetId, time);
        tweetMap.get(userId).add(0,tweet);
        this.time++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList();
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>((t1,t2)->t1.time-t2.time);
        Set<Integer> followers = followerMap.get(userId);
        if(followers!=null){
            for(int followerId: followers){
                List<Tweet> tweets = tweetMap.get(followerId);
                if(tweets!=null){
                    for(Tweet tweet: tweets){
                        if(pq.size()<maxFeedTweets){
                            pq.offer(tweet);
                        }
                        else{
                            if(tweet.time<=pq.peek().time){
                                break;
                            }
                            else{
                                pq.offer(tweet);
                                pq.poll();
                                
                            }
                        }
                    }
                }
            }
        }
        while(!pq.isEmpty()){
            result.add(pq.poll().tweetId);
        }
        Collections.reverse(result);
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet());
        followerMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId) && followerId!=followeeId){
            followerMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
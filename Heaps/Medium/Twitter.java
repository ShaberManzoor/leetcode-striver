package Heaps.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {

    private static int timeStamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next; //points to next tweet of user

        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
        }
    }

    private Map<Integer, Set<Integer>> followMap; //{user, user following list}
    private Map<Integer, Tweet> tweetMap; //{user, user tweets list}

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);

        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        PriorityQueue<Tweet> recentTweets = new PriorityQueue<>((a, b) -> b.time - a.time); //stores the tweet from latest to old

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for(int followeeId: followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)) {
                recentTweets.add(tweetMap.get(followeeId));
            }
        }

        while (!recentTweets.isEmpty() && feed.size()<10) {
            Tweet curr = recentTweets.poll();

            feed.add(curr.id);
            if(curr.next!=null){
                recentTweets.offer(curr.next);
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId) && followeeId!=followerId){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

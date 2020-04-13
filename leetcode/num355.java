package leetcode;
/**
 * 设计推特
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class num355 {

}
class Post{
    int userId;
    int tweetId;
    public Post(int userid, int tweetid){
        this.userId = userid;
        this.tweetId = tweetid;
    }
}

class Twitter {
    List<Post> posts = new LinkedList<>();
    Map<Integer, Set<Integer>> users = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Post post = new Post(userId, tweetId);
        posts.add(0, post);
        if(!users.containsKey(userId)){
            users.put(userId, new HashSet<>());
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        int count = 0;
        List<Integer> result = new LinkedList<>();
        if(posts.size() == 0 || !users.containsKey(userId)) return result;
        for(Post p:posts){
            if(p.userId == userId || users.get(userId).contains(p.userId)){
                result.add(p.tweetId);
                count ++;
            }
            if(count == 10) break;
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
            users.get(followerId).add(followeeId);
        }else{
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            users.put(followerId, set);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
            users.get(followerId).remove(followeeId);
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
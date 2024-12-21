package ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 maxTokens = the max number of request a user can make in the timePeriod
 reillRate = the Rate which the tokens are getting refilled ( eg 1 token per second)
 buckets = a Map to store the token bucket for each user


 UserBucket Classs
 Manages token for specific  User
 tryconsumer = attempts to consume a token  Returns True if successfull otherwise false
 refill() refill the tokens  bucket at defined intervals to Max Limit


 Refill Scheduler
  A scheduled Task that refills all user Buckets at regular intervals
 */
public class UserTokenRateLimiter {
    private int maxTokens ;
    private  int refillRate ;
    private final Map<String, UserBucket> buckets = new ConcurrentHashMap<>();
// Map to store Token Bucket for each User
    public UserTokenRateLimiter(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::refillBuckets, 0, 1, TimeUnit.SECONDS);
    }
 public  boolean allowRequest(final String userId){
        final UserBucket bucket = buckets.computeIfAbsent(userId , k-> new UserBucket(maxTokens));
        return  bucket.tryConsumer();
 }
    private void refillBuckets() {
        buckets.values().forEach(UserBucket::refill);
    }

    private class UserBucket{
        private  int tokens;

        public UserBucket(int tokens) {
            this.tokens = tokens;
        }
        public synchronized  boolean tryConsumer() {
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }
        public synchronized void refill (){
            tokens= Math.min(tokens+refillRate , maxTokens);
        }
    }

    public static void main(String[] args) {
        UserTokenRateLimiter userTokenRateLimiter = new UserTokenRateLimiter(10, 1);
        //10 request per seccond
        String userId  = "User1" ;
        for(int  i =0; i< 10; ++i){
            System.out.println("Request "+ (i+1) + " : "+ userTokenRateLimiter.allowRequest(userId) );
        }
        System.out.println("====Request now again "+ userTokenRateLimiter.allowRequest(userId) );

    }
}

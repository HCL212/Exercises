/* Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume 
 * that calls are being made to the system in chronological order (ie, the timestamp is 
 * monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * EXAMPLE:
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * 
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301); 
 */

import java.util.*; 
  
// O(1) hits
// O(s) getHits (s is total seconds in interval, 300 in this case)
class HitCounter {

    /** Initialize your data structure here. */
    private int[] times;
    private int[] hits;
    
    public HitCounter() {
        // allocate 300 to each (for last 5 minutes)
        times = new int[300];
        hits = new int[300];
    }
    
    // Record a hit.
    // @param timestamp - The current timestamp (in seconds granularity). 
    public void hit(int timestamp) {
        // keeping track of last 5 minutes only
        // 300 seconds, so we timestamp % 300 for
        // later timestamps (past 5 mins) to get correct index
        int index = timestamp % 300;
        
        // if the time doesn't match, we passed the 5 min mark
        if (times[index] != timestamp){
            times[index] = timestamp;
            hits[index] = 1; // reset the hit counter
        } else {
            hits[index]++; // add to hit counter
        }
    }
    
    // Return the number of hits in the past 5 minutes.
    // @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int totalHits = 0;
        
        for (int i = 0; i < 300; i++){
            // checks if times[i] is within 5 min interval
            if (timestamp - times[i] < 300){
                totalHits += hits[i];
            }
        }
        
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
